var validator;
var $compProductAddForm = $("#compProduct-add-form");
$(function () {
    //文件上传
    var option = {
        language: "zh",
        showCaption: false,
        showRemove: false,
        showUpload: false,
        showCancel: false,
        showClose: false,
        maxFileCount: 1,
        removeFromPreviewOnError: true,
        overwriteInitial: true,
        showUploadedThumbs: false,
        autoReplace: true,
        layoutTemplates: {progress: '', actions: ''},
        uploadUrl: ctx + "/file/upload/single",
        uploadExtraData: {
            relative: "test"
        },
        allowedFileTypes: ["image"],
        allowedFileExtensions: ["jpg", "png", "gif"],
        maxFileSize: 5000
    };

    $("#pictureFile").fileinput(option).on('fileloaded', function (event) {
        $(this).fileinput('upload');
    }).on('fileuploaded', function (event, data) {
        var response = data.response;
        //文件上传自定义参数返回码
        var returnCode = response.returnCode;
        if ("1" == returnCode) {
            //成功
            //设置成功的自定义文件保存位置
            $("#picture").val(response.filePreviewPath);
        } else {
            //失败
            console.log(response.msg);
        }
    });

    $("#save-button").click(function () {
        var name = $(this).attr("name");
        var validator = $compProductAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name === "save") {
                $.post(ctx + "compProduct/add", $compProductAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("compProductTable");
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name === "update") {
                $.post(ctx + "compProduct/update", $compProductAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("compProductTable");
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#compProduct-add .btn-close").click(function () {
        closeModal();
    });

    $("#queryButton").click(function () {
        $("#modelId").val("#compProduct-add");
    })
});

function closeModal() {
    $("#save-button").attr("name", "save");
    $("#compProduct-add-modal-title").html('新增竞争产品');
    $MB.closeAndRestModal("compProduct-add");
}





$(function () {
    $("#add").click(function () {
        var docId = $compProductAddForm.find("input[name=docId]").val();
        var docName = $compProductAddForm.find("input[name=docName]").val();
        initFile(docId,docName);
    });

    $("#update").click(function () {
        var selected = $("#compProductTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要修改的竞争产品！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能修改一个竞争产品！');
            return;
        }
        var compProductId = selected[0].compProductId;
        $.post(ctx + "compProduct/getCompProduct", {"compProductId": compProductId}, function (r) {
            if (r.code === 0) {
                var $form = $('#compProduct-add');
                $form.modal();
                var compProduct = r.msg;
                $("#compProduct-add-modal-title").html('修改竞争产品');
                $form.find("input[name='compProductId']").val(compProduct.compProductId);
                $form.find("input[name='buildingNo']").val(compProduct.buildingNo);
                $form.find("input[name='buildingName']").val(compProduct.buildingName);
                $form.find("input[name='buildingId']").val(compProduct.buildingId);
                $form.find("input[name='introduction']").val(compProduct.introduction);
                $form.find("select[name='operator']").val(compProduct.operator);
                $form.find("select[name='businessType']").val(compProduct.businessType);
                $form.find("input[name='docId']").val(compProduct.docId);
                $form.find("input[name='docName']").val(compProduct.docName);
                initFile(compProduct.docId,compProduct.docName);
                $("#save-button").attr("name", "update");
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });

    function initFile(docId,docName) {
        //文件上传
        var option;
        if (docId && docId !== "") {
            option = {
                language: "zh",
                showCaption: false,
                showPreview: true,
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
                uploadUrl: ctx + "compProduct/upload",
                uploadExtraData: {},
                initialPreview: [
                    "<img src='compProduct/downloadDoc?docId=" + docId + "' " +
                    "class='file-preview-image' alt='Desert' title='Desert' height='100%'  width='100%'>"
                ],
                initialPreviewConfig: [
                    {
                        caption: docName,
                        width: '120px',
                        frameAttr: {
                            style: 'height:199px',
                            title: 'My Custom Title'
                        }
                    }
                ],
                allowedFileTypes: ["image"],
                allowedFileExtensions: ["jpg", "png", "gif"],
                maxFileSize: 5000
            };
        } else {
            option = {
                language: "zh",
                showCaption: false,
                showPreview: true,
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
                uploadUrl: ctx + "compProduct/upload",
                uploadExtraData: {},
                allowedFileTypes: ["image"],
                allowedFileExtensions: ["jpg", "png", "gif"],
                maxFileSize: 5000
            };
        }

        $("#pictureFile").fileinput(option).on('fileloaded', function (event) {
            $(this).fileinput('upload');
        }).on('fileuploaded', function (event, data) {
            var response = data.response;
            //文件上传自定义参数返回码
            var returnCode = response.code;
            if (0 === returnCode) {
                $compProductAddForm.find("input[name='uploadFlag']").val("1");
                $compProductAddForm.find("input[name='docName']").val(response.msg);
                //成功
                $MB.n_warning('上传成功！');
            } else {
                //失败
                $MB.n_warning('上传失败！请联系网站管理员');
            }
        });
    }

});

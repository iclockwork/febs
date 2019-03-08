var validator;
var $compProductAddForm = $("#compProduct-add-form");
$(function () {
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
        $("#modalId").val("#compProduct-add");
    });

    function closeModal() {
        $("#save-button").attr("name", "save");
        $("#compProduct-add-modal-title").html('新增竞争产品');
        $MB.closeAndRestModal("compProduct-add");

        if ($("#pictureFile").data('fileinput')) {
            $("#pictureFile").fileinput('destroy');
        }
    }

    validateRule();

    function validateRule() {
        var icon = "<i class='zmdi zmdi-close-circle zmdi-hc-fw'></i> ";
        validator = $compProductAddForm.validate({
            rules: {
                buildingNo: {
                    required: true
                },
                operator: {
                    required: true
                },
                businessType: {
                    required: true
                }
            },
            messages: {
                buildingNo:  icon + "请选择楼宇",
                operator: icon + "请选择运营商",
                businessType: icon + "请选择业务类型"
            }
        });
    }

});







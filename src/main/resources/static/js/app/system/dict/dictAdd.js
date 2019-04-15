var validator;
var $dictAddForm = $("#dict-add-form");

$(function () {
    validateRule();

    $("#dict-add .btn-save").click(function () {
        var name = $(this).attr("name");
        validator = $dictAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name === "save") {
                $.post(ctx + "dict/add", $dictAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name === "update") {
                $.post(ctx + "dict/update", $dictAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#dict-add .btn-close").click(function () {
        closeModal();
    });

    $("#dict-add .close").click(function () {
        closeModal();
    });

});

function closeModal() {
    $("#dict-add-button").attr("name", "save");
    $("#dict-add-modal-title").html('新增字典');
    validator.resetForm();
    $MB.closeAndRestModal("dict-add");
}

function validateRule() {
    var icon = "<i class='zmdi zmdi-close-circle zmdi-hc-fw'></i> ";
    validator = $dictAddForm.validate({
        rules: {
            key: {
                required: true,
                digits: true,
                maxlength: 10
            },
            value: {
                required: true,
                maxlength: 100
            },
            tableName: {
                required: true,
                maxlength: 100
            },
            fieldName: {
                required: true,
                maxlength: 100
            }
        },
        messages: {
            key: {
                required: icon + "请输入键名",
                digits: icon + "请输入整数",
                maxlength: icon + "长度不能超过10个字符"
            },
            value: {
                required: icon + "请输入键值",
                maxlength: icon + "长度不能超过100个字符"
            },
            tableName: {
                required: icon + "请输入关联表名",
                maxlength: icon + "长度不能超过100个字符"
            },
            fieldName: {
                required: icon + "请输入字段名",
                maxlength: icon + "长度不能超过100个字符"
            }
        }
    });
}
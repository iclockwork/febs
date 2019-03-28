$(function () {
    var $editForm = $("#modal-customerBusiness-edit-form");

    var icon = "<i class='zmdi zmdi-close-circle zmdi-hc-fw'></i> ";
    var validator = $editForm.validate({
        rules: {
            businessType: {
                required: true
            },
            businessPhone: {
                required: true
            },
            monthFee: {
                required: true,
                number: true,
                range: [0, 1000000000000]
            }
        },
        errorPlacement: function (error, element) {
            if (element.is(":checkbox") || element.is(":radio")) {
                error.appendTo(element.parent().parent());
            } else {
                error.insertAfter(element);
            }
        },
        messages: {}
    });

    function save() {
        var customerBusinessModalMode = $("#customerBusinessModalMode").val();
        var flag = $editForm.validate().form();
        if (flag) {
            if (customerBusinessModalMode === "add") {
                $.post(ctx + "customerBusiness/add", $editForm.serialize(), function (r) {
                    if (r.code === 0) {
                        $('#modal-customerBusiness-edit').modal('hide');
                        $MB.n_success(r.msg);
                        $MB.refreshTable("customerBusinessTable");
                    } else $MB.n_danger(r.msg);
                });
            } else if (customerBusinessModalMode === "update") {
                $.post(ctx + "customerBusiness/update", $editForm.serialize(), function (r) {
                    if (r.code === 0) {
                        $('#modal-customerBusiness-edit').modal('hide');
                        $MB.n_success(r.msg);
                        $MB.refreshTable("customerBusinessTable");
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    }

    function init() {
        var customerBusinessModalMode = $("#customerBusinessModalMode").val();
        if (customerBusinessModalMode === "add") {
        } else if (customerBusinessModalMode === "update") {
            var customerBusinessId = $editForm.find("input[name='customerBusinessId']").val();
            $.post(ctx + "customerBusiness/getCustomerBusiness", {customerBusinessId: customerBusinessId}, function (r) {
                if (r.code === 0) {
                    var customerBusiness = r.msg;
                    $editForm.find("select[name='businessType']").val(customerBusiness.businessType);
                    $editForm.find("input[name='businessPhone']").val(customerBusiness.businessPhone);
                    $editForm.find("input[name='monthFee']").val(customerBusiness.monthFee);
                } else {
                    $MB.n_danger(r.msg);
                }
            });
        }
    }

    $(".customerBusiness-save").click(function () {
        save();
    });

    //打开事件
    $('#modal-customerBusiness-edit').on('show.bs.modal', function (event) {
        init();
    });

    //隐藏事件
    $('#modal-customerBusiness-edit').on('hidden.bs.modal', function (event) {
        //重置
        validator.resetForm();
        $editForm[0].reset();
    });
});
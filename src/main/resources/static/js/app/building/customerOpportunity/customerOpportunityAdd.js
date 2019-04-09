var validator;
var $customerOpportunityAddForm = $("#customerOpportunity-add-form");
$(function () {

    $("#save-button").click(function () {
        var name = $(this).attr("name");
        var validator = $customerOpportunityAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name === "save") {
                $.post(ctx + "customerOpportunity/add", $customerOpportunityAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("customerOpportunityTable");
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name === "update") {
                $.post(ctx + "customerOpportunity/update", $customerOpportunityAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("customerOpportunityTable");
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#customerOpportunity-add .btn-close").click(function () {
        closeModal();
    });

    $("#customerOpportunity-add .close").click(function () {
        closeModal();
    });

    $("#queryButton").click(function () {
        $("#modalId").val("#customerOpportunity-add");
        $("#formId").val("#customerOpportunity-add-form");
    });

    function closeModal() {
        $("#save-button").attr("name", "save");
        $("#customerOpportunity-add-modal-title").html('新增竞争产品');
        var validator = $customerOpportunityAddForm.validate();
        validator.resetForm();
        $MB.closeAndRestModal("customerOpportunity-add");
    }

    validateRule();

    function validateRule() {
        var icon = "<i class='zmdi zmdi-close-circle zmdi-hc-fw'></i>";
        validator = $customerOpportunityAddForm.validate({
            rules: {
                buildingNo: {
                    required: true
                },
                customerName: {
                    required: true
                },
                floorNumber: {
                    required: true,
                    digits: true,
                    max:100
                },
                roomNumber: {
                    required: true,
                    digits: true
                },
                customerType: {
                    required: true
                },
                customerIndustry: {
                    required: true
                },
                competitorName: {
                    required: true
                },
                competitorType: {
                    required: true
                },
                competitorEnd: {
                    required: true
                },
                keyPerson: {
                    required: true
                },
                propertyManagerContact: {
                    digits: true
                }
            },
            messages: {
                buildingNo:  icon + "请选择楼宇",
                customerName: icon + "客户名称不能为空",
                floorNumber: {
                    required: icon + "楼层数不能为空",
                    digits: icon + "只能输入数字"

                },
                roomNumber: {
                    required: icon + "房间号不能为空",
                    digits: icon + "只能输入数字"
                },
                customerType: icon + "客户类型不能为空",
                customerIndustry:  icon + "客户行业不能为空",
                competitorName: icon + "竞争对手名称不能为空",
                competitorType: icon + "竞争对手业务类型不能为空",
                competitorEnd: icon + "竞争对手合同到期情况不能为空",
                keyPerson:icon + "客户联系人不能为空",
                propertyManagerContact : icon + "只能输入数字"

            }
        });
    }
});






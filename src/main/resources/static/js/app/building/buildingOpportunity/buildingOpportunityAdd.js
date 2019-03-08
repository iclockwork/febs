var validator;
var $buildingOpportunityAddForm = $("#buildingOpportunity-add-form");
$(function () {
    $("#save-button").click(function () {
        var name = $(this).attr("name");
        var validator = $buildingOpportunityAddForm.validate();
        $buildingOpportunityAddForm.find("input[name=regionId]").val($("#qx").val());
        var flag = validator.form();
        if (flag) {
            if (name === "save") {
                $.post(ctx + "buildingOpportunity/add", $buildingOpportunityAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("buildingOpportunityTable");
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name === "update") {
                $.post(ctx + "buildingOpportunity/update", $buildingOpportunityAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("buildingOpportunityTable");
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#buildingOpportunity-add .btn-close").click(function () {
        closeModal();
    });

    function closeModal() {
        $("#save-button").attr("name", "save");
        $("#buildingOpportunity-add-modal-title").html('新增商机楼宇');
        $MB.closeAndRestModal("buildingOpportunity-add");
    }

    validateRule();

    function validateRule() {
        var icon = "<i class='zmdi zmdi-close-circle zmdi-hc-fw'></i> ";
        validator = $buildingOpportunityAddForm.validate({
            rules: {
                ds: {
                    required: true
                },
                qx: {
                    required: true
                },
                buildingLevel: {
                    required: true
                },
                buildingType: {
                    required: true
                },
                buildingTypeName: {
                    required: true
                },
                buildingAddress: {
                    required: true
                },
                buildingName: {
                    required: true
                },
                floorNumber: {
                    required: true,
                    digits: true,
                    max:100
                },
                area: {
                    required: true,
                    number: true
                },
                householderNumber: {
                    required: true,
                    digits: true
                },
                propertyManagerContact: {
                    digits: true
                }
            },
            messages: {
                ds:  icon + "请选择地市",
                qx: icon + "请选择区县",
                buildingLevel: icon + "请选择楼宇等级",
                buildingType:  icon + "请选择楼宇所属区域类型",
                buildingTypeName: icon + "楼宇所属区域名称不能为空",
                buildingAddress: icon + "楼宇地址不能为空",
                buildingName: icon + "楼宇名称不能为空",
                floorNumber: {
                    required: icon + "楼层数不能为空",
                    digits: icon + "只能输入数字"

                },
                area: {
                    required: icon + "建筑面积（万m2）不能为空",
                    number: "请输入有效的数字"
                },
                householderNumber:{
                    required: icon + "商户数（户）不能为空",
                    digits: icon + "只能输入数字"
                },
                propertyManagerContact : icon + "只能输入数字"

            }
        });
    }
});





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

});





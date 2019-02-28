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

    $("#queryButton").click(function () {
        $("#modelId").val("#customerOpportunity-add");
    })
});

function closeModal() {
    $("#save-button").attr("name", "save");
    $("#customerOpportunity-add-modal-title").html('新增竞争产品');
    $MB.closeAndRestModal("customerOpportunity-add");
}





$(function () {
    $("#update").click(function () {
        var selected = $("#customerOpportunityTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要修改的商机客户！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能修改一个商机客户！');
            return;
        }
        var customerId = selected[0].customerId;
        $.post(ctx + "customerOpportunity/getCustomerOpportunity", {"customerId": customerId}, function (r) {
            if (r.code === 0) {
                var $form = $('#customerOpportunity-add');
                $form.modal();
                var customerOpportunity = r.msg;
                $("#customerOpportunity-add-modal-title").html('修改商机客户');
                $form.find("input[name='customerId']").val(customerOpportunity.customerId);
                $form.find("input[name='buildingNo']").val(customerOpportunity.buildingNo);
                $form.find("input[name='buildingName']").val(customerOpportunity.buildingName);
                $form.find("input[name='buildingId']").val(customerOpportunity.buildingId);
                $form.find("input[name='customerName']").val(customerOpportunity.customerName);
                $form.find("input[name='floorNumber']").val(customerOpportunity.floorNumber);
                $form.find("input[name='roomNumber']").val(customerOpportunity.roomNumber);
                $form.find("input[name='customerType']").val(customerOpportunity.customerType);
                $form.find("input[name='customerIndustry']").val(customerOpportunity.customerIndustry);
                $form.find("input[name='competitorName']").val(customerOpportunity.competitorName);
                $form.find("input[name='competitorType']").val(customerOpportunity.competitorType);
                $form.find("input[name='competitorEnd']").val(customerOpportunity.competitorEnd);
                $form.find("input[name='keyPerson']").val(customerOpportunity.keyPerson);
                $form.find("input[name='keyPersonContact']").val(customerOpportunity.keyPersonContact);
                $("#save-button").attr("name", "update");
            } else {
                $MB.n_danger(r.msg);
            }
        });
    })
});

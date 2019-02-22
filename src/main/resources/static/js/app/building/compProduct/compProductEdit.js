function updateBusinessOpportunity() {
    var selected = $("#businessOpportunityTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要修改的用户！');
        return;
    }
    if (selected_length > 1) {
        $MB.n_warning('一次只能修改一个用户！');
        return;
    }
    var businessOpportunityId = selected[0].businessOpportunityId;
    $.post(ctx + "businessOpportunity/getBusinessOpportunity", {"businessOpportunityId": businessOpportunityId}, function (r) {
        if (r.code === 0) {
            var $form = $('#businessOpportunity-add');
            $form.modal();
            var businessOpportunity = r.msg;
            $form.find("#businessOpportunityId").hide();
            $("#businessOpportunity-add-modal-title").html('修改商机');
            $form.find("input[name='buildingNo']").val(businessOpportunity.buildingNo);
            $form.find("input[name='buildingName']").val(businessOpportunity.buildingName);
            $form.find("input[name='keyPerson']").val(businessOpportunity.keyPerson);
            $form.find("input[name='keyPersonContact']").val(businessOpportunity.keyPersonContact);
            $form.find("input[name='introduction']").val(businessOpportunity.introduction);
            $form.find("select[name='businessSource']").val(businessOpportunity.businessSource);
            $form.find("select[name='businessType']").val(businessOpportunity.businessType);
            $form.find("select[name='state']").val(businessOpportunity.state);
            $form.find("input[name='signStaffName']").val(businessOpportunity.signStaffName);
            $form.find("input[name='signDate']").val(businessOpportunity.signDate);
            if ($("select[name='state']").val()==='3') {
                $('#signStaff').show();
                $('#signStaff2').show();
            }
            $("#save-button").attr("name", "update");
        } else {
            $MB.n_danger(r.msg);
        }
    });
}
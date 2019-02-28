$(function () {
    $("#update").click(function () {
        var selected = $("#buildingOpportunityTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要修改的商机楼宇！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能修改一个商机楼宇！');
            return;
        }
        var buildingId = selected[0].buildingId;
        $.post(ctx + "buildingOpportunity/getBuildingOpportunity", {"buildingId": buildingId}, function (r) {
            if (r.code === 0) {
                var $form = $('#buildingOpportunity-add');
                $form.modal();
                var buildingOpportunity = r.msg;
                $("#buildingOpportunity-add-modal-title").html('修改商机楼宇');
                $form.find("input[name='buildingId']").val(buildingOpportunity.buildingId);
                $form.find("select[name='buildingLevel']").val(buildingOpportunity.buildingLevel);
                $form.find("select[name='buildingType']").val(buildingOpportunity.buildingType);
                $form.find("input[name='buildingTypeName']").val(buildingOpportunity.buildingTypeName);
                $form.find("input[name='buildingAddress']").val(buildingOpportunity.buildingAddress);
                $form.find("input[name='buildingName']").val(buildingOpportunity.buildingName);
                $form.find("input[name='floorNumber']").val(buildingOpportunity.floorNumber);
                $form.find("input[name='area']").val(buildingOpportunity.area);
                $form.find("input[name='householderNumber']").val(buildingOpportunity.householderNumber);
                $form.find("input[name='propertyCompany']").val(buildingOpportunity.propertyCompany);
                $form.find("input[name='propertyManager']").val(buildingOpportunity.propertyManager);
                $form.find("input[name='propertyManagerContact']").val(buildingOpportunity.propertyManagerContact);
                $("#save-button").attr("name", "update");
            } else {
                $MB.n_danger(r.msg);
            }
        });
    })
});

$(function () {
    $("#update").click(function () {
        var selected = $("#buildingOpportunityTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要修改的用户！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能修改一个用户！');
            return;
        }
        var compProductId = selected[0].compProductId;
        $.post(ctx + "buildingOpportunity/getBuildingOpportunity", {"compProductId": compProductId}, function (r) {
            if (r.code === 0) {
                var $form = $('#buildingOpportunity-add');
                $form.modal();
                var compProduct = r.msg;
                $("#buildingOpportunity-add-modal-title").html('修改竞争产品');
                $form.find("input[name='compProductId']").val(compProduct.compProductId);
                $form.find("input[name='buildingNo']").val(compProduct.buildingNo);
                $form.find("input[name='buildingName']").val(compProduct.buildingName);
                $form.find("input[name='buildingId']").val(compProduct.buildingId);
                $form.find("input[name='introduction']").val(compProduct.introduction);
                $form.find("select[name='operator']").val(compProduct.operator);
                $form.find("select[name='businessType']").val(compProduct.businessType);
                $form.find("input[name='input2']").val(compProduct.input2);
                $("#save-button").attr("name", "update");
            } else {
                $MB.n_danger(r.msg);
            }
        });
    })
});

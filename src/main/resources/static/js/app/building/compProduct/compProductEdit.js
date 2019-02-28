$(function () {
    $("#update").click(function () {
        var selected = $("#compProductTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要修改的竞争产品！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能修改一个竞争产品！');
            return;
        }
        var compProductId = selected[0].compProductId;
        $.post(ctx + "compProduct/getCompProduct", {"compProductId": compProductId}, function (r) {
            if (r.code === 0) {
                var $form = $('#compProduct-add');
                $form.modal();
                var compProduct = r.msg;
                $("#compProduct-add-modal-title").html('修改竞争产品');
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

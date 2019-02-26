$(function () {
    $("#update").click(function () {
        var selected = $("#customerExpirationTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要修改的用户！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能修改一个用户！');
            return;
        }
        var customerExpirationId = selected[0].customerExpirationId;
        $.post(ctx + "customerExpiration/getCustomerExpiration", {"customerExpirationId": customerExpirationId}, function (r) {
            if (r.code === 0) {
                var $form = $('#customerExpiration-add');
                $form.modal();
                var customerExpiration = r.msg;
                $("#customerExpiration-add-modal-title").html('修改客户到期');
                $form.find("input[name='customerExpirationId']").val(customerExpiration.customerExpirationId);
                $form.find("input[name='buildingNo']").val(customerExpiration.buildingNo);
                $form.find("input[name='buildingName']").val(customerExpiration.buildingName);
                $form.find("input[name='buildingId']").val(customerExpiration.buildingId);
                $form.find("input[name='customerName']").val(customerExpiration.customerName);
                $form.find("select[name='remindFlag']").val(customerExpiration.remindFlag);
                $form.find("input[name='remindDate']").val(customerExpiration.remindDate);
                if ($("select[name='remindFlag']").val()==='1') {
                    $('#remindId').show();
                }
                $("#save-button").attr("name", "update");
            } else {
                $MB.n_danger(r.msg);
            }
        });
    })
});

$(function () {
    var $modal = $('#buildingCustomerRp-query-modal');

    //打开事件
    $modal.on('show.bs.modal', function (event) {
        var buildingId = $modal.attr("buildingId");
        var buildingNo = $modal.attr("buildingNo");
        if (buildingNo) {
            $modal.find("input[name='buildingNo']").attr("disabled", "true");
            $modal.find("input[name='buildingNo']").val(buildingNo);
            $modal.find("input[name='buildingNo']").attr("buildingId", buildingId);
            $modal.find("input[name='buildingNo']").attr("initValue", buildingNo);

            $(".buildingCustomerRp-search").trigger("click");
        }

        var customerId = $modal.attr("customerId");
        var customerNo = $modal.attr("customerNo");
        if (customerNo) {
            $modal.find("input[name='customerNo']").attr("disabled", "true");
            $modal.find("input[name='customerNo']").val(customerNo);
            $modal.find("input[name='customerNo']").attr("customerId", customerId);
            $modal.find("input[name='customerNo']").attr("initValue", customerNo);

            $(".buildingCustomerRp-search").trigger("click");
        }
    });

    //隐藏事件
    $modal.on('hidden.bs.modal', function (event) {
        $.utils.toggleBodyModal();
    });
});
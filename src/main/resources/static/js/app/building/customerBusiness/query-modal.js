$(function () {
    var $modal = $('#customerBusiness-query-modal');

    //打开事件
    $modal.on('show.bs.modal', function (event) {
        var customerNo = $modal.attr("customerNo");
        if (customerNo) {
            $modal.find("input[name='customerNo']").attr("disabled", "true");
            $modal.find("input[name='customerNo']").val(customerNo);
            $modal.find("input[name='customerNo']").attr("initValue", customerNo);

            $(".customerBusiness-search").trigger("click");
        }
    });

    //隐藏事件
    $modal.on('hidden.bs.modal', function (event) {
        $.utils.toggleBodyModal();
    });
});
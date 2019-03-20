$(function () {
    var $modal = $('#address-select-modal');

    //打开事件
    $modal.on('show.bs.modal', function (event) {
        var segmType = $modal.attr("segmType");
        if (segmType) {
            $modal.find("select[name='segmType']").attr("disabled", "true");
            $modal.find("select[name='segmType']").val(segmType);
            $modal.find("select[name='segmType']").attr("initValue", segmType);
            $(".address-search").trigger("click");
        }
    });

    //隐藏事件
    $modal.on('hidden.bs.modal', function (event) {
        $.utils.toggleBodyModal();
    });
});
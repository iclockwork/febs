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
        var parentSegmIdRecursive = $modal.attr("parentSegmIdRecursive");
        var parentSegmNameRecursive = $modal.attr("parentSegmNameRecursive");
        if (parentSegmNameRecursive) {
            $modal.find("input[name='parentSegmIdRecursive']").val(parentSegmIdRecursive);
            $modal.find("input[name='parentSegmIdRecursive']").attr("initValue", parentSegmIdRecursive);
            $modal.find("input[name='parentSegmNameRecursive']").attr("disabled", "true");
            $modal.find("input[name='parentSegmNameRecursive']").val(parentSegmNameRecursive);
            $modal.find("input[name='parentSegmNameRecursive']").attr("initValue", parentSegmNameRecursive);

            $modal.find("input[name='standName']").val(null);

            $(".address-search").trigger("click");
        }
    });

    //隐藏事件
    $modal.on('hidden.bs.modal', function (event) {
        $.utils.toggleBodyModal();
    });
});
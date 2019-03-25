$(function () {
    var $modal = $('#inspection-query-modal');

    //打开事件
    $modal.on('show.bs.modal', function (event) {
        var inspectionType = $modal.attr("inspectionType");
        var inspectionNo = $modal.attr("inspectionNo");
        if (inspectionType) {
            $modal.find("select[name='inspectionType']").attr("disabled", "true");
            $modal.find("select[name='inspectionType']").val(inspectionType);
            $modal.find("select[name='inspectionType']").attr("initValue", inspectionType);

            $modal.find("input[name='inspectionNo']").attr("disabled", "true");
            $modal.find("input[name='inspectionNo']").val(inspectionNo);
            $modal.find("input[name='inspectionNo']").attr("initValue", inspectionNo);

            $(".inspection-search").trigger("click");
        }
    });

    //隐藏事件
    $modal.on('hidden.bs.modal', function (event) {
        $.utils.toggleBodyModal();
    });
});
$(function () {
    var $modal = $('#building-select-modal');

    //打开事件
    $modal.on('show.bs.modal', function (event) {
        var state = $modal.attr("state");
        if (state) {
            $modal.find("select[name='state']").attr("disabled", "true");
            $modal.find("select[name='state']").val(state);
            $modal.find("select[name='state']").attr("initValue", state);
            $(".building-search").trigger("click");
        }
    });

    //隐藏事件
    $modal.on('hidden.bs.modal', function (event) {
        $.utils.toggleBodyModal();
    });
});
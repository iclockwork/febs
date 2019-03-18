$(function () {
    var $modal = $('#room-select-modal');

    //打开事件
    $modal.on('show.bs.modal', function (event) {

    });

    //隐藏事件
    $modal.on('hidden.bs.modal', function (event) {
        $.utils.toggleBodyModal();
    });
});
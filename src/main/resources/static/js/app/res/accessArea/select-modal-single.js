$(function () {
    //打开事件
    $('#accessArea-select-modal').on('show.bs.modal', function (event) {

    });

    //隐藏事件
    $('#accessArea-select-modal').on('hidden.bs.modal', function (event) {
        $.utils.toggleBodyModal();
    });
});
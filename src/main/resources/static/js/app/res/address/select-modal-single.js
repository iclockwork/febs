$(function () {
    //打开事件
    $('#address-select-modal').on('show.bs.modal', function (event) {

    });

    //隐藏事件
    $('#address-select-modal').on('hidden.bs.modal', function (event) {
        $.utils.toggleBodyModal();
    });
});
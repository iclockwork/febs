(function ($) {
    $.extend({
        utils: {}
    });

    /**
     * 提示
     */
    $.utils.tipsNetSlow = "网络迟缓，请刷新页面重试！";

    /**
     * 单选
     */
    $.utils.selectModeSingle = "single";

    /**
     * 多选
     */
    $.utils.selectModeMultiple = "multiple";

    /**
     * 临时解决多modal窗口滚动条不滚动问题
     */
    $.utils.toggleBodyModal = function () {
        $('body').toggleClass('modal-open', $('.modal').hasClass('show'));
    };

    /**
     * 导出
     */
    $.utils.exportFile = function (url, param) {
        $.post(url, param, function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    };
})(jQuery);
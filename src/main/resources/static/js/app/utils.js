(function ($) {
    $.extend({
        utils: {}
    });

    /**
     * 单选
     */
    $.utils.selectModeSingle = "single";

    /**
     * 多选
     */
    $.utils.selectModeMultiple = "multiple";

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
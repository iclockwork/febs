(function ($) {
    $.extend({
        region: {}
    });

    /**
     * 地市级别
     */
    $.region.grade_id_ds = "2000004";

    /**
     * 区县级别
     */
    $.region.grade_id_qx = "2000011";

    function _initDs(ds, dsCallback, qx, qxCallback) {
        ds.empty();
        $.post(ctx + "region/options", {
            gradeId: $.region.grade_id_ds
        }, function (r) {
            if (r.code === 0) {
                var data = r.msg;
                var html = [];
                html.push("<option value='' selected>---请选择---</option>");
                for (var i = 0; i < data.length; i++) {
                    var isSelectStr = "";
                    if (G_REGION_ID === data[i].regionId) {
                        isSelectStr = "selected=true";
                        ds.attr("disabled", "disabled");
                    }
                    html.push("<option value='" + data[i].regionId + "' " + isSelectStr + ">" + data[i].regionName + "</option>");
                }
                ds.append(html.join(''));

                dsCallback.call();

                ds.unbind('change').change(function () {
                    _initQx(ds, dsCallback, qx, qxCallback);
                });

                _initQx(ds, dsCallback, qx, qxCallback);
            } else {
                $MB.n_danger(r.msg);
            }
        });
    }

    function _initQx(ds, dsCallback, qx, qxCallback) {
        qx.empty();
        if (null !== ds.val() && "" !== ds.val()) {
            $.post(ctx + "region/options", {
                gradeId: $.region.grade_id_qx,
                superRegionId: ds.val()
            }, function (r) {
                if (r.code === 0) {
                    var data = r.msg;
                    var html = [];
                    html.push("<option value='' selected>---请选择---</option>");
                    for (var i = 0; i < data.length; i++) {
                        html.push("<option value='" + data[i].regionId + "'>" + data[i].regionName + "</option>");
                    }
                    qx.append(html.join(''));

                    qxCallback.call();
                } else {
                    $MB.n_danger(r.msg);
                }
            });
        }
    }

    /**
     * 初始化地市区县
     */
    $.region.initDsQx = function (ds, dsCallback, qx, qxCallback) {
        _initDs(ds, dsCallback, qx, qxCallback);
    };
})(jQuery);
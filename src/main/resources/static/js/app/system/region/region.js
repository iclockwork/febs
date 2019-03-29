(function ($) {
    $.extend({
        region: {}
    });

    /**
     * 地市级别
     */
    $.region.gradeIdDs = "2000004";

    /**
     * 区县级别
     */
    $.region.gradeIdQx = "2000011";

    /**
     * 表格内容
     */
    $.region.tableColumns = [{
        field: 'regionName',
        title: '区域名称'
    }, {
        field: 'regionNo',
        title: '区域编码'
    }, {
        field: 'chinaNameAb',
        title: '区域简称'
    }, {
        field: 'superRegionName',
        title: '上级区域'
    }, {
        field: 'gradeName',
        title: '区域等级'
    }, {
        field: 'address',
        title: '区域中心地址'
    }, {
        field: 'createDate',
        title: '创建时间'
    }];

    function _initDs(ds, dsCallback, qx, qxCallback) {
        if (ds.length > 0) {
            ds.empty();
            $.post(ctx + "region/options", {
                gradeId: $.region.gradeIdDs
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

                    if (qx.length > 0) {
                        ds.unbind('change').change(function () {
                            _initQx(ds, dsCallback, qx, qxCallback);
                        });

                        _initQx(ds, dsCallback, qx, qxCallback);
                    }
                } else {
                    $MB.n_danger(r.msg);
                }
            });
        }
    }

    function _initQx(ds, dsCallback, qx, qxCallback) {
        if (qx.length > 0) {
            qx.empty();
            if (null !== ds.val() && "" !== ds.val()) {
                $.post(ctx + "region/options", {
                    gradeId: $.region.gradeIdQx,
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
    }

    /**
     * 初始化地市区县
     */
    $.region.initDsQx = function (ds, dsCallback, qx, qxCallback) {
        _initDs(ds, dsCallback, qx, qxCallback);
    };
})(jQuery);
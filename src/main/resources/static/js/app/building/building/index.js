$(function () {
    var settings = {
        url: ctx + "building/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                dsRegionId: $("#ds").val(),
                regionId: $("#qx").val(),
                buildingName: $(".building-table-form").find("input[name='buildingName']").val().trim()
            };
        },
        columns: [{
            field: 'dsRegionName',
            title: '地市'
        }, {
            field: 'regionName',
            title: '区县'
        }, {
            field: 'buildingNo',
            title: '楼宇编码'
        }, {
            field: 'buildingName',
            title: '楼宇名称'
        }, {
            field: 'buildingLevelName',
            title: '楼宇等级'
        }, {
            field: 'buildingTypeDesc',
            title: '楼宇所属区域类型'
        }, {
            field: 'buildingTypeName',
            title: '楼宇所属区域名称'
        }, {
            field: 'buildingAddress',
            title: '楼宇地址'
        }, {
            field: 'longitude',
            title: '经度'
        }, {
            field: 'latitude',
            title: '纬度'
        }, {
            field: 'floorNumber',
            title: '楼层数'
        }, {
            field: 'area',
            title: '建筑面积（万m2）'
        }, {
            field: 'householderNumber',
            title: '商户数（户）'
        }, {
            field: 'propertyCompany',
            title: '物业单位'
        }, {
            field: 'propertyManager',
            title: '物业联系人'
        }, {
            field: 'propertyManagerContact',
            title: '物业联系人电话'
        }, {
            field: 'buildingManager',
            title: '楼长'
        }, {
            field: 'stateName',
            title: '楼宇状态'
        }, {
            field: 'remark',
            title: '备注'
        }, {
            field: 'standName',
            title: '标准地址'
        }, {
            field: 'accessAreaName',
            title: '综合业务接入区'
        }, {
            field: 'roomName',
            title: '综合业务接入机房'
        }, {
            field: 'lightName',
            title: '光交名称'
        }, {
            field: 'lightAddress',
            title: '光交地址'
        }, {
            field: 'lightLongitude',
            title: '光交经度'
        }, {
            field: 'lightLatitude',
            title: '光交纬度'
        }, {
            field: 'roomCabinetFlagName',
            title: '是否有机房/机柜'
        }, {
            field: 'cableAccessFlagName',
            title: '光缆资源是否接入'
        }, {
            field: 'cableNumber',
            title: '进楼光缆条数'
        }, {
            field: 'cableRemainNumber',
            title: '空余芯数'
        }, {
            field: 'verticalCoverageFlagName',
            title: '是否具备垂直覆盖'
        }, {
            field: 'horizontalCoverageFlagName',
            title: '是否具备水平覆盖'
        }, {
            field: 'coverageMethodName',
            title: '楼宇覆盖方式'
        }, {
            field: 'cooperationMethodName',
            title: '合作方式'
        }, {
            field: 'indoorDistributionFlagName',
            title: '是否具备室分'
        }, {
            field: 'coverageNetworkStandardName',
            title: '已覆盖网络制式'
        }, {
            field: 'wlanFlagName',
            title: 'WLAN是否已覆盖'
        }, {
            field: 'createStaffName',
            title: '录入人'
        }, {
            field: 'createDate',
            title: '录入时间'
        }]
    };

    function search() {
        $MB.refreshTable('buildingTable');
    }

    function refresh() {
        $(".building-table-form")[0].reset();
        search();
    }

    function exportFile(fileType) {
        var url = ctx + "building/excel";
        if ("excel" === fileType) {
            url = ctx + "building/excel";
        } else if ("csv" === fileType) {
            url = ctx + "building/csv";
        }
        $.post(url, $(".building-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    function initDs() {
        var _ds = $("#ds");
        _ds.empty();
        $.post(ctx + "region/options", {
            gradeId: "2000004"
        }, function (r) {
            if (r.code === 0) {
                var data = r.msg;
                var html = [];
                html.push("<option value='' selected>---请选择---</option>");
                for (var i = 0; i < data.length; i++) {
                    var isSelectStr = "";
                    if (G_REGION_ID === data[i].regionId) {
                        isSelectStr = "selected=true";
                        $("#ds").attr("disabled", "disabled");
                    }
                    html.push("<option value='" + data[i].regionId + "' " + isSelectStr + ">" + data[i].regionName + "</option>");
                }
                _ds.append(html.join(''));

                _ds.change(function () {
                    initQx();
                });

                initQx();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    }

    function initQx() {
        var _ds = $("#ds");
        var _qx = $("#qx");
        _qx.empty();
        if (null !== _ds.val() && "" !== _ds.val()) {
            $.post(ctx + "region/options", {
                gradeId: "2000011",
                superRegionId: $("#ds").val()
            }, function (r) {
                if (r.code === 0) {
                    var data = r.msg;
                    var html = [];
                    html.push("<option value='' selected>---请选择---</option>");
                    for (var i = 0; i < data.length; i++) {
                        html.push("<option value='" + data[i].regionId + "'>" + data[i].regionName + "</option>");
                    }
                    _qx.append(html.join(''));
                } else {
                    $MB.n_danger(r.msg);
                }
            });
        }
    }

    $MB.initTable('buildingTable', settings);

    $(".zmdi-search").click(function () {
        search();
    });

    $(".zmdi-refresh-alt").click(function () {
        refresh();
    });

    $("#exportExcel").click(function () {
        exportFile("excel")
    });

    $("#exportCsv").click(function () {
        exportFile("csv")
    });

    initDs();
});
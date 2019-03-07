$(function () {
    var $buildingOpportunityTableForm = $(".buildingOpportunity-table-form");
    var settings = {
        url: ctx + "buildingOpportunity/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                dsRegionId: $("#dsId").val(),
                regionId: $("#qxId").val(),
                buildingName: $buildingOpportunityTableForm.find("input[name='buildingName']").val().trim()
            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'buildingId',
            visible: false
        }, {
            field: 'dsRegionName',
            title: '地市'
        }, {
            field: 'regionName',
            title: '区县'
        }, {
            field: 'buildingLevel',
            title: '楼宇等级',
            formatter: function (value, row, index) {
                if (value === '1') return 'A';
                else if (value === '2') return 'B';
                else if (value === '3') return 'C';
                else return '其他';
            }
        }, {
            field: 'buildingType',
            title: '楼宇所属区域类型',
            formatter: function (value, row, index) {
                if (value === 'SQLY') return '商务楼宇';
                else if (value === 'SQYQ') return '园区';
                else if (value === 'SQSC') return '专业市场';
                else if (value === 'SQSS') return '厂企宿舍';
                else if (value === 'SQWB') return '网吧';
                else if (value === 'SQJD') return '宾馆酒店';
                else if (value === 'SQQT') return '商企其他';
            }
        }, {
            field: 'buildingTypeName',
            title: '楼宇所属区域名称'
        }, {
            field: 'buildingAddress',
            title: '楼宇地址'
        },{
            field: 'buildingName',
            title: '楼宇名称'
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
        }]
    };

    $MB.initTable('buildingOpportunityTable', settings);

    $("#search").click(function () {
        $MB.refreshTable('buildingOpportunityTable');
    });

    $("#refresh").click(function () {
        refresh();
    });


$("#delete").click(function () {

    var selected = $("#buildingOpportunityTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的商机楼宇！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].buildingId;
        if (i !== (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "确定删除选中商机楼宇？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'buildingOpportunity/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
});

    $("#exportExcel").click(function () {
        $.post(ctx + "buildingOpportunity/excel", $(".buildingOpportunityt-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    });

    $("#exportCsv").click(function () {
        $.post(ctx + "buildingOpportunity/csv", $(".buildingOpportunity-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    });

    function initDs() {
        var _ds = $("#dsId");
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
                        $("#dsId").attr("disabled", "disabled");
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
        var _ds = $("#dsId");
        var _qx = $("#qxId");
        _qx.empty();
        if (null !== _ds.val() && "" !== _ds.val()) {
            $.post(ctx + "region/options", {
                gradeId: "2000011",
                superRegionId: $("#dsId").val()
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

    initDs();

    function refresh() {
        $(".buildingOpportunity-table-form")[0].reset();
        $MB.refreshTable('buildingOpportunityTable');
    }
});
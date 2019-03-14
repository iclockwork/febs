$(function () {
    var $form = $(".building-table-form");
    var $ds = $form.find("select[name='dsRegionId']");
    var $qx = $form.find("select[name='regionId']");

    var settings = {
        url: ctx + "building/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                dsRegionId: $ds.val(),
                regionId: $qx.val(),
                buildingNo: $form.find("input[name='buildingNo']").val().trim(),
                buildingName: $form.find("input[name='buildingName']").val().trim(),
                buildingType: $form.find("select[name='buildingType']").val(),
                buildingTypeName: $form.find("input[name='buildingTypeName']").val().trim(),
                buildingAddress: $form.find("input[name='buildingAddress']").val().trim(),
                state: $form.find("select[name='state']").val()
            };
        },
        columns: [{
            checkbox: true
        }, {
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
            field: 'buildingManagerContact',
            title: '楼长电话'
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
        $form[0].reset();
        search();
    }

    function exportFile(fileType) {
        var url = ctx + "building/excel";
        if ("excel" === fileType) {
            url = ctx + "building/excel";
        } else if ("csv" === fileType) {
            url = ctx + "building/csv";
        }
        $.post(url, $form.serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    function openUpdate() {
        var selected = $("#buildingTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要修改的楼宇！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能修改一个楼宇！');
            return;
        }
        var buildingId = selected[0].buildingId;
        $("#modal-building-edit-form").find("input[name='buildingId']").val(buildingId)
        $("#buildingModalMode").val("update");
        $("#modal-building-edit-title").html('修改楼宇');
        $('#modal-building-edit').modal('show');
    }

    function del() {
        var selected = $("#buildingTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        var contain = false;
        if (!selected_length) {
            $MB.n_warning('请勾选需要删除的楼宇！');
            return;
        }
        var buildingIds = "";
        for (var i = 0; i < selected_length; i++) {
            buildingIds += selected[i].buildingId;
            if (i !== (selected_length - 1)) buildingIds += ",";
        }

        $MB.confirm({
            text: "确定删除选中楼宇？",
            confirmButtonText: "确定删除"
        }, function () {
            $.post(ctx + 'building/delete', {buildingIds: buildingIds}, function (r) {
                if (r.code === 0) {
                    $MB.n_success(r.msg);
                    refresh();
                } else {
                    $MB.n_danger(r.msg);
                }
            });
        });
    }

    $MB.initTable('buildingTable', settings);

    $(".building-search").click(function () {
        search();
    });

    $(".building-refresh").click(function () {
        refresh();
    });

    $(".building-export-excel").click(function () {
        exportFile("excel")
    });

    $(".building-export-csv").click(function () {
        exportFile("csv")
    });

    $(".building-add").click(function () {
        $("#buildingModalMode").val("add");
        $("#modal-building-edit-title").html('新增楼宇');
        $('#modal-building-edit').modal('show');
    });

    $(".building-update").click(function () {
        openUpdate();
    });

    $(".building-delete").click(function () {
        del();
    });

    $.region.initDsQx($ds, function () {
    }, $qx, function () {
    });
});
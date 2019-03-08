$(function () {
    var settings = {
        url: ctx + "building/list",
        pageSize: 5,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                buildingNo: $(".building-table-form").find("input[name='buildingNo']").val().trim(),
                buildingName: $(".building-table-form").find("input[name='buildingName']").val().trim()
            };
        },
        columns: [{
            checkbox: true
        },{
            field: 'buildingId',
            visible: false
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
        $MB.refreshTable('queryBuildingTable');
    }

    function refresh() {
        $(".building-table-form")[0].reset();
        search();
    }

    $MB.initTable('queryBuildingTable', settings);

    $(".zmdi-search").click(function () {
        search();
    });

    $(".zmdi-refresh-alt").click(function () {
        refresh();
    });


    $("#determine-button").click(function () {
        var selected = $("#queryBuildingTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要的楼宇！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能选择一个楼宇信息！');
            return;
        }
        var buildingId = selected[0].buildingId;
        $.post(ctx + "building/getBuilding", {"buildingId": buildingId}, function (r) {
            if (r.code === 0) {
                var isModal = $("#modalId").val();
                var $modal = $(isModal);
                var building = r.msg;
                $modal.find("input[name='buildingNo']").val(building.buildingNo);
                $modal.find("input[name='buildingName']").val(building.buildingName);
                $modal.find("input[name='buildingId']").val(building.buildingId);
                closeModal();
            } else {
                $MB.n_danger(r.msg);
            }
        })
    });

    $("#queryBuilding-modal .btn-close").click(function () {
        closeModal();
    });

    function closeModal() {
        $("#queryBuilding-modal-title").html('楼宇查询');
        refresh();
        setTimeout(function(){
            $('body').addClass('modal-open');
        },500);
        $MB.closeAndRestModal("queryBuilding-modal");
    }
});
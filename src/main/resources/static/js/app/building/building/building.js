(function ($) {
    $.extend({
        building: {}
    });

    /**
     * 表格内容
     */
    $.building.tableColumns = [{
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
        field: 'inspectionTotal',
        title: '巡检记录',
        formatter: function (value, row, index) {
            if (value && value > 0) {
                return '<a href="javascript:void(0)" class="operate-inspection">' + value + '</a>';
            } else {
                return value
            }
        },
        events: {
            'click .operate-inspection': function (e, value, row, index) {
                $.inspection.view(1, row.buildingNo);
            }
        }
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
    }];

    /**
     * 初始化
     */
    $.building.init = function () {

    };
})(jQuery);
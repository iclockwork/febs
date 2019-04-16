$(function () {
    var $modal = $('#modal-building-view');
    var $paneBuildingForm = $('#modal-building-view-pane-building-form');
    var $paneResForm = $('#modal-building-view-pane-res-form');

    var customerBusinessTotalChart;

    var customerBusinessMonthFeeChart;

    function init() {
        buildCustomerBusinessTotalChart();
        buildCustomerBusinessMonthFeeChart();
        loadPaneBuildingAndRes();
        loadPaneCustomer();
        loadPaneBusiness();
    }

    function buildCustomerBusinessTotalChart() {
        var buildingId = $modal.attr("buildingId");
        var buildingNo = $modal.attr("buildingNo");

        var labels = [], zxData = [], kdData = [], ghData = [], yData = [], ywData = [], dlData = [];
        $.post(ctx + "customerBusiness/countByBuilding", {buildingNo: buildingNo}, function (r) {
            if (r.code === 0) {
                var list = r.msg;
                if (list && list.length > 0) {
                    // labels.push(buildingNo);
                    for (var i = 0; i < list.length; i++) {
                        var businessType = list[i].businessType;
                        switch (businessType) {
                            case 1:
                                zxData.push(list[i].count);
                                break;
                            case 2:
                                kdData.push(list[i].count);
                                break;
                            case 3:
                                ghData.push(list[i].count);
                                break;
                            case 4:
                                yData.push(list[i].count);
                                break;
                            case 5:
                                ywData.push(list[i].count);
                                break;
                            case 6:
                                dlData.push(list[i].count);
                                break;
                            default:
                                break;
                        }
                    }
                }

                newCustomerBusinessChart('customerBusinessTotalChart', customerBusinessTotalChart, '客户业务量（条）', labels, zxData, kdData, ghData, yData, ywData, dlData)
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    function buildCustomerBusinessMonthFeeChart() {
        var buildingId = $modal.attr("buildingId");
        var buildingNo = $modal.attr("buildingNo");

        var labels = [], zxData = [], kdData = [], ghData = [], yData = [], ywData = [], dlData = [];
        $.post(ctx + "customerBusiness/sumMonthFeeByBuilding", {buildingNo: buildingNo}, function (r) {
            if (r.code === 0) {
                var list = r.msg;
                if (list && list.length > 0) {
                    // labels.push(buildingNo);
                    for (var i = 0; i < list.length; i++) {
                        var businessType = list[i].businessType;
                        switch (businessType) {
                            case 1:
                                zxData.push(list[i].monthFee);
                                break;
                            case 2:
                                kdData.push(list[i].monthFee);
                                break;
                            case 3:
                                ghData.push(list[i].monthFee);
                                break;
                            case 4:
                                yData.push(list[i].monthFee);
                                break;
                            case 5:
                                ywData.push(list[i].monthFee);
                                break;
                            case 6:
                                dlData.push(list[i].monthFee);
                                break;
                            default:
                                break;
                        }
                    }
                }

                newCustomerBusinessChart('customerBusinessMonthFeeChart', customerBusinessMonthFeeChart, '客户业务收入（元）', labels, zxData, kdData, ghData, yData, ywData, dlData)
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    function removeChartData(chart) {
        if (chart) {
            chart.data.labels.pop();
            var datasets = chart.data.datasets;
            for (var i = 0; i < datasets.length; i++) {
                datasets[i].data.pop();
            }
            chart.update();
        }
    }

    function newCustomerBusinessChart(chartId, chart, yLabelString, labels, zxData, kdData, ghData, yData, ywData, dlData) {
        var tempData = {
            labels: labels,
            datasets: [{
                label: "专线业务",
                data: zxData,
                backgroundColor: "#00c0ef"
            }, {
                label: "宽带业务",
                data: kdData,
                backgroundColor: "#338aff"
            }, {
                label: "固话业务",
                data: ghData,
                backgroundColor: "#80c14a"
            }, {
                label: "云业务",
                data: yData,
                backgroundColor: "#cf706c"
            }, {
                label: "移网业务",
                data: ywData,
                backgroundColor: "#bb7cc1"
            }, {
                label: "电路业务",
                data: dlData,
                backgroundColor: "#f400ae"
            }]
        };

        var options = {
            //是否显示柱状图上面的数据
            scaleOverlay: true,
            //是否显示label值
            scaleShowLabels: true,
            scales: {
                xAxes: [{
                    display: true
                }],
                yAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true,
                        labelString: yLabelString
                    }
                }]
            }
        };
        var canvas = $("#" + chartId).get(0).getContext("2d");
        chart = new Chart(canvas, {
            type: 'bar',
            data: tempData,
            options: options
        });
    }

    function loadPaneBuildingAndRes() {
        var buildingId = $modal.attr("buildingId");
        $.post(ctx + "building/getBuilding", {buildingId: buildingId}, function (r) {
            if (r.code === 0) {
                var building = r.msg;
                $paneBuildingForm.find("input[name='dsRegionName']").val(building.dsRegionName);
                $paneBuildingForm.find("input[name='regionName']").val(building.regionName);
                $paneBuildingForm.find("input[name='buildingLevelName']").val(building.buildingLevelName);
                $paneBuildingForm.find("input[name='buildingTypeDesc']").val(building.buildingTypeDesc);
                $paneBuildingForm.find("input[name='buildingTypeName']").val(building.buildingTypeName);
                $paneBuildingForm.find("input[name='buildingAddress']").val(building.buildingAddress);
                $paneBuildingForm.find("input[name='buildingNo']").val(building.buildingNo);
                $paneBuildingForm.find("input[name='buildingName']").val(building.buildingName);
                $paneBuildingForm.find("input[name='longitude']").val(building.longitude);
                $paneBuildingForm.find("input[name='latitude']").val(building.latitude);
                $paneBuildingForm.find("input[name='floorNumber']").val(building.floorNumber);
                $paneBuildingForm.find("input[name='area']").val(building.area);
                $paneBuildingForm.find("input[name='householderNumber']").val(building.householderNumber);
                $paneBuildingForm.find("input[name='propertyCompany']").val(building.propertyCompany);
                $paneBuildingForm.find("input[name='propertyManager']").val(building.propertyManager);
                $paneBuildingForm.find("input[name='propertyManagerContact']").val(building.propertyManagerContact);
                $paneBuildingForm.find("input[name='buildingManager']").val(building.buildingManager);
                $paneBuildingForm.find("input[name='buildingManagerContact']").val(building.buildingManagerContact);
                $paneBuildingForm.find("input[name='stateName']").val(building.stateName);
                $paneBuildingForm.find("input[name='remark']").val(building.remark);
                $paneResForm.find("input[name='standName']").val(building.standName);
                $paneResForm.find("input[name='accessAreaName']").val(building.accessAreaName);
                $paneResForm.find("input[name='roomName']").val(building.roomName);
                $paneResForm.find("input[name='lightName']").val(building.lightName);
                $paneResForm.find("input[name='lightAddress']").val(building.lightAddress);
                $paneResForm.find("input[name='lightLongitude']").val(building.lightLongitude);
                $paneResForm.find("input[name='lightLatitude']").val(building.lightLatitude);
                $paneResForm.find("input[name='roomCabinetFlagName']").val(building.roomCabinetFlagName);
                $paneResForm.find("input[name='cableAccessFlagName']").val(building.cableAccessFlagName);
                $paneResForm.find("input[name='cableNumber']").val(building.cableNumber);
                $paneResForm.find("input[name='cableRemainNumber']").val(building.cableRemainNumber);
                $paneResForm.find("input[name='verticalCoverageFlagName']").val(building.verticalCoverageFlagName);
                $paneResForm.find("input[name='horizontalCoverageFlagName']").val(building.horizontalCoverageFlagName);
                $paneResForm.find("input[name='coverageMethodName']").val(building.coverageMethodName);
                $paneResForm.find("input[name='cooperationMethodName']").val(building.cooperationMethodName);
                $paneResForm.find("input[name='indoorDistributionFlagName']").val(building.indoorDistributionFlagName);
                $paneResForm.find("input[name='coverageNetworkStandardName']").val(building.coverageNetworkStandardName);
                $paneResForm.find("input[name='wlanFlagName']").val(building.wlanFlagName);
            } else {
                $MB.n_danger(r.msg);
            }
        });
    }

    function loadPaneCustomer() {
        var buildingId = $modal.attr("buildingId");
        var buildingNo = $modal.attr("buildingNo");
        var settings = {
            url: ctx + "buildingCustomerRp/list",
            pageSize: 5,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    dsRegionId: null,
                    regionId: null,
                    buildingNo: buildingNo,
                    buildingName: null,
                    customerNo: null,
                    customerName: null
                };
            },
            columns: [{
                field: 'standName',
                title: '九级地址名称'
            }, {
                field: 'customerNo',
                title: '客户编码'
            }, {
                field: 'customerName',
                title: '客户名称'
            }, {
                field: 'keyPerson',
                title: '客户联系人'
            }, {
                field: 'keyPersonContact',
                title: '客户联系电话'
            }, {
                field: 'monthFee',
                title: '月费'
            }, {
                field: 'remark',
                title: '备注'
            }]
        };

        $MB.initTable('modal-building-view-pane-customer-table', settings);
    }

    function loadPaneBusiness() {
        var buildingId = $modal.attr("buildingId");
        var buildingNo = $modal.attr("buildingNo");
        var settings = {
            url: ctx + "customerBusiness/listByBuilding",
            pageSize: 5,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    buildingNo: buildingNo
                };
            },
            columns: [{
                field: 'customerNo',
                title: '客户编码'
            }, {
                field: 'customerName',
                title: '客户名称'
            }, {
                field: 'businessTypeName',
                title: '业务类型'
            }, {
                field: 'businessPhone',
                title: '业务号码'
            }, {
                field: 'monthFee',
                title: '月费'
            }]
        };

        $MB.initTable('modal-building-view-pane-business-table', settings);
    }

    //打开事件
    $modal.on('show.bs.modal', function (event) {
        var buildingId = $modal.attr("buildingId");
        if (buildingId) {
            init();
        }

        $("#tab-home").trigger("click");
    });

    //隐藏事件
    $modal.on('hidden.bs.modal', function (event) {
        $.utils.toggleBodyModal();

        removeChartData(customerBusinessTotalChart);
        removeChartData(customerBusinessMonthFeeChart);
        $('#modal-building-view-pane-customer-table').bootstrapTable('destroy');
        $('#modal-building-view-pane-business-table').bootstrapTable('destroy');
    });
});
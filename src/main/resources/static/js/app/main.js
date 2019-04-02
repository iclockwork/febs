$(function () {

    //楼宇总量统计
    $.post(ctx + "building/count", "", function (r) {
        if (r.code === 0) {
            $("#buildingId").html(r.msg);
        } else {
            $MB.n_warning(r.msg);
        }
    });

    //客户总量统计
    $.post(ctx + "customer/count", "", function (r) {
        if (r.code === 0) {
            $("#customerId").html(r.msg);
        } else {
            $MB.n_warning(r.msg);
        }
    });

    //客户业务量统计
    $.post(ctx + "customerBusiness/count", "", function (r) {
        if (r.code === 0) {
            $("#customerBusinessId").html(r.msg);
        } else {
            $MB.n_warning(r.msg);
        }
    });

    //费用统计
    $.post(ctx + "customerFee/count", "", function (r) {
        if (r.code === 0) {
            $("#feeId").html(r.msg);
        } else {
            $MB.n_warning(r.msg);
        }
    });

    function buildBarCustomerChart() {
        var businessData = [];
        //客户各业务量统计
        $.post(ctx + "business/count", "", function (r) {
            if (r.code === 0) {
                var jsonDatas = r.msg;
                 businessData = jsonDatas.business;
            } else {
                $MB.n_warning(r.msg);
            }

            var tempData = {
                labels: ["专线业务","宽带业务","固话业务","云业务","移网业务","电路业务"],
                datasets: [{
                    label: "客户业务量",
                    data: businessData,
                    backgroundColor: "#00c0ef"
                }]
            };

            var options = {
                //是否显示柱状图上面的数据
                scaleOverlay: true,
                //是否显示label值
                scaleShowLabels: true,
                //设置标题
                title: {
                    display: true,
                    fontColor: 'red',
                    fontSize: 18,
                    text: '楼长客户各业务量统计图'
                },
                scales: {
                    xAxes: [{
                        display: true,
                        barPercentage: 0.5,
                        scaleLabel: {
                            display: true,
                            fontColor: 'red',
                            fontSize: 18,
                            labelString: '客户业务名称'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            fontColor: 'red',
                            fontSize: 18,
                            labelString: '客户业务量（条）'
                        }
                    }]
                }
            };

            var canvas = $("#barCustomerChart").get(0).getContext("2d");
            var chart = new Chart(canvas, {
                type: 'bar',
                data: tempData,
                options: options
            });
        });

    }

    buildBarCustomerChart();
    buildBarChart();

    function buildBarChart() {

        // 将获取到的json数据分别存放到数组中
        var labels = [], zxData = [], kdData = [], ghData = [], yData = [], ywData = [], dlData = [];
        //各楼宇客户业务量统计
        $.post(ctx + "buildingBusiness/count", "", function (r) {
            if (r.code === 0) {
                var jsonDatas = r.msg;
                if (jsonDatas && jsonDatas.length === 0){
                    return;
                }
                for (var i = 0; i < jsonDatas.length; i++) {
                    labels.push(jsonDatas[i].buildingName);
                    var businessData = jsonDatas[i].business;
                    for (var j = 0; j < businessData.length; j++) {
                        switch (j) {
                            case 0:
                                zxData.push(businessData[j]);
                                break;
                            case 1:
                                kdData.push(businessData[j]);
                                break;
                            case 2:
                                ghData.push(businessData[j]);
                                break;
                            case 3:
                                yData.push(businessData[j]);
                                break;
                            case 4:
                                ywData.push(businessData[j]);
                                break;
                            case 5:
                                dlData.push(businessData[j]);
                                break;
                            default:
                                break;
                        }
                    }
                }
            } else {
                $MB.n_warning(r.msg);
            }

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
                //设置标题
                title: {
                    display: true,
                    fontColor: 'red',
                    fontSize: 18,
                    text: '各楼宇客户业务量统计图'
                },
                scales: {
                    xAxes: [{
                        display: true,
                        //设置滚动条
                        scrollbar: {
                            enabled: true
                        },
                        scaleLabel: {
                            display: true,
                            fontColor: 'red',
                            fontSize: 18,
                            labelString: '楼宇名称'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            fontColor: 'red',
                            fontSize: 18,
                            labelString: '客户业务量（条）'
                        }
                    }]
                }
            };

                var canvas = $("#barChart").get(0).getContext("2d");
                var chart = new Chart(canvas, {
                    type: 'bar',
                    data: tempData,
                    options: options
                });
        });

    }
});
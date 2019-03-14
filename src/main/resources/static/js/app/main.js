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


    function buildPieChart() {
        var data = {
            datasets: [{
                data: [
                    98,
                    2
                ],
                backgroundColor: [
                    "#00c0ef",
                    "#d2d6de"
                ]
            }],
            labels: [
                '已覆盖',
                '未覆盖'
            ]
        };
        var options = {
            //Boolean - Whether we should show a stroke on each segment
            segmentShowStroke: true,
            //String - The colour of each segment stroke
            segmentStrokeColor: "#fff",
            //Number - The width of each segment stroke
            segmentStrokeWidth: 1,
            //Number - The percentage of the chart that we cut out of the middle
            percentageInnerCutout: 50, // This is 0 for Pie charts
            //Number - Amount of animation steps
            animationSteps: 100,
            //String - Animation easing effect
            animationEasing: "easeOutBounce",
            //Boolean - Whether we animate the rotation of the Doughnut
            animateRotate: true,
            //Boolean - Whether we animate scaling the Doughnut from the centre
            animateScale: false,
            //Boolean - whether to make the chart responsive to window resizing
            responsive: true,
            // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
            maintainAspectRatio: false,
            //String - A legend template
            legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>",
            //String - A tooltip template
            tooltipTemplate: "<%=value %> <%=label%> users",
            title: {
                display: true,
                text: '光缆覆盖率'
            }
        };
        var canvas = $("#coveragePieChart").get(0).getContext("2d");
        var chart = new Chart(canvas, {
            type: 'doughnut',
            data: data,
            options: options
        });
    }

    function buildLineChart() {
        var data = {
            labels: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
            datasets: [{
                label: 'A型专线',
                fill: false,
                backgroundColor: "#f56954",
                borderColor: "#f56954",
                data: [
                    12,
                    24,
                    45,
                    78,
                    88,
                    121,
                    289,
                    391,
                    456,
                    555,
                    666,
                    777
                ]
            }, {
                label: 'B型专线',
                fill: false,
                backgroundColor: "#00c0ef",
                borderColor: "#00c0ef",
                data: [
                    22,
                    31,
                    56,
                    87,
                    123,
                    231,
                    333,
                    345,
                    444,
                    456,
                    527,
                    538
                ]
            }, {
                label: 'C型专线',
                fill: false,
                backgroundColor: "#f39c12",
                borderColor: "#f39c12",
                data: [
                    12,
                    21,
                    46,
                    67,
                    153,
                    211,
                    303,
                    375,
                    414,
                    486,
                    527,
                    598
                ]
            }]
        };
        var options = {
            responsive: true,
            title: {
                display: true,
                text: '业务收入趋势'
            },
            tooltips: {
                mode: 'index',
                intersect: false
            },
            hover: {
                mode: 'nearest',
                intersect: true
            },
            scales: {
                xAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true,
                        labelString: '月份'
                    }
                }],
                yAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true,
                        labelString: '业务收入（万元）'
                    }
                }]
            }
        };
        var canvas = $("#lineChart").get(0).getContext("2d");
        var chart = new Chart(canvas, {
            type: 'line',
            data: data,
            options: options
        });
    }

    // buildPieChart();
    // buildLineChart();
    buildBarChart();

    function buildBarChart() {

        // 将获取到的json数据分别存放到两个数组中
        var labels = [], zxData = [], kdData = [], ghData = [], yData = [], ywData = [], dlData = [];
        //各楼宇客户业务量统计
        $.post(ctx + "buildingBusiness/count", "", function (r) {
            if (r.code === 0) {
                var jsonDatas = r.msg;
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
                    backgroundColor: [
                        "#00c0ef",
                        "#00c0ef",
                        "#00c0ef",
                        "#00c0ef",
                        "#00c0ef",
                        "#00c0ef"
                    ]
                }, {
                    label: "宽带业务",
                    data: kdData,
                    backgroundColor: [
                        "#2b39b2",
                        "#2b39b2",
                        "#2b39b2",
                        "#2b39b2",
                        "#2b39b2",
                        "#2b39b2"
                    ]
                }, {
                    label: "固话业务",
                    data: ghData,
                    backgroundColor: [
                        "#80c14a",
                        "#80c14a",
                        "#80c14a",
                        "#80c14a",
                        "#80c14a",
                        "#80c14a"
                    ]
                }, {
                    label: "云业务",
                    data: yData,
                    backgroundColor: [
                        "#cf706c",
                        "#cf706c",
                        "#cf706c",
                        "#cf706c",
                        "#cf706c",
                        "#cf706c"
                    ]
                }, {
                    label: "移网业务",
                    data: ywData,
                    backgroundColor: [
                        "#bb7cc1",
                        "#bb7cc1",
                        "#bb7cc1",
                        "#bb7cc1",
                        "#bb7cc1",
                        "#bb7cc1"
                    ]
                }, {
                    label: "电路业务",
                    data: dlData,
                    backgroundColor: [
                        "#f400ae",
                        "#f400ae",
                        "#f400ae",
                        "#f400ae",
                        "#f400ae",
                        "#f400ae"
                    ]
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
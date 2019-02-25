$(function () {
    var theme_color = $MB.getThemeColor(theme);

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

    buildPieChart();
    buildLineChart();
});
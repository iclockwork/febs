$(function () {
    var settings = {
        url: ctx + "region/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                regionName: $(".region-table-form").find("input[name='regionName']").val().trim(),
                regionNo: $(".region-table-form").find("input[name='regionNo']").val().trim(),
                superRegionName: $(".region-table-form").find("input[name='superRegionName']").val().trim(),
                gradeId: $(".region-table-form").find("select[name='gradeId']").val()
            };
        },
        columns: [{
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
        }]
    };

    function search() {
        $MB.refreshTable('regionTable');
    }

    function refresh() {
        $(".region-table-form")[0].reset();
        search();
    }

    function exportFile(fileType) {
        var url = ctx + "region/excel";
        if ("excel" === fileType) {
            url = ctx + "region/excel";
        } else if ("csv" === fileType) {
            url = ctx + "region/csv";
        }
        $.post(url, $(".region-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    }

    function initGrade() {
        $.post(ctx + "restriction/list", {
            keyword: "REGION_GRADE"
        }, function (r) {
            var data = r.rows;
            var html = [];
            for (var i = 0; i < data.length; i++) {
                html.push("<option value='" + data[i].serialNo + "'>" + data[i].descChina + "</option>");
            }
            $(".region-table-form").find("select[name='gradeId']").append(html.join(''));
        });
    }

    $MB.initTable('regionTable', settings);

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

    initGrade();
});
$(function () {
    var $form = $(".region-table-form");

    function initTable() {
        var settings = {
            url: ctx + "region/list",
            pageSize: 10,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    regionName: $form.find("input[name='regionName']").val().trim(),
                    regionNo: $form.find("input[name='regionNo']").val().trim(),
                    superRegionName: $form.find("input[name='superRegionName']").val().trim(),
                    gradeId: $form.find("select[name='gradeId']").val()
                };
            },
            columns: $.region.tableColumns
        };

        $MB.initTable('regionTable', settings);
    }

    function search() {
        $MB.refreshTable('regionTable');
    }

    function refresh() {
        $form[0].reset();
        search();
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

    initTable();

    initGrade();

    $(".region-search").click(function () {
        search();
    });

    $(".region-refresh").click(function () {
        refresh();
    });

    $(".region-export-excel").click(function () {
        $.utils.exportFile(ctx + "region/excel", $form.serialize());
    });

    $(".region-export-csv").click(function () {
        $.utils.exportFile(ctx + "region/csv", $form.serialize());
    });
});
$(function () {
    var $form = $(".address-table-form");
    var $ds = $form.find("select[name='dsRegionId']");
    var $qx = $form.find("select[name='regionId']");
    var $selectMode = $("#addressTable").attr("selectMode");

    function initTable() {
        var pageSize = 10;
        var columns = [];

        if ($.utils.selectModeSingle === $selectMode) {
            pageSize = 5;
            var checkboxColumns = [{
                checkbox: true
            }];
            columns = checkboxColumns.concat($.address.tableColumns);
        } else if ($.utils.selectModeMultiple === $selectMode) {
            pageSize = 5;
        } else {
            pageSize = 10;
            columns = $.address.tableColumns;
        }

        var settings = {
            url: ctx + "address/list",
            pageSize: pageSize,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    dsRegionId: $ds.val(),
                    regionId: $qx.val(),
                    segmType: $form.find("select[name='segmType']").val(),
                    standName: $form.find("input[name='standName']").val().trim()
                };
            },
            columns: columns
        };

        $MB.initTable('addressTable', settings);
    }

    function search() {
        $MB.refreshTable('addressTable');
    }

    function refresh() {
        $form[0].reset();
        search();
    }

    function selectOk() {
        var selected = $("#addressTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要选择的地址！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能选择一个地址！');
            return;
        }
        var segmId = selected[0].segmId;
        var standName = selected[0].standName;

        console.log("segmId:" + segmId + ", standName:" + standName);

        var selectBackFormId = $("#address-select-modal").attr("selectBackFormId");
        if (selectBackFormId) {
            $("#" + selectBackFormId).find("input[name='segmId']").val(segmId);
            $("#" + selectBackFormId).find("input[name='standName']").val(standName);
        }

        $('#address-select-modal').modal('hide');
    }

    initTable();

    $(".address-search").click(function () {
        search();
    });

    $(".address-refresh").click(function () {
        refresh();
    });

    $(".address-export-excel").click(function () {
        $.utils.exportFile(ctx + "address/excel", $form.serialize());
    });

    $(".address-export-csv").click(function () {
        $.utils.exportFile(ctx + "address/csv", $form.serialize());
    });

    $(".address-select-modal-ok").click(function () {
        selectOk();
    });

    $.region.initDsQx($ds, function () {
    }, $qx, function () {
    });
});
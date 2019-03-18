$(function () {
    var $form = $(".room-table-form");
    var $ds = $form.find("select[name='dsRegionId']");
    var $qx = $form.find("select[name='regionId']");
    var $selectMode = $("#roomTable").attr("selectMode");

    function initTable() {
        var pageSize = 10;
        var columns = [];

        if ($.utils.selectModeSingle === $selectMode) {
            pageSize = 5;
            var checkboxColumns = [{
                checkbox: true
            }];
            columns = checkboxColumns.concat($.room.tableColumns);
        } else if ($.utils.selectModeMultiple === $selectMode) {
            pageSize = 5;
        } else {
            pageSize = 10;
            columns = $.room.tableColumns;
        }

        var settings = {
            url: ctx + "room/list",
            pageSize: pageSize,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    dsRegionId: $ds.val(),
                    regionId: $qx.val(),
                    chinaName: $form.find("input[name='chinaName']").val().trim()
                };
            },
            columns: columns
        };

        $MB.initTable('roomTable', settings);
    }

    function search() {
        $MB.refreshTable('roomTable');
    }

    function refresh() {
        $form[0].reset();
        search();
    }

    function selectOk() {
        var selected = $("#roomTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要选择的机房！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能选择一个机房！');
            return;
        }
        var roomId = selected[0].roomId;
        var roomName = selected[0].chinaName;

        console.log("roomId:" + roomId + ", roomName:" + roomName);

        var selectBackFormId = $("#room-select-modal").attr("selectBackFormId");
        if (selectBackFormId) {
            $("#" + selectBackFormId).find("input[name='roomId']").val(roomId);
            $("#" + selectBackFormId).find("input[name='roomName']").val(roomName);
        }

        $('#room-select-modal').modal('hide');
    }

    initTable();

    $(".room-search").click(function () {
        search();
    });

    $(".room-refresh").click(function () {
        refresh();
    });

    $(".room-export-excel").click(function () {
        $.utils.exportFile(ctx + "room/excel", $form.serialize());
    });

    $(".room-export-csv").click(function () {
        $.utils.exportFile(ctx + "room/csv", $form.serialize());
    });

    $(".room-select-modal-ok").click(function () {
        selectOk();
    });

    $.region.initDsQx($ds, function () {
    }, $qx, function () {
    });
});
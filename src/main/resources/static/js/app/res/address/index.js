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
                    parentStandName: $form.find("input[name='parentStandName']").val().trim(),
                    standName: $form.find("input[name='standName']").val().trim()
                };
            },
            columns: columns
        };

        $MB.initTable('addressTable', settings);
    }

    function searchPost(param, callback) {
        $.post(ctx + "address/search", param, function (r) {
            if (r.code === 0) {
                var msg = r.msg;
                if ("000" === msg.result) {
                    callback(msg.results);
                }
            } else {
                $MB.n_danger(r.msg);
            }
        });
    }

    function initAutoComplete() {
        var _parentStandName = $form.find("input[name='parentStandName']");
        var _standName = $form.find("input[name='standName']");

        _parentStandName.autoComplete({
            resolver: 'custom',
            formatResult: function (item) {
                return {
                    value: item.id,
                    text: item.name
                };
            },
            events: {
                search: function (keyword, callback) {
                    searchPost({keyword: keyword}, callback);
                }
            }
        });

        _parentStandName.on('autocomplete.select', function (evt, item) {
            $form.find("input[name='parentSegmId']").val(item.id);
        });

        _standName.autoComplete({
            resolver: 'custom',
            formatResult: function (item) {
                return {
                    value: item.id,
                    text: item.name
                };
            },
            events: {
                search: function (keyword, callback) {
                    var parentSegmId = null;
                    if ('' !== $form.find("input[name='parentStandName']").val().trim()) {
                        parentSegmId = $form.find("input[name='parentSegmId']").val();
                    }

                    searchPost({
                        segmType: $form.find("select[name='segmType']").val(),
                        parentSegmId: parentSegmId,
                        keyword: keyword
                    }, callback);
                }
            }
        });

        _standName.on('autocomplete.select', function (evt, item) {
            $form.find("input[name='segmId']").val(item.id);
        });
    }

    function search() {
        $MB.refreshTable('addressTable');
    }

    function refresh() {
        $form[0].reset();

        var segmTypeInitValue = $form.find("select[name='segmType']").attr("initValue");
        if (segmTypeInitValue) {
            $form.find("select[name='segmType']").val(segmTypeInitValue);
        }

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


    initAutoComplete();
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
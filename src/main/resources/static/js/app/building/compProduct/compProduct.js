$(function () {
    var $compProductTableForm = $(".compProduct-table-form");
    var settings = {
        url: ctx + "compProduct/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                buildingNo: $compProductTableForm.find("input[name='buildingNo']").val().trim(),
                buildingName: $compProductTableForm.find("input[name='buildingName']").val().trim(),
                operator: $compProductTableForm.find("select[name='operator']").val(),
                businessType: $compProductTableForm.find("select[name='businessType']").val()
            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'compProductId',
            visible: false
        },{
            field: 'buildingId',
            visible: false
        }, {
            field: 'buildingNo',
            title: '楼宇编码'
        }, {
            field: 'buildingName',
            title: '楼宇名称'
        }, {
            field: 'operator',
            title: '运营商',
            formatter: function (value, row, index) {
                if (value === 1) return '电信';
                else if (value === 2) return '移动';
                else if (value === 3) return '华数';
                else return '其他';
            }
        }, {
            field: 'businessType',
            title: '业务类型',
            formatter: function (value, row, index) {
                if (value === 1) return '移动业务';
                else if (value === 2) return '固网业务';
                else if (value === 3) return '融合业务';
                else if (value === 4) return '创新业务';
                else return '其他';
            }
        }, {
            field: 'introduction',
            title: '资费描述'
        }, {
            field: 'docName',
            title: '附件名称',
            formatter: function (value, row, index) {
               return value;
            }

        },{
            field: 'createDate',
            title: '录入时间'
        }, {
            title: '操作',
            formatter: function (value, row, index) {
                return "<a href='#' onclick='queryDoc(\"" + row.id + "\")'>查看附件</a>";
            }
        }]
    };

    $MB.initTable('compProductTable', settings);

    $("#search").click(function () {
        $MB.refreshTable('compProductTable');
    });

    $("#refresh").click(function () {
        refresh();
    });


$("#delete").click(function () {

    var selected = $("#compProductTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的竞争产品！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].compProductId;
        if (i !== (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "确定删除选中竞争产品？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'compProduct/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
});

    $("#exportExcel").click(function () {
        $.post(ctx + "compProduct/excel", $(".compProduct-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    });

    $("#exportCsv").click(function () {
        $.post(ctx + "compProduct/csv", $(".compProduct-table-form").serialize(), function (r) {
            if (r.code === 0) {
                window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
            } else {
                $MB.n_warning(r.msg);
            }
        });
    });
});

function refresh() {
    $(".compProduct-table-form")[0].reset();
    $MB.refreshTable('compProductTable');
}

function queryDoc(id) {
    $.get(ctx + "compProduct/queryDoc", {"id": id}, function (r) {
        if (r.code === 0) {
            $MB.n_success('该用户已强制下线！');
            $MB.refreshTable('onlineTable');
        } else {
            $MB.n_danger(r.msg);
        }
    }, "json");
}
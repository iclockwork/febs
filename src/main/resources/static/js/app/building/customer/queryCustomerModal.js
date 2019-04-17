var $form;
$(function () {
    function queryCustomer() {
        var settings = {
            url: ctx + "buildingCustomer/list",
            pageSize: 5,
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    customerNo: $(".customer-table-form").find("input[name='customerNo']").val().trim(),
                    customerName: $(".customer-table-form").find("input[name='customerName']").val().trim(),
                    buildingNo:$("#customerExpiration-add").find("input[name='buildingNo']").val()
                };
            },
            columns: [{
                checkbox: true
            }, {
                field: 'customerNo',
                title: '客户编码'
            }, {
                field: 'customerName',
                title: '客户名称'
            }, {
                field: 'industryTypeName',
                title: '所属行业'
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
        $MB.initTable('queryCustomerTable', settings);
    }

    function search() {
        $MB.refreshTable('queryCustomerTable');
    }

    function refresh() {
        $(".customer-table-form")[0].reset();
        search();
    }

    $(".zmdi-search").click(function () {
        search();
    });

    $(".zmdi-refresh-alt").click(function () {
        refresh();
    });

    $("#selectCustomerSingle").click(function () {
        queryCustomer();
    });

    $(".customer-select-modal-ok").click(function () {
        selectOk();
    });

    function selectOk() {
        var selected = $("#queryCustomerTable").bootstrapTable('getSelections');
        var selected_length = selected.length;
        if (!selected_length) {
            $MB.n_warning('请勾选需要选择的客户！');
            return;
        }
        if (selected_length > 1) {
            $MB.n_warning('一次只能选择一个客户！');
            return;
        }
        var customerName = selected[0].customerName;

        var _selectModal = $("#query_customer_modal");
        var selectBackFormId = _selectModal.attr("selectBackFormId");
        if (selectBackFormId) {
            var _selectBackForm = $("#" + selectBackFormId);
            _selectBackForm.find("input[name='customerName']").val(customerName);
        }

        _selectModal.modal('hide');
    }
});
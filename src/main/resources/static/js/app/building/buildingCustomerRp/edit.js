$(function () {
    var $editForm = $("#modal-buildingCustomerRp-edit-form");

    var icon = "<i class='zmdi zmdi-close-circle zmdi-hc-fw'></i> ";
    var validator = $editForm.validate({
        rules: {
            buildingName: {
                required: true
            },
            standName: {
                required: true
            },
            customerName: {
                required: true
            }
        },
        errorPlacement: function (error, element) {
            if (element.is(":checkbox") || element.is(":radio")) {
                error.appendTo(element.parent().parent());
            } else {
                error.insertAfter(element);
            }
        },
        messages: {}
    });

    function save() {
        var buildingCustomerRpModalMode = $("#buildingCustomerRpModalMode").val();
        var flag = $editForm.validate().form();
        if (flag) {
            if (buildingCustomerRpModalMode === "add") {
                var buildingNo = $editForm.find("input[name='buildingNo']").val();
                var buildingName = $editForm.find("input[name='buildingName']").val();
                var segmId = $editForm.find("input[name='segmId']").val();
                var standName = $editForm.find("input[name='standName']").val();
                var customerNo = $editForm.find("input[name='customerNo']").val();
                var customerName = $editForm.find("input[name='customerName']").val();
                console.log("add:buildingNo:" + buildingNo + ", segmId:" + segmId + ", customerNo:" + customerNo);
                var addresses = $editForm.find("input[name='segmId']").data("addresses");
                console.log(addresses);

                var buildingCustomerRps = [];
                for (var i = 0; i < addresses.length; i++) {
                    var buildingCustomerRp = {
                        buildingNo: buildingNo,
                        buildingName: buildingName,
                        segmId: addresses[i].segmId,
                        standName: addresses[i].standName,
                        customerNo: customerNo,
                        customerName: customerName
                    };

                    buildingCustomerRps.push(buildingCustomerRp);
                }

                $.ajax({
                    url: ctx + "buildingCustomerRp/add",
                    type: "POST",
                    dataType: "json",
                    data: JSON.stringify(buildingCustomerRps),
                    contentType: 'application/json;charset=utf-8',
                    success: function (response) {
                        if (response.code === 0) {
                            $('#modal-buildingCustomerRp-edit').modal('hide');
                            $MB.n_success(response.msg);
                            $MB.refreshTable("buildingCustomerRpTable");
                        } else {
                            $MB.n_danger(response.msg)
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        if (XMLHttpRequest.readyState == 0) {
                            $MB.n_warning($.utils.tipsNetSlow);
                        }
                    }
                });
            }
        }
    }

    function init() {

    }

    $("#selectBuildingSingle").click(function () {
        console.log("selectBuildingSingle");
        var _buildingSelectModal = $('#building-select-modal');
        _buildingSelectModal.attr("selectBackFormId", "modal-buildingCustomerRp-edit-form");
        _buildingSelectModal.attr("state", "1");

        _buildingSelectModal.modal('show');
    });

    $("#selectAddressSingle").click(function () {
        var buildingNo = $editForm.find("input[name='buildingNo']").val();
        if (buildingNo) {
            console.log("selectAddressSingle");
            var buildingSegmId = $editForm.find("input[name='buildingSegmId']").val();

            var buildingSegmStandName = $editForm.find("input[name='buildingSegmStandName']").val();
            var _addressSelectModal = $('#address-select-modal');
            _addressSelectModal.attr("selectBackFormId", "modal-buildingCustomerRp-edit-form");
            _addressSelectModal.attr("segmType", "180009");
            _addressSelectModal.attr("parentSegmIdRecursive", buildingSegmId);
            _addressSelectModal.attr("parentSegmNameRecursive", buildingSegmStandName);

            _addressSelectModal.modal('show');
        } else {
            $MB.n_warning('请先选择楼宇！');
        }
    });

    $("#selectCustomerSingle").click(function () {
        var segmId = $editForm.find("input[name='segmId']").val();
        if (segmId) {
            console.log("selectCustomerSingle");
            var _customerSelectModal = $('#customer-select-modal');
            _customerSelectModal.attr("selectBackFormId", "modal-buildingCustomerRp-edit-form");

            _customerSelectModal.modal('show');
        } else {
            $MB.n_warning('请先选择九级地址！');
        }
    });

    $(".buildingCustomerRp-save").click(function () {
        save();
    });

    //打开事件
    $('#modal-buildingCustomerRp-edit').on('show.bs.modal', function (event) {
        init();
    });

    //隐藏事件
    $('#modal-buildingCustomerRp-edit').on('hidden.bs.modal', function (event) {
        //重置
        validator.resetForm();
        $editForm[0].reset();
    });
});
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
                console.log("add");
            }
        }
    }

    function init() {

    }

    $("#selectBuildingSingle").click(function () {
        console.log("selectBuildingSingle");
        $("#building-select-modal").attr("selectBackFormId", "modal-buildingCustomerRp-edit-form");
        $("#building-select-modal").attr("state", "1");
    });

    $("#selectAddressSingle").click(function () {
        var buildingNo = $editForm.find("input[name='buildingName']").val();
        if (buildingNo) {
            console.log("selectAddressSingle");
            var buildingSegmId = $editForm.find("input[name='buildingSegmId']").val();

            var buildingSegmStandName = $editForm.find("input[name='buildingSegmStandName']").val();
            $("#address-select-modal").attr("selectBackFormId", "modal-buildingCustomerRp-edit-form");
            $("#address-select-modal").attr("segmType", "180009");
            $("#address-select-modal").attr("parentSegmIdRecursive", buildingSegmId);
            $("#address-select-modal").attr("parentSegmNameRecursive", buildingSegmStandName);

            $('#address-select-modal').modal('show');
        } else {
            $MB.n_warning('请先选择楼宇！');
        }
    });

    $("#selectCustomerSingle").click(function () {
        var segmId = $editForm.find("input[name='segmId']").val();
        if (segmId) {
            console.log("selectCustomerSingle");

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
$(function () {
    var $editForm = $("#modal-building-edit-form");

    var icon = "<i class='zmdi zmdi-close-circle zmdi-hc-fw'></i> ";
    var validator = $editForm.validate({
        rules: {
            dsRegionId: {
                required: true
            },
            regionId: {
                required: true
            },
            buildingLevel: {
                required: true
            },
            buildingType: {
                required: true
            },
            buildingTypeName: {
                required: true
            },
            buildingAddress: {
                required: true
            },
            buildingNo: {
                required: true
            },
            buildingName: {
                required: true
            },
            longitude: {
                required: true
            },
            latitude: {
                required: true
            },
            floorNumber: {
                required: true
            },
            area: {
                required: true
            },
            householderNumber: {
                required: true
            },
            propertyCompany: {
                required: true
            },
            propertyManager: {
                required: true
            },
            propertyManagerContact: {
                required: true
            },
            buildingManager: {
                required: true
            },
            buildingManagerContact: {
                required: true
            },
            state: {
                required: true
            },
            remark: {
                required: false
            }
        },
        errorPlacement: function (error, element) {
            if (element.is(":checkbox") || element.is(":radio")) {
                error.appendTo(element.parent().parent());
            } else {
                error.insertAfter(element);
            }
        },
        messages: {
            dsRegionId: {
                required: icon + "请输入"
            },
            regionId: {
                required: icon + "请输入"
            },
            buildingLevel: {
                required: icon + "请输入"
            },
            buildingType: {
                required: icon + "请输入"
            },
            buildingTypeName: {
                required: icon + "请输入"
            },
            buildingAddress: {
                required: icon + "请输入"
            },
            buildingNo: {
                required: icon + "请输入"
            },
            buildingName: {
                required: icon + "请输入"
            },
            longitude: {
                required: icon + "请输入"
            },
            latitude: {
                required: icon + "请输入"
            },
            floorNumber: {
                required: icon + "请输入"
            },
            area: {
                required: icon + "请输入"
            },
            householderNumber: {
                required: icon + "请输入"
            },
            propertyCompany: {
                required: icon + "请输入"
            },
            propertyManager: {
                required: icon + "请输入"
            },
            propertyManagerContact: {
                required: icon + "请输入"
            },
            buildingManager: {
                required: icon + "请输入"
            },
            buildingManagerContact: {
                required: icon + "请输入"
            },
            state: {
                required: icon + "请输入"
            },
            remark: {
                required: icon + "请输入"
            }
        }
    });

    function initDs() {
        var _ds = $editForm.find("select[name='dsRegionId']");
        _ds.empty();
        $.post(ctx + "region/options", {
            gradeId: "2000004"
        }, function (r) {
            if (r.code === 0) {
                var data = r.msg;
                var html = [];
                html.push("<option value='' selected>---请选择---</option>");
                for (var i = 0; i < data.length; i++) {
                    var isSelectStr = "";
                    if (G_REGION_ID === data[i].regionId) {
                        isSelectStr = "selected=true";
                        _ds.attr("disabled", "disabled");
                    }
                    html.push("<option value='" + data[i].regionId + "' " + isSelectStr + ">" + data[i].regionName + "</option>");
                }
                _ds.append(html.join(''));

                _ds.change(function () {
                    initQx();
                });

                initQx();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    }

    function initQx() {
        var _ds = $editForm.find("select[name='dsRegionId']");
        var _qx = $editForm.find("select[name='regionId']");
        _qx.empty();
        if (null !== _ds.val() && "" !== _ds.val()) {
            $.post(ctx + "region/options", {
                gradeId: "2000011",
                superRegionId: _ds.val()
            }, function (r) {
                if (r.code === 0) {
                    var data = r.msg;
                    var html = [];
                    html.push("<option value='' selected>---请选择---</option>");
                    for (var i = 0; i < data.length; i++) {
                        html.push("<option value='" + data[i].regionId + "'>" + data[i].regionName + "</option>");
                    }

                    _qx.append(html.join(''));

                    if ($("#buildingModalMode").val() === "update") {
                        var initRegionId = $editForm.find("select[name='regionId']").attr("initRegionId");
                        _qx.val(initRegionId);
                    }
                } else {
                    $MB.n_danger(r.msg);
                }
            });
        }
    }

    function generateBuildingNo() {
        var buildingModalMode = $("#buildingModalMode").val();
        if (buildingModalMode === "add") {
            $.post(ctx + "building/generateBuildingNo", {buildingType: $editForm.find("select[name='buildingType']").val()}, function (r) {
                if (r.code === 0) {
                    var buildingNo = r.msg;
                    $editForm.find("input[name='buildingNo']").val(buildingNo);
                } else {
                    $MB.n_danger(r.msg);
                }
            });
        }
    }

    function save() {
        var buildingModalMode = $("#buildingModalMode").val();
        var flag = $editForm.validate().form();
        if (flag) {
            if (buildingModalMode === "add") {
                $.post(ctx + "building/add", $editForm.serialize(), function (r) {
                    if (r.code === 0) {
                        $('#modal-building-edit').modal('hide');
                        $MB.n_success(r.msg);
                        $MB.refreshTable("buildingTable");
                    } else $MB.n_danger(r.msg);
                });
            } else if (buildingModalMode === "update") {
                $.post(ctx + "building/update", $editForm.serialize(), function (r) {
                    if (r.code === 0) {
                        $('#modal-building-edit').modal('hide');
                        $MB.n_success(r.msg);
                        $MB.refreshTable("buildingTable");
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    }

    function init() {
        initDs();

        var buildingModalMode = $("#buildingModalMode").val();
        if (buildingModalMode === "add") {
            $editForm.find("input[name='buildingManagerId']").val(G_STAFF_ID);
            $editForm.find("input[name='buildingManager']").val(G_STAFF_NAME);
            $editForm.find("input[name='buildingManagerContact']").val(G_MOBILE);
        } else if (buildingModalMode === "update") {
            var buildingId = $editForm.find("input[name='buildingId']").val();
            $.post(ctx + "building/getBuilding", {buildingId: buildingId}, function (r) {
                if (r.code === 0) {
                    var building = r.msg;
                    $editForm.find("select[name='dsRegionId']").val(building.dsRegionId);
                    $editForm.find("select[name='dsRegionId']").trigger("change");
                    $editForm.find("select[name='regionId']").attr("initRegionId", building.regionId);
                    $editForm.find("select[name='buildingLevel']").val(building.buildingLevel);
                    $editForm.find("select[name='buildingType']").val(building.buildingType);
                    $editForm.find("input[name='buildingTypeName']").val(building.buildingTypeName);
                    $editForm.find("input[name='buildingAddress']").val(building.buildingAddress);
                    $editForm.find("input[name='buildingNo']").val(building.buildingNo);
                    $editForm.find("input[name='buildingName']").val(building.buildingName);
                    $editForm.find("input[name='longitude']").val(building.longitude);
                    $editForm.find("input[name='latitude']").val(building.latitude);
                    $editForm.find("input[name='floorNumber']").val(building.floorNumber);
                    $editForm.find("input[name='area']").val(building.area);
                    $editForm.find("input[name='householderNumber']").val(building.householderNumber);
                    $editForm.find("input[name='propertyCompany']").val(building.propertyCompany);
                    $editForm.find("input[name='propertyManager']").val(building.propertyManager);
                    $editForm.find("input[name='propertyManagerContact']").val(building.propertyManagerContact);
                    $editForm.find("input[name='buildingManagerId']").val(building.buildingManagerId);
                    $editForm.find("input[name='buildingManager']").val(building.buildingManager);
                    $editForm.find("input[name='buildingManagerContact']").val(building.buildingManagerContact);
                    $editForm.find("select[name='state']").val(building.state);
                    $editForm.find("input[name='remark']").val(building.remark);
                } else {
                    $MB.n_danger(r.msg);
                }
            });
        }
    }

    $editForm.find("select[name='buildingType']").unbind("change").change(function () {
        console.log("generateBuildingNo");
        generateBuildingNo();
    });

    $(".building-save").click(function () {
        save();
    });

    //打开事件
    $('#modal-building-edit').on('show.bs.modal', function (event) {
        init();
    });

    //隐藏事件
    $('#modal-building-edit').on('hidden.bs.modal', function (event) {
        //重置
        validator.resetForm();
        $editForm[0].reset();
    });
});
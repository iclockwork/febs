var validator;
var $customerExpirationAddForm = $("#customerExpiration-add-form");
$(function () {
    showSignStaff();
    initDate();
    $("#save-button").click(function () {
        var name = $(this).attr("name");
        var validator = $customerExpirationAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name === "save") {
                $.post(ctx + "customerExpiration/add", $customerExpirationAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("customerExpirationTable");
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name === "update") {
                $.post(ctx + "customerExpiration/update", $customerExpirationAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("customerExpirationTable");
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#customerExpiration-add .btn-close").click(function () {
        closeModal();
    });


    $("#queryButton").click(function () {
        $("#modalId").val("#customerExpiration-add");
    });

    function closeModal() {
        $("#save-button").attr("name", "save");
        $("#customerExpiration-add-modal-title").html('新增客户到期');
        $('#remindId').hide();
        $MB.closeAndRestModal("customerExpiration-add");
    }

    function initDate() {
        $("input[name='remindDate']").datetimepicker({
            format:'yyyy-mm-dd',  //格式  如果只有yyyy-mm-dd那就是0000-00-00
            autoclose:true,//选择后是否自动关闭
            minView: "month",//设置只显示到月份 //最精准的时间选择为日期  0-分 1-时 2-日 3-月
            language:  'zh-CN', //中文
            weekStart: 1, //一周从星期几开始
            startView: 2,
            forceParse: 0,
            // daysOfWeekDisabled:"1,2,3", //一周的周几不能选 格式为"1,2,3"  数组格式也行
            todayBtn : true,  //在底部是否显示今天
            todayHighlight :false, //今天是否高亮显示
            // keyboardNavigation:true, //方向图标改变日期  必须要有img文件夹 里面存放图标
            showMeridian:false,  //是否出现 上下午
            initialDate:new Date()
            //startDate: "2017-01-01" //日期开始时间 也可以是new Date()只能选择以后的时间
        });
    }

    function showSignStaff() {
        $("select[name='remindFlag']").change(function() {
            if (this.value === '1') {
                $('#remindId').show();
            } else {
                $('#remindId').hide();
                $("input[name='remindDate']").val(null);
            }
        });
    }

    validateRule();

    function validateRule() {
        var icon = "<i class='zmdi zmdi-close-circle zmdi-hc-fw'></i> ";
        validator = $customerExpirationAddForm.validate({
            rules: {
                buildingNo: {
                    required: true
                },
                customerName: {
                    required: true
                },
                remindDate:{
                    unrequired:[]
                }
            },
            messages: {
                buildingNo:  icon + "请选择楼宇",
                customerName: icon + "客户名称不能为空"
            }
        });
    }

    jQuery.validator.addMethod("unrequired", function(value,element,params) {

        return $("select[name='remindFlag']").val()!=='1' ||  $("input[name='remindDate']").val()!=="";

    }, "需要提醒时，提醒时间不能为空!");


});





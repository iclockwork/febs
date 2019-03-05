$(document).ready(function () {
    $('input').iCheck({
        checkboxClass: 'icheckbox_minimal-green',
        radioClass: 'iradio_minimal-green',
        increaseArea: '20%'
    });

    $("#loginButton").click(function () {
        login();
    });
});


function login() {
    var $loginButton = $("#loginButton");
    var username = $("#username").val().trim();
    var password = $("#password").val().trim();
    var rememberMe = $("#rememberMe").is(':checked');
    if (username === "") {
        $MB.n_warning("请输入用户名！");
        return;
    }
    if (password === "") {
        $MB.n_warning("请输入密码！");
        return;
    }
    $loginButton.html("").append("<div class='login-loder'><div class='line-scale'><div></div><div></div><div></div><div></div><div></div></div></div>");

    $.ajax({
        type: "post",
        url: ctx + "login",
        data: {
            "username": username,
            "password": password,
            "rememberMe": rememberMe
        },
        dataType: "json",
        success: function (r) {
            if (r.code === 0) {
                location.href = ctx + 'index';
            } else {
                $MB.n_warning(r.msg);
                $loginButton.html("登录");
            }
        }
    });
}

document.onkeyup = function (e) {
    if (window.event)
        e = window.event;
    var code = e.charCode || e.keyCode;
    if (code === 13) {
        login();
    }
};
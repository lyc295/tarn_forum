layui.use('carousel', function () {
    var carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#test1',
        width: '100%', //设置容器宽度
        arrow: 'always', //始终显示箭头
        height: '250px',
    });
});
$("#navigation").load("navigation.html")
$("#body").load("body.html")
//登录渲染
$(document).ready(
    window.renderHeader = function () {
        if (hasValue(getSessionStorage("token"))) {
            $("#login_out").hide();
            $("#releaseArticle").show()
            $("#collectionArticle").show()
            $("#login_in").show();
            $("#userName").text(getSessionStorage("userName"))
            if (hasValue(getSessionStorage("userName"))) {
                $("#imgUrl").text(getSessionStorage("userName"))
            }
        } else {
            $("#login_out").show();
            $("#releaseArticle").hide()
            $("#collectionArticle").hide()
            $("#login_in").hide();
        }
    }
)

//登录
$(".signIn").on("click", function () {
    hrefPage('login', 'divBody', '登录')
})
//注册
$("#regIn").on("click", function () {
    hrefPage('reg', 'divBody', '注册')
})
//登录
$("#divBody").on("click", ".signIn", function () {
    hrefPage('login', 'divBody', '登录')
})
//注册
$("#divBody").on("click", "#regIndc", function () {
    hrefPage('reg', 'divBody', '注册')
})


getUrlChange()

//用户登录
$("#divBody").on("click", "#userLogin", function () {
    if (!hasValue($("#L_user").val())) {
        layer.ready(function () {
            layer.msg('请输入用户名');
        });
        return false
    }
    if (!hasValue($("#L_email").val())) {
        layer.ready(function () {
            layer.msg('请输入邮箱');
        });
        return false
    }
    if (!hasValue($("#L_pass").val())) {
        layer.ready(function () {
            layer.msg('请输入密码');
        });
        return false
    }
    const params = {}
    params.userName = $("#L_user").val()
    params.userPwd = $("#L_pass").val()
    params.userEmail = $("#L_email").val()
    $.ajax({
        url: getUrl("user/login.do"),
        type: "POST",
        dataType: "json",
        data: params,
        async: true,
        success: function (data) {
            if (data.code == 10000) {
                setSessionStorage("token", data.responseBody.token)
                setSessionStorage("userName", data.responseBody.userName)
                setSessionStorage("userHeadpicurl", data.responseBody.userHeadpicurl)
                setSessionStorage("userId", data.responseBody.userId)
                window.location.href = "index.html";
                $("#userName").val(data.responseBody.userName)
                renderHeader();
            } else {
                layer.ready(function () {
                    layer.msg(data.msg);
                });
            }
        }
    });
})

//退出登录
$("#logout").click(() => {
    $.ajax({
        url: getUrl("user/logout.do"),
        type: "GET",
        async: true,
        success: function (data) {
            if (data.code == 10000) {
                clearSessionStorage("token");
                clearSessionStorage("userName")
                clearSessionStorage("userHeadpicurl")
                clearSessionStorage("userId")
                window.location.href = "./index.html";
                renderHeader();
            } else {
                layer.ready(function () {
                    layer.msg(data.msg);
                });
            }
        }
    });
})

//注册接口
$("#userReg").click(() => {
    if (!hasValue($("#L_username").val())) {
        layer.ready(function () {
            layer.msg('请输入用户名');
        });
        return false
    }
    if (!hasValue($("#L_email").val())) {
        layer.ready(function () {
            layer.msg('请输入邮箱');
        });
        return false
    }
    if (!hasValue($("#L_pass").val())) {
        layer.ready(function () {
            layer.msg('请输入密码');
        });
        return false
    }
    if (!hasValue($("#L_repass").val())) {
        layer.ready(function () {
            layer.msg('请确认密码');
        });
        return false
    }
    if ($("#L_pass").val() != $("#L_repass").val()) {
        layer.ready(function () {
            layer.msg('两次输入密码不同，请检查后重新输入');
        });
        return false
    }
    const params = {}
    params.userName = $("#L_username").val()
    params.userPwd = $("#L_pass").val()
    params.userEmail = $("#L_email").val()
    $.ajax({
        url: getUrl("user/register.do"),
        type: "POST",
        dataType: "json",
        data: params,
        async: true,
        success: function (data) {
            if (data.code == 10000) {
                window.location.href = "login.html";
            } else {
                layer.ready(function () {
                    layer.msg(data.msg);
                });
            }
        }
    });
})

//发布新帖
$("#divBody").off('click');
$("#divBody").on("click", ".addArticle", function () {
    if (hasValue(getSessionStorage("token"))) {
        hrefPage('add', 'divBody', '新帖发布')
    } else {
        hrefPage('login', 'divBody', '登录')
    }
})


//进入分页页面
$("#divBody").on("click", "#article", function () {
    hrefPage('article', 'body', '帖子页面');
})


$("#divBody").on("click",".model",function () {
    debugger
    hrefPage('article', 'body', '帖子页面');
    const params = {}
    const paramsTotal = {}
    if (!$(this).hasClass("layui-this")) {
        $(this).addClass("layui-this").siblings().removeClass("layui-this");
    }
    if(!hasValue($(this).attr("value"))){
        // window.location.href="index.html"
    }else if ($(this).attr("value") == 1 ){
        jumpPage(params)
    }

})










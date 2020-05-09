import article from "./article";

/** 重写ajax请求*/
(function ($) {
    //首先备份下jquery的ajax方法
    var _ajax = $.ajax;
    //重写jquery的ajax方法
    $.ajax = function (opt) {
        //备份opt中error和success方法
        var fn = {
            beforeSend: function () {
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            success: function (data, textStatus) {

            },
            complete: function () {
            }
        }
        if (opt.error) {
            fn.error = opt.error;
        }
        if (opt.success) {
            fn.success = opt.success;
        }
        if (opt.complete) {
            fn.complete = opt.complete;
        }
        if (opt.beforeSend) {
            fn.beforeSend = opt.beforeSend;
        }
        //扩展增强处理
        var _opt = $.extend(opt, {
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                //错误方法增强处理
                fn.error(XMLHttpRequest, textStatus, errorThrown);
            },
            success: function (data, textStatus) {
                if (data.code == '10002') {

                    $alert({content: '未登录,无法查询'})

                } else if (data.code == '10003') {
                    clearSessionStorage("token");

                    $alert({content: '登陆凭证已过期,请使用带有登录凭证的url重新进入页面'})

                } else {
                    //成功回调方法增强处理
                    fn.success(data, textStatus);
                }
            },
            beforeSend: function (XHR) {
                fn.beforeSend();
            },
            complete: function () {
                //请求完成后回调函数 (请求成功或失败之后均调用)。
                fn.complete();
            },
            headers: {
                token: getSessionStorage('token') || ''
            }
        });
        return _ajax(_opt);
    };
})(jQuery);

//定义layui
var layer = ''
layui.use('layer', function () {
    layer = layui.layer;
})
window.hasValue = $utils.common.hasValue
window.getQueryString = $utils.route.getUrlString;
window.getLocalStorage = $utils.storage.getLocalStorage;
window.setLocalStorage = $utils.storage.setLocalStorage;
window.getSessionStorage = $utils.storage.getSessionStorage;
window.setSessionStorage = $utils.storage.setSessionStorage;
window.clearLocalStorage = $utils.storage.clearLocalStorage;
window.clearSessionStorage = $utils.storage.clearSessionStorage;
//路由跳转
window.hrefPage = function (html, label, title) {
    debugger
    window.location.href = "index.html#" + label + "/" + html;
    $.get(html + ".html", function (html) {
        $('#' + label).html(html);
        document.title = title;
    })
}
window.getUrl = function (url) {
    return window.location.origin + '/' + url;
}

window.getUrlChange = function () {
    if (hasValue(location.hash)) {
        const label = location.hash.substring(1).split("/")[0]
        const html = location.hash.substring(1).split("/")[1]
        $.get(html + ".html", function (html) {
            $('#' + label).html(html);
        })
    }
}

window.queryAllPostsTotal = function (paramsTotal) {
    let count = ''
    $.ajax({
        url: getUrl("Posts/queryAllPostsTotal.do"),
        type: "GET",
        dataType: "json",
        data: paramsTotal,
        async: false,
        success: function (data) {
            if (data.code == 10000) {
                count = data.responseBody
            } else {
                layer.ready(function () {
                    layer.msg(data.msg);
                });
            }
        }
    })
    return count
}

window.jumpPage =  function (params) {
    layui.use('laypage', function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'pagePosts',
            limit: 1,
            count: queryAllPostsTotal(paramsTotal),
            jump: function (obj) {
                params.number = obj.curr
                params.size = obj.limit
                $.ajax({
                    url: getUrl("Posts/queryAllPosts.do"),
                    type: "GET",
                    dataType: "json",
                    data: params,
                    async: true,
                    success: function (data) {
                        if (data.code == 10000) {
                            if (data.responseBody.list.length > 0) {
                                $(".posts-none").hide()
                                let html = ''
                                data.responseBody.list.forEach(function (obj, index) {
                                        console.log(obj)
                                        html += `<li>
                                        <a href="views/home.html" class="fly-avatar">
                                            <img src="${obj.userName}" alt="${obj.userName}">
                                        </a>
                                        <h2>
                                            <a href="detail.html">${obj.postTitle}</a>
                                        </h2>
                                        <div class="fly-list-info">
                                            <a href="views/home.html" link>
                                                <cite>${obj.userName}</cite>
                                                <i class="iconfont icon-renzheng"></i>
                                            </a>
                                            <span>${obj.postCreatetime}</span>
                                            <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i>${obj.postReward}</span>
                                            <span class="layui-badge fly-badge-accept layui-hide-xs">${obj.postIspay}</span>
                                            <span class="fly-list-nums"><i class="iconfont icon-pinglun1" title="回答"></i> 66</span>
                                        </div>
                                        <div class="fly-list-badge">
                                            <span class="layui-badge layui-bg-black">${obj.postType}</span>                            
                                        </div>
                                      </li>`
                                    }
                                )
                                $("#postsData").html(html)
                            } else {
                                $(".posts-list").hide()
                            }
                        }
                        else {
                            layer.ready(function () {
                                layer.msg(data.msg);
                            });
                        }
                    }
                })
            }
        });
    })
}




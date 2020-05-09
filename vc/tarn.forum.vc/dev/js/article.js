const params = {}
const paramsTotal = {}
jumpPage(params)

function queryAllPostsTotal(paramsTotal) {
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

function jumpPage(params) {
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


$(".postIspay").on("click", function () {
    if (!$(this).hasClass("layui-this")) {
        $(this).addClass("layui-this").siblings().removeClass("layui-this");
    }
    params.postIspay = $(this).attr("value")
    paramsTotal.postIspay = $(this).attr("value")
    queryAllPostsTotal(paramsTotal);
    jumpPage(params)
})



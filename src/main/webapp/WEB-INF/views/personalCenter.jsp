<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11841
  Date: 2019/5/3
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>


    <title>个人中心</title>
</head>
<body>

<!-- 顶行提示 -->
<div class="container-fluid bg-light">
    <div class="row">
        <div class="col-2 offset-2 my-1">
            <a href="/toHomePage">首页</a>
        </div>
        <div class="col-2 offset-4 my-1">
            <a>消息</a>
            <a>联系客服</a>
        </div>
    </div>
</div>

<!-- 次行提示 -->
<div class="container-fluid bg-info">
    <div class="row">
        <div class="col-1 offset-2 my-4">
            <h2>个人信息</h2>
        </div>
        <div class="col-1 my-4">
            <a>首页</a>
        </div>
        <div class="col-1 my-4">
            <a>账户设置</a>
        </div>
        <div class="col-1 my-4">
            <a>消息</a>
        </div>
        <div class="col-3 my-4">
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="请输入要搜索的内容">
                <div class="input-group-append">
                    <span class="input-group-text">搜索</span>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 内容 -->
<div class="container-fluid bg-light">
    <div class="row">
        <div class="col-2 offset-2 my-5">
            <div class="my-2"><a class="my-5">全部功能</a></div>
            <div class="my-2"><a class="my-5" href="/queryOrderByUserId">我的购物车</a></div>
            <div class="my-2"><a class="my-5" href="/toAllOrderPage">我的订单</a></div>
            <div class="my-2"><a class="my-5">我的收藏</a></div>
            <div class="my-2"><a class="my-5">评价管理</a></div>
            <div class="my-2"><a class="my-5" href="/toPersonalInformationChange">信息管理</a></div>
            <div class="my-2"><a class="my-5">安全中心</a></div>
            <div class="my-2"><a class="my-5">退出登录</a></div>
        </div>
        <div class="col-5 my-5">
            <div class="mb-5">
                    <a>你好，<span style="color: crimson">${user.username}</span></a>
                    <a style="float: right">我的收货地址</a>
            </div>
            <div>
                <ul class="nav nav-tabs nav-justified">
                    <li class="nav-item">
                        <a class="nav-link" href="#">待付款</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">待发货</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">待收货</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">待评价</a>
                    </li>
                </ul>
            </div>
            <div>
                <div class="bg-info py-2">
                    <span>猜你喜欢</span>
                    <span>换一组</span>
                </div>
            </div>

            <div class="row">
                <c:forEach items="${pageInfo.list}" var="book" varStatus="time">
                    <e:if test="${time.count}%4==0">
                        <div class="row">
                            <!--左侧商品显示-->
                            <div class="col-4 offset-2 py-5">
                                <div id="recommend" class="pb-2">
                                    <h5>心水推荐</h5>
                                </div>
                            </div>

                            <div class="col-4 py-5">
                                <div id="benefit" class="pb-2">
                                    <h5>实惠推荐</h5>
                                </div>
                            </div>
                        </div>
                    </e:if>
                    <div class="col-4 pb-5">
                        <div class="card" style="width:200px">
                            <img class="card-img-top" src="${book.picture}" alt="Card image" style="width:100%">
                            <div class="card-body">
                                <h4 class="card-title">${book.title}</h4>
                                <p class="card-text">${book.author} </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>


        </div>
    </div>

</div>

</body>
</html>

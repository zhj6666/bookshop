<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11841
  Date: 2019/5/1
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>

    <%--<script src="static/resources/jquery-3.4.0.min.js"></script>
    <script src="static/resources/bootstrap.bundle.min.js"></script>
    <script src="static/resources/bootstrap.min.css"></script>--%>

    <title>Title</title>
</head>
<body>
<!-- 登录行 -->
<div class="container-fluid bg-light py-1">
    <div class="row">
        <div class="col-2 offset-2">
            <a>网上商城</a>
        </div>
        <c:if test="${user==null}">
            <div class="col-2 offset-4">
                <a href="/toLogin">登录</a>
                <a>客服</a>
            </div>
        </c:if>
        <c:if test="${user!=null}">
            <div class="col-2 offset-4">
                <a>你好，<span style="color: crimson">${user.username}</span></a>
                <a>客服</a>
                <a href="/toPersonalCenter">个人中心</a>
                <a onclick="logout()">注销</a>
            </div>
        </c:if>
    </div>
</div>

<!-- 提示框 -->
<div class="container-fluid">
    <div class="row">
        <div class="col-2 offset-2">
            <h2>网上商城</h2>
        </div>
        <div class="col-4">
            <span>确认订单</span>
            <span>付款</span>
            <span>确认收货</span>
            <span>评价</span>
        </div>
    </div>
</div>

<!-- 收货地址 -->
<div class="container-fluid">
    <div class="row">
        <div class="col-8 offset-2">
            <h5>确认收货地址</h5>
            <hr style="height:1px;border:none;border-top:1px dashed lightslategrey;" />
        </div>
    </div>
    <div class="row">
        <div class="col-2 offset-2">
            ${user.location}
        </div>
    </div>
</div>

<!--详细信息-->
<div class="container-fluid">
    <div class="row">
        <div class="col-8 offset-2">
            <h5>确认订单信息</h5>
            <hr style="height:1px;border:none;border-top:1px dashed lightslategrey;" />
        </div>
    </div>
    <div class="row">
        <div class="rol-8 offset-2">

                <div class="row">
                    1111111111111111111111
                    <div class="col-3">
                        <img src="${b.picture}" style="height: 200px;width: 200px">
                    </div>
                        ${b.picture}
                </div>


        </div>
    </div>
</div>

<!-- 提交订单 -->
<div class="container-fluid">
    <div class="row">
        <div class="col-2 offset-8">
            <div class="row border border-warning">
                <span>实付款：${totalPrice}</span><br>
                <span>寄送至</span><br>
                <span>收货人</span><br>
            </div>
            <div>
                <a>返回</a>
                <button onclick="$.pay(${totalPrice},${user.account.balance},${b.id},${quantity})">提交订单</button>
            </div>
        </div>
    </div>
</div>

<script>
    $.pay=function (totalPrice,balance,bookid,quantity) {
        alert(totalPrice)
        alert(balance)
        alert(bookid)
        alert(quantity)
        if (totalPrice>balance){
            alert("当前余额不足，无法购买")
        } else {

                alert(bookid+"+"+quantity);
                $.ajax({
                    url:"/payNow",
                    async:false,
                    type:"POST",
                    dataType:"text",
                    data:'bookid='+bookid+"&quantity="+quantity,
                    success:function (data) {
                        alert("支付成功")
                        window.location.href="/toAllOrderPage"
                    },
                    error:function (jqXHR) {
                        alert("支付失败")
                    }
                });

        }
    }
</script>


</body>
</html>

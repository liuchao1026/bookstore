<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/7
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title></title>
  <link type="text/css" rel="stylesheet" href="../css/style.css" />
  <script src="../../js/jquery-1.7.2.min.js"></script>
  <%--页面初始化时计算总价--%>
  <script>
    $(function(){



    })

  </script>
</head>
<body>
<div id="header" class="wrap">
  <div id="logo">合众艾特网上书城</div>
  <div id="navbar">
    <div class="userMenu">
      <ul>
        <li><a href="selectbypage">User首页</a></li>
        <li><a href="../orderpage">我的订单</a></li>
        <li class="current"><a href="toshopping">购物车</a></li>
        <li><a href="../zhuxiao">注销</a></li>
      </ul>
    </div>
    <form method="get" name="search" action="">
      搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
    </form>
  </div>
</div>
<div id="content" class="wrap">
  <div class="list bookList">
    <form method="post" name="shoping" action="../addorder">
      <table>
        <tr class="title">
          <th class="view">图片预览</th>
          <th>书名</th>
          <th class="nums">数量</th>
          <th class="price">价格</th>
          <th>删除</th>
        </tr>

<c:set var="sum" value="0"></c:set>
        <c:forEach items="${bookvomap}" var="b">
          <tr>
            <td class="thumb"><img src="${b.value.bookpic}" height="150" /></td>
            <td class="title">${b.value.bookname}</td>
            <td><input class="input-text" type="text" name="nums" value="${b.value.count}" /></td>
            <td>￥<span>${b.value.bookprice*b.value.count}</span></td>
            <td><a href="deletebookvo?bookid=${b.value.bookid}">删除</a></td>
          </tr>
        <c:set var="sum" value="${sum+b.value.bookprice*b.value.count}"></c:set>
        </c:forEach>



      </table>
      <div class="button">
        <h4>总价：￥<span id="total">${sum}</span>元</h4>
        <input class="input-chart" type="submit" name="submit" value="" />
      </div>
    </form>
  </div>
</div>
<div id="footer" class="wrap">
  合众艾特网上书城 &copy; 版权所有

</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/7
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title></title>
  <link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body>
<div id="header" class="wrap">
  <div id="logo">合众艾特网上书城</div>
  <div id="navbar">
    <div class="userMenu">
      <ul>
        <li><a href="selectbypage">${userinfo.username}首页</a></li>
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
    <form method="get" name="shopping" action="shopping">
      <table>
        <tr class="title">
          <th class="checker"></th>
          <th>书名</th>
          <th class="price">价格</th>
          <th class="store">库存</th>
          <th class="view">图片预览</th>
        </tr>
        <%--<tr>
          <td><input type="checkbox" name="bookId" value="1" /></td>
          <td class="title">泰戈尔诗集</td>
          <td>￥18.00</td>
          <td>999</td>
          <td class="thumb"><img src="images/book/book_01.gif" /></td>
        </tr>--%>
        <c:forEach items="${pages.content}" var="b">
          <tr class="odd">
            <td><input type="checkbox" name="bookid" value="${b.bookid}" /></td>
            <td class="title">${b.bookname}</td>
            <td>￥${b.bookprice}</td>
            <td>${b.bookcount}</td>
            <td class="thumb"><img src="../images/book/book_02.gif" /></td>
          </tr>


        </c:forEach>


      </table>
      <div class="page-spliter">
        <a href="selectbypage?page=${currpage-1}&totalpages=${pages.totalPages}">&lt;</a>
        <a href="selectbypage?page=1">首页</a>
        <%--<span class="current">1</span>--%>
        <c:forEach begin="1" end="${pages.totalPages}" var="i">
          <a href="selectbypage?page=${i}&totalpages=${pages.totalPages}">${i}</a>
        </c:forEach>


        <span>...</span>
        <a href="selectbypage?page=${pages.totalPages}">尾页</a>
        <a href="selectbypage?page=${currpage+1}&totalpages=${pages.totalPages}">&gt;</a>
      </div>
      <div class="button"><input class="input-btn" type="submit" name="submit" value="" /></div>
    </form>
  </div>
</div>
<div id="footer" class="wrap">
  合众艾特网上书城 &copy; 版权所有

</div>
</body>
</html>

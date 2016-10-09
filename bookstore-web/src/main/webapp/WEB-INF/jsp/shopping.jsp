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
            <td><input class="input-text" type="text" name="nums" bookid="${b.value.bookid}" price="${b.value.bookprice}"  value="${b.value.count}" /></td>
            <td>￥<span>${b.value.bookprice}</span></td>
            <td>￥<span class="kk">${b.value.bookprice*b.value.count}</span></td>

            <td><a class="delete" bookid="${b.value.bookid}" href="javascript:void(0)">删除</a></td>
          </tr>

        </c:forEach>



      </table>
      <div class="button">
        <h4>总价：￥<span id="total">${totalprice}</span>元</h4>
        <input class="input-chart" type="submit" name="submit" value="" />
      </div>
    </form>
  </div>
</div>
<div id="footer" class="wrap">
  合众艾特网上书城 &copy; 版权所有

</div>

<script src="../../js/jquery-1.7.2.min.js"></script>
页面初始化时计算总价
<script>
  $(function(){
    chuci()

    $(".input-text").blur(function(){
//        先跟新页面上的小计
      var count=$(this).val()
      var price=$(this).attr("price")

      $(this).parent().next().next().children("span").html(count*price)

//      在跟新页面上的总价
      $.post("updateshopping",{"bookid":$(this).attr("bookid"),"count":count},function(data){

        $("#total").html(data)
      })

    })
  })

//  实现删除操作
  $(".delete").click(function(){
    $(this).parents("tr").slideUp(1000)
    $.post("deletebookvo",{"bookid":$(this).attr("bookid")},function(data){
      $("#total").html(data)
    })
  })


  /*
  * 第一次加载的时候算出载入总价
  * */
   function chuci(){
   var sum=0;
   var ints=$(".kk")
   for(var i=0;i<ints.length;i++){
     var int=ints[i].innerText
     sum+=parseInt(int)
   }
   $("#total").html(sum)
 }
</script>
</body>
</html>

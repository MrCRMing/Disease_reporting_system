<%--
  Created by IntelliJ IDEA.
  User: 铭
  Date: 2020/3/9
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll">查找账户</a>
<br>
<form action="account/save" method="post">
    账户名称：<input type="text" name="name"/><br/>
    账户金额：<input type="text" name="money"><br/>
    <input type="submit" value="保存"/>
</form>

</body>
</html>


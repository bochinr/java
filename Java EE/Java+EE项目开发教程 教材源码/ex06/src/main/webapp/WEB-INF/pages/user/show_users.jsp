<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<html>
<head><title>用户列表</title></head>
<body>
<table width="400" border="1" cellspacing="0" cellpadding="0">
    <tbody>
    <tr><td align="center" valign="middle">姓名</td>
        <td align="center" valign="middle">年龄</td>
        <td align="center" valign="middle">手机</td></tr>
    <c:forEach var="user" items="${user_list}">
        <tr><td align="center" valign="middle">${user.userName}</td>
            <td align="center" valign="middle">${user.age}</td>
            <td align="center" valign="middle">${user.mobile}</td></tr>
    </c:forEach>
    </tbody>
</table>
</body></html>

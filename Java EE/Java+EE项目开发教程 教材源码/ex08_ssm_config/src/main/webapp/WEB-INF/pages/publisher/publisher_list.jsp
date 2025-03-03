<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html><head><title>出版社信息</title></head><body>
<table width="400" border="1" cellspacing="0" cellpadding="0" style="border-collapse:collapse">
    <tbody>
    <tr><td>编号</td><td>名称</td><td>联系人</td></tr>
    <c:forEach var="publisher" items="${publishers}"><tr>
        <td>${publisher.pubId}</td>
        <td>${publisher.pubName}</td>
        <td>${publisher.contacter}</td>
    </tr></c:forEach>
    </tbody>
</table></body></html>

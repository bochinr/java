<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<html><head><title>出版社信息列表</title></head><body>
<form id="form1" name="form1" method="post"
      action="${pageContext.request.contextPath}/publisher/delete_publishers">
    <table width="100%" border="1" cellspacing="0" cellpadding="0"><tbody>
    <tr><td colspan="5">出版社信息</td></tr>
    <tr><td width="35" align="center">选择</td>
        <td width="50" align="center">编号</td>
        <td width="125" align="center">名称</td>
        <td width="105" align="center">联系人</td></tr>
    <c:forEach var="publisher" items="${publishers.publisherList}">
        <tr><td><input type="checkbox" name="pubIds" value="${publisher.pubId}"></td>
            <td>${publisher.pubId}</td>
            <td>${publisher.pubName}</td>
            <td>${publisher.contacter}</td></tr>
    </c:forEach>
    <tr><td colspan="5" align="center">
        <input type="submit" name="submit" id="submit" value="删除"></td>
    </tr></tbody></table>
</form></body></html>

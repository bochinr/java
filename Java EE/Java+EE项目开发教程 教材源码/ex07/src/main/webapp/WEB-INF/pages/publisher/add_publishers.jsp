<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<html><head><title>添加出版社信息</title></head><body>
<form method="post" action="${pageContext.request.contextPath}/publisher/add_publishers">
    <table width="100%" border="1" cellspacing="0" cellpadding="0"><tbody>
    <tr><td colspan="5">添加出版社信息</td></tr>
    <tr><td width="35" align="center">序号</td>
        <td width="50" align="center">编号</td>
        <td width="125" align="center">名称</td>
        <td width="105" align="center">联系人</td></tr>
    <tr><td align="center">1</td>
        <td><input name="publisherList[0].pubId" type="text" size="5"></td>
        <td><input name="publisherList[0].pubName" type="text" size="13"></td>
        <td><input name="publisherList[0].contacter" type="text" size="10"></td></tr>
    <tr><td align="center">2</td>
        <td><input name="publisherList[1].pubId" type="text" size="5"></td>
        <td><input name="publisherList[1].pubName" type="text" size="13"></td>
        <td><input name="publisherList[1].contacter" type="text" size="10"></td></tr>
    <tr><td align="center">3</td>
        <td><input name="publisherList[2].pubId" type="text" size="5"></td>
        <td><input name="publisherList[2].pubName" type="text" size="13"></td>
        <td><input name="publisherList[2].contacter" type="text" size="10"></td></tr>
    <tr><td align="center">4</td>
        <td><input name="publisherList[3].pubId" type="text" size="5"></td>
        <td><input name="publisherList[3].pubName" type="text" size="13"></td>
        <td><input name="publisherList[3].contacter" type="text" size="10"></td></tr>
    <tr><td colspan="5" align="center">
        <input type="submit" name="submit" id="submit" value="添加"></td>
    </tr>
    </tbody></table>
</form></body></html>

<%--add_book_pojo.jsp--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html><head><title>添加图书</title></head>
<body><form id="form1" name="form1" method="post"
            action="${pageContext.request.contextPath}/book/add_book_binding_pojo">
    <table width="500" border="0" cellspacing="0" cellpadding="0">
        <tbody>
        <tr><td height="30" colspan="2" align="center">添加图书</td></tr>
        <tr><td width="134" height="30" align="right">图书编号：</td>
            <td width="366" align="left">
                <input name="bookId" type="text" id="book_id" size="10"></td></tr>
        <tr><td height="30" align="right">书名：</td><td align="left">
            <input name="bookName" type="text" id="book_name" size="30"></td></tr>
        <tr><td height="30" align="right">ISBN：</td><td align="left">
            <input name="isbn" type="text" id="isbn" size="30"></td></tr>
        <tr><td height="30" align="right">价格：</td><td align="left">
            <input name="price" type="text" id="price" size="10"></td></tr>
        <tr><td height="30" align="right">出版日期：</td><td align="left">
            <input type="date" name="pubDate" id="pub_date"></td></tr>
        <tr><td height="30" align="right">入库日期：</td><td align="left">
            <input type="date" name="warehousingDate" id="warehousing_date"></td></tr>
        <tr><td height="30" align="right">作者：</td><td align="left">
            <input name="author" type="text" id="author" size="20"></td></tr>
        <tr><td height="30" align="right">库存量：</td><td align="left">
            <input name="inventory" type="text" id="inventory" size="20"></td></tr>
        <tr><td height="30" align="right">出版社编号：</td><td align="left">
            <input name="publisher.pubId" type="text" id="pub_id" size="20"></td></tr>
        <tr><td height="30" align="right">出版社名称：</td><td align="left">
            <input name=" publisher.pubName" type="text" id="pub_name" size="20"></td></tr>
        <tr><td height="30" align="right">联系人：</td><td align="left">
            <input name="publisher.contacter" type="text" id="contacter" size="20"></td></tr>
        <tr><td height="30" align="right">&nbsp;</td><td align="left">
            <input type="submit" name="button" id="button" value="提交"></td></tr>
        </tbody></table>
</form></body></html>

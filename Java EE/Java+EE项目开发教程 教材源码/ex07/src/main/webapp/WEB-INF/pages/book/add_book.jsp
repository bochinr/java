<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html><head><title>添加图书</title></head>
<body>
    <form id="form1" method="post"
          <%--action="${pageContext.request.contextPath}/book/add_book_binding_default">--%>
          <%--action="${pageContext.request.contextPath}/book/add_book_binding_basic">--%>
          action="${pageContext.request.contextPath}/book/add_book_binding_basic_ex">
        <table width="402" border="0" cellspacing="0" cellpadding="0">
        <tbody>
            <tr>
                <td colspan="2" align="center">添加图书</td>
            </tr>
            <tr>
                <td width="134" height="30">图书编号：</td>
                <td><input name="book_id" type="text" id="book_id" size="10"></td>
            </tr>
            <tr>
                <td height="30">书名：</td>
                <td><input name="book_name" type="text" id="book_name" size="30"></td>
            </tr>
            <tr>
                <td height="30">ISBN：</td>
                <td><input name="isbn" type="text" id="isbn" size="30"></td>
            </tr>
            <tr>
                <td height="30">价格：</td>
                <td><input name="price" type="text" id="price" size="10"></td>
            </tr>
            <tr>
                <td height="30">出版日期：</td>
                <td><input type="date" name="pub_date" id="pub_date"></td>
            </tr>
            <tr>
                <td height="30">入库日期：</td>
                <td><input type="date" name="warehousing_date" id="warehousing_date"></td>
            </tr>
            <tr>
                <td height="30">作者：</td>
                <td><input name="author" type="text" id="author" size="20"></td>
            </tr>
            <tr>
                <td height="30">库存量：</td>
                <td><input name="inventory" type="text" id="inventory" size="20"></td>
            </tr>
            <tr>
                <td height="30">出版社编号：</td>
                <td><select name="pub_id" id="pub_id">
                    <option value="1">清华大学出版社</option>
                    <option value="2">电子工业出版社</option>
                    <option value="3">人民邮电出版社</option>
                    <option value="3">高等教育出版社</option>
                </select></td>
            </tr>
            <tr>
                <td height="30">&nbsp;</td>
                <td><input type="submit" name="submit" id="button" value="提交"></td>
            </tr>
        </tbody>
        </table>
    </form>
</body>
</html>

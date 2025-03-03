<!-- book_info.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>图书信息</title>
</head>
<body>
    <h2>图书信息</h2>
    图书编号：${book.bookId}<br/>
    书名：${book.bookName}<br/>
    ISBN：${book.isbn}<br/>
    价格：${book.price}<br/>
    出版日期：${book.pubDate}<br/>
    入库日期：${book.warehousingDate}<br/>
    作者：${book.author}<br/>
    库存量：${book.inventory}<br/>
    出版社编号：${book.pubId}<br/>
</body>
</html>

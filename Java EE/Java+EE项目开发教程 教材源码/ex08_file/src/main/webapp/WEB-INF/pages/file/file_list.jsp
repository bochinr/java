<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html><head><title>文件列表</title></head><body>
<form method="post" enctype="multipart/form-data" action="upload">
    <table width="500" border="0" cellspacing="0" cellpadding="0">
        <tbody><tr><td>文件下载列表</td></tr>
        <tr><td><ul>
            <c:forEach var="fileName" items="${fileList}">
                <li><a href="${pageContext.request.contextPath}/
download?fileName=${fileName}">${fileName}</a></li>
            </c:forEach></ul> </td></tr>
        <tr><td>&nbsp;</td></tr>
        <tr><td><label for="fileField">File:</label>
            <input type="file" name="files" id="fileField"
                   multiple="multiple"></td></tr>
        <tr><td><input type="submit" id="submit" value="上传"></td></tr>
        <tr><td><c:if test="${uploadStatus=='OK'}"><b>上传成功</b></c:if>
            <c:if test="${uploadStatus=='ERROR'}">
                <label style="color: red">上传失败</label></c:if></td>
        </tr></tbody></table>
</form></body></html>

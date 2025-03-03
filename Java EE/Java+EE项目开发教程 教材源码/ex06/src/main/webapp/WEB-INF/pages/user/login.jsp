<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<html>
<head><title>用户登录</title></head>
<body>
<form method="post" action="login">
    <table width="344" height="95" border="0" cellpadding="0" cellspacing="1"
           style="background-color: #3A8ECD; color: #000000;">
        <tr><td height="30" colspan="2" align="center" valign="middle" style="color: #FFF">
            用户登录</td></tr>
        <tr><td width="114" height="30" align="right" valign="middle" bgcolor="#FFFFFF">
            登录名：</td>
            <td width="227" height="20" align="left" valign="middle" bgcolor="#FFFFFF">
                <input type="text" name="login_name" /></td></tr>
        <tr><td height="30" align="right" valign="middle" bgcolor="#FFFFFF">密码：</td>
            <td height="20" align="left" valign="middle" bgcolor="#FFFFFF">
                <input type="password" name="password" /></td></tr>
        <tr><td height="30" colspan="2" align="center" valign="middle" bgcolor="#FFFFFF">
            <input type="submit" name="button" id="button" value="提交" />&nbsp;
            <input type="reset" name="button2" id="button2" value="重置" /></td></tr>
    </table>
    <p style="color: #F00">${login_error}</p>
</form>
</body>
</html>

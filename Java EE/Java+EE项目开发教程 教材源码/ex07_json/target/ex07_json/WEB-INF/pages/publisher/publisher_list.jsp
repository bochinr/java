<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<html><head><title>出版社信息管理</title></head><body>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="0"
       style="border-collapse:collapse" bordercolor="#0099FF">
    <tr id="table-title"><td>选择</td><td>编号</td><td>名称</td><td>联系人</td></tr>
</table>
<p align="center"><a href="#" id="delete-publisher">删除</a></p>
<table align="center" width="500" border="0" cellspacing="0" cellpadding="0">
    <tbody>
    <tr><td>编号</td><td><input type="text" id="pub-id" size="10"></td></tr>
    <tr><td>名称</td><td><input type="text" id="pub-name" size="10"></td></tr>
    <tr><td>联系人</td><td><input type="text" id="contacter" size="5"></td></tr>
    <tr><td>&nbsp;</td><td>
        <input id="btn-add-publisher-object" type="button" value="添加(返回Java对象)">
        <input id="btn-add-publisher-response" type="button" value="添加(response响应)">
        <input id="btn-add-publisher-status" type="button" value="添加(返回状态)"></td>
    </tr></tbody></table>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    var pubId, pubName, contacter, publisher;
    function get_data(){ // 从表单对象中取数据
        pubId = $("#pub-id").val();
        pubName = $("#pub-name").val();
        contacter = $("#contacter").val();
        publisher ={"pubId":pubId, "pubName":pubName,"contacter":contacter}
    }
    function update_page_by_response_data(data){  // 根据响应数据更新页面
        var new_publisher = "<tr id='" + data.pubId + "'><td>" + "<input name='pubId' type='checkbox' value='" + data.pubId + "'>" + "</td><td>" + data.pubId
            + "</td><td>" + data.pubName + "</td><td>" + data.contacter + "</td></tr>";
        $("#table-title").after(new_publisher);
    }
    function update_page_by_local_data(){// 根据从表单对象中取出的数据更新页面
        var new_publisher = "<tr id='" + pubId + "'><td>" + "<input name='pubId' type='checkbox' value='" +pubId + "'>" + "</td><td>" + pubId + "</td><td>"
        + pubName + "</td><td>" + contacter + "</td></tr>";
        $("#table-title").after(new_publisher);
    }
    $("#btn-add-publisher-object").click(function(){
        get_data();
        $.post("${pageContext.request.contextPath}/publisher/publisher_list_return_object",
            publisher, function(data){
                if (data != null){
                    update_page_by_response_data(data);
                }
            },"json");
    })
    $("#btn-add-publisher-response").click(function() {
        get_data();
        $.ajax({
            url:"${pageContext.request.contextPath}/publisher/publisher_list_return_response",
            type:"post",
            data:JSON.stringify(publisher),
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success:function (data) {
                if (data != null){
                    update_page_by_response_data(data);
                }
            }});
    })
    $("#btn-add-publisher-status").click(function() {
        get_data();
        $.post("${pageContext.request.contextPath}/publisher/publisher_list_return_status",
            publisher, function(data){
                if (data == "OK"){
                    update_page_by_local_data();
                }
            });
    })
    $("#delete-publisher").click(function () {
        var chk_value = [];
        $('input[name="pubId"]:checked').each(function () {
            chk_value.push($(this).val());
        })
        var pubIds = chk_value.join(",");
        $.post("${pageContext.request.contextPath}/publisher/delete_publisher", {"pubIds":pubIds},
            function(data){
                if (data == "OK"){
                    for (var i = 0; i < chk_value.length; i ++)
                        $("#" + chk_value[i]).remove();
                }
            });
    })
</script></body></html>

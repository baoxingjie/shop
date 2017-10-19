<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/lib/css/bootstrap.min.css">
    <script src="/lib/js/jquery.min.js"></script>
    <script src="/lib/js/bootstrap.min.js"></script>
</head>

<body>
<div>
    <font color='red'>你好世界！</font>
</div>
<table class="table table-bordered table-striped table-hover">
    <caption>数据表管理</caption>
    <thead>
    <tr>
        <th width="5%">序号</th>
        <th width="5%">id</th>
        <th width="20%">编码</th>
        <th width="20%">名称</th>
        <th width="40%">时间</th>
        <th width="10%">操作</th>
    </tr>
    </thead>
    <tbody>
        <#list result as data>
        <tr>
            <td>
                ${data_index}
            </td>
            <td>
                ${data["id"]}
            </td>
            <td>
                ${data["code"]}
            </td>
            <td>
                ${data["name"]}
            </td>
            <td>
                ${data["gmt_modified"]}
            </td>
            <td>删除</td>
        </tr>    
        
        </#list>
    </tbody>
</table>
<font color="white" style="margin-left: 40%">
    Ip：${systemUtils.getIp()} 时间：${systemUtils.getTime()}
</font>

</body>
</html>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/lib/css/bootstrap.min.css">
    <script src="/lib/js/jquery.min.js"></script>
    <script src="/lib/js/bootstrap.min.js"></script>
</head>

<body>
<form id ="form" action="/ql" method="post">
    <div>
        <div>
            <textarea name="statement" rows="20" cols="100" placeholder="输入脚本内容.">${statement!""}</textarea>
        </div>
        <div>
            <input type ="submit">
        </div>
        <div>
            返回结果:<font color='red'>${result!""}</font>
        </div>
    </div>
</form>
</body>
</html>

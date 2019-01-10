<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>

<table>
    <tr>
        <td>登录</td>
        <td>密码</td>
    </tr>
        <tr>
            <td> <input type="text" id="login" value="1"></td>
            <td> <input type="text" id="pass" value="1"></td>
            <td> <input type="button" name="condition"></td>
        </tr>
</table>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
    $("[name='condition']").click(function () {
        console.log("====");
         window.location = "/login?user="+$("#login").val()+"&pass="+$("#pass").val();
    })
</script>

</body>
</html>
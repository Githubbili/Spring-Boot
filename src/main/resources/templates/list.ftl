<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>

<table>
    <tr>
        <td>${name}</td>
        <td colspan="11">
            <input type="text" placeholder="新密码" id="condition">
            <input type="button" name="condition">
        </td>
    </tr>
</table>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    $("[name='condition']").click(function () {
         location = "/list?condition="+$("#condition").val();
    })
</script>

</body>
</html>
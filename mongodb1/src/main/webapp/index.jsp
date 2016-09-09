<html>
<body>
<h2>Hello World!</h2>
<table>
    <tr>
        <th>
                data
        </th>
        <th>
            opera
        </th>
    </tr>
    <tbody id="tbody">

    </tbody>
</table>
<form action="/addUser" method="post" id="formData">
    <input id="username" placeholder="username" name="userName" type="text">
    <input placeholder="password" name="password" type="text">
    <input placeholder="id" name="id" type="text">
    <input type="button" onclick="save()" value="save">
    <input type="button" onclick="get()" value="get">
</form>
</body>
<script src="js/jquery.js"></script>
<script>
    $(function(){
        list();
    });
    function get(){
        window.open("/find?userName="+document.getElementById("username").value
        ,'newwindow', 'height=100, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
    }
    function list(){
        $.ajax({
            url:"/list",
            dataType:'json',
            success:function(list){
                var $tbody = $("#tbody");
                var buf = [];
                for (var i = 0; i < list.length; i++) {
                    var obj = list[i];
                    buf.push("<tr>");
                    buf.push("<td>");
                    buf.push(JSON.stringify(obj));
                    buf.push("</td>");
                    buf.push("<td>");
                    buf.push("<a href='javascript:;' onclick='removeOne(\""+obj.id+"\")'>remove</a>");
                    buf.push("</td>");
                    buf.push("</tr>");
                }
                $tbody.html(buf.join(""));
            }
        })
    }

    function removeOne(id){
        $.ajax({
            url:"/removeOne",
            data:{id:id},
            dataType:'json',
            success:function(){
                list();
            }
        })
    }

    function save(){
      var data =  $("#formData").serialize();
        $.ajax({
            url:"/addUser",
            type:'post',
            dataType:'json',
            data:data,
            success:function(res){
               if(res=='success'){
                   list();
               }
            }
        })
    }
</script>
</html>

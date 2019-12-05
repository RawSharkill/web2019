<%--
  Created by IntelliJ IDEA.
  User: kolibreath
  Date: 2019-11-21
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/tomcattest_war_exploded/FirstServlet" method="post">
    Username:<input type="text" name="username"/>
    Password:<input type="text" name="password"/>
    <input type="submit" value="login"/>
  </form>
  <script>
    //window onload 事件
    window.onload = function() {alert("完全加载")  };
    window.onresize = function(){
      alert("窗口宽"+ document.body.clientWidth);
      alert("窗口高"+ document.body.clientHeight);
    };
    //console.log()
    window.onunload = function(){ alert("unload 执行")};
  </script>
  </body>
</html>

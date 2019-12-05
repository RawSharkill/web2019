<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%!int pageCount = 0;

    void addCount() {
        pageCount++;
    }%>

<%
    addCount();
%>
<center>
    <p>Copyright © 2019 | 华中师范大学  访问次数：<%=pageCount%></p>
</center>


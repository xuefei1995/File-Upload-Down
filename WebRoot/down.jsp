<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>   
    <title>所有资源</title>   
  </head>
  
  <body>
    <table border="1">
    <tr>
    <td>编号</td>
    <td>名称</td>
    <td>大小</td>
    <td>类型</td>
    <td>日期</td>
    <td>操作</td>
    </tr>
	<c:forEach items="${requestScope.filelist }" var="file"  varStatus="filestr">
	    <tr>
	    <td>${filestr.count }</td>
	    <td>${file.name }</td>
	    <td>${file.size }</td>
	    <td>${file.type }</td>
	    <td>${file.time }</td>
	    <td><a href="${pageContext.request.contextPath }/FileDown?id=${filestr.count }">下载资源</a></td>
	    </tr>    
 	</c:forEach>
    </table>
  </body>
</html>

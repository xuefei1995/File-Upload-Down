<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
  <head>   
    <title>文件上传</title> 
    <script type="text/javascript" src="./js/upload.js"></script>  
  </head> 
  <body>
    <form action="${pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data" onsubmit="return check()">
    <table border="1" width="310px">
    	<tr><th colspan="2">选择上传的文件</th></tr>
    	<tbody>
    	<tr><td><input type="file" name="img"><input type="button" value="删除" onclick="delitem(this)"></td></tr>
    	</tbody>
    	<tr><td colspan="2"><input type="button" value="添加" onclick="additem()"></td></tr>
    	<tr><td><input type="submit" value="上传"><a href="${pageContext.request.contextPath }/DownServlet">所有资源</a></td></tr>
    </table> 
    </form>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/include/page.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>导航页 - 停车场后台</title>
	</head>
	<body>
		-->${rootPath }
		<table border="1" width="80%">
			<tr>
				<td>名字</td>
				<td>链接</td>
			</tr>
			<tr>
				<td>登陆后首页</td>
				<td><a href="${rootPath }/back/admins/main.html" target="_blank">登陆</a></td>
			</tr>
		</table>
	</body>
</html>
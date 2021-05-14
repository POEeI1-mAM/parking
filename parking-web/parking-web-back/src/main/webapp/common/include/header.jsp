<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 网页头部开始 -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">LOGO</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${rootPath }/head/UsersHeadServlet?method=main">首页</a></li>


				<c:choose>
					<c:when test="${usersSess != null }">
						<li><a
							href="${rootPath }/head/UsersHeadServlet?method=usersUpdate">我的信息</a></li>
							<li><a
							href="${rootPath }/head/UsersHeadServlet?method=usersUpdate&operType=update">修改信息</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${rootPath }/NoLoginHeadServlet?method=login">登陆</a></li>
						<li><a href="${rootPath }/NoLoginHeadServlet?method=usersinsert">注册</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="${rootPath }/head/UsersHeadServlet?method=logout" onclick="return confirm('确认退出吗?')">退出</a></li>
			</ul>
			<form class="navbar-form navbar-right visible-sm">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>

<!-- 提示信息 -->
<div class="container">
	<div class="col-sm-8 col-sm-offset-1">
		<c:if test="${info != '' && info != null }">
			<div class="alert alert-warning alert-dismissible fade in"
				role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				${info }
			</div>
		</c:if>
	</div>
</div>
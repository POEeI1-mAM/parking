<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include/page.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<title>停车场管理系统</title>
		<%@ include file="/common/include/title.jsp"%>
		<meta name="keywords" content="停车场管理系统">
		<meta name="description" content="停车场管理系统">
	</head>
	<body>
		<header class="navbar-wrapper">
			<div class="navbar navbar-fixed-top">
				<div class="container-fluid cl">
					<a class="logo navbar-logo f-l mr-10 hidden-xs"
						href="${rootPath }/back/AdminsBackServlet?method=main">
						停车场(LOGO)
					</a> 
					<a class="logo navbar-logo-m f-l mr-10 visible-xs"
						href="${rootPath }/back/AdminsBackServlet?method=main">停车场(LOGO)
					</a>
					<span class="logo navbar-slogan f-l mr-10 hidden-xs">v3.1</span>
					<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs"
						href="javascript:;">&#xe667;</a>
					
					<nav id="Hui-userbar"
						class="nav navbar-nav navbar-userbar hidden-xs">
						<ul class="cl">
							<li>${sessionScope.adminsSess.trueName }</li>
							<li class="dropDown dropDown_hover">
								<a href="#" class="dropDown_A">${sessionScope.adminsSess.email } <i class="Hui-iconfont">&#xe6d5;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li><a href="${rootPath }/back/AdminsBackServlet?method=logout" onclick="return confirm('确认退出吗?')">退出</a></li>
								</ul></li>
							
							<li id="Hui-skin" class="dropDown right dropDown_hover"><a
								href="javascript:;" class="dropDown_A" title="换肤"><i
									class="Hui-iconfont" style="font-size: 18px">&#xe62a;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li><a href="javascript:;" data-val="default"
										title="默认（黑色）">默认（黑色）</a></li>
									<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
									<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
									<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
									<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
									<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
								</ul></li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
		<aside class="Hui-aside">
			<div class="menu_dropdown bk_2">
				
				<dl id="menu-admin">
					<dt>
						<i class="Hui-iconfont">&#xe62e;</i> 停车场信息管理<i
							class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
							<dd>
							<ul>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">停车场列表</a>
							</li>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">添加停车场</a>
							</li>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">更新停车场</a>
							</li>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">删除停车场</a>
							</li>
							</ul>
							</dd>
					</dt>
					<dt>
						<i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i
							class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
					</dt>
					<dd>
						<ul>
							
							<li>
								<a data-href="${rootPath }/back/AuthBackServlet?method=menuTreeList" data-title="权限管理" href="javascript:void(0)">菜单列表(树形结构)</a>
							</li>
							<li>
								<a data-href="${rootPath }/back/admins/adminsList.html" data-title="管理员列表"
								href="javascript:void(0)">管理员列表</a>
							</li>
							
							
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">添加管理员</a>
							</li>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">更新管理员</a>
							</li>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">删除管理员</a>
							</li>
							
							
						</ul>
					</dd>
					<dt>
						<i class="Hui-iconfont">&#xe60d;</i> 用户管理<i
							class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
							<dd>
							<ul>
							
							
							<li>
								<a data-href="${rootPath }/back/AdminsBackServlet?method=adminsList" data-title="管理员列表"
								href="javascript:void(0)">用户列表</a>
							</li>
							
							
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">添加用户</a>
							</li>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">更新用户</a>
							</li>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">删除用户</a>
							</li>
							
							
						</ul>
							</dd>
					</dt>
					
					<dt>
						<i class="Hui-iconfont">&#xe61a;</i> 车辆管理<i
							class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
							<dd>
							<ul>
							
							
							<li>
								<a data-href="${rootPath }/back/AdminsBackServlet?method=adminsList" data-title="管理员列表"
								href="javascript:void(0)">车辆列表</a>
							</li>
							
							
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">添加车辆</a>
							</li>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">更新车辆</a>
							</li>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">删除车辆</a>
							</li>
							
							
						</ul>
							</dd>
					</dt>
					<dt>
						<i class="Hui-iconfont">&#xe61a;</i> 订单管理<i
							class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
							<dd>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">订单列表</a>
							</li>
							</dd>
					</dt>
					<dt>
						<i class="Hui-iconfont">&#xe61a;</i> 订单历史<i
							class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
							<dd>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">历史记录</a>
							</li>
							</dd>
					</dt>
					<dt>
						<i class="Hui-iconfont">&#xe622;</i> 评论<i
							class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
							<dd>
							<li>
								<a data-href="${rootPath }/back/UsersBackServlet?method=usersList" data-title="用户列表"
								href="javascript:void(0)">评论列表</a>
							</li>
							</dd>
					</dt>
					
				</dl>
				
				
			</div>
		</aside>
		<div class="dislpayArrow hidden-xs">
			<a class="pngfix" href="javascript:void(0);"
				onClick="displaynavbar(this)"></a>
		</div>
		<section class="Hui-article-box">
			<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
				<div class="Hui-tabNav-wp">
					<ul id="min_title_list" class="acrossTab cl">
						<li class="active"><span title="我的桌面" data-href="welcome.html">我的桌面</span>
							<em></em></li>
					</ul>
				</div>
				<div class="Hui-tabNav-more btn-group">
					<a id="js-tabNav-prev" class="btn radius btn-default size-S"
						href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
						id="js-tabNav-next" class="btn radius btn-default size-S"
						href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
				</div>
			</div>
			<div id="iframe_box" class="Hui-article">
				<div class="show_iframe">
					<div style="display: none" class="loading"></div>
					<!-- 
						iframe:相当于jsp的包含,将另外一个网页的内容包含进来
						src:就是包含网页的路径;jsp:file; src:可以是任何一个网址
					 -->
					<iframe scrolling="yes" frameborder="0" src="${rootPath }/back/admins/welcome.html"></iframe>
				</div>
			</div>
		</section>
	
		<div class="contextMenu" id="Huiadminmenu">
			<ul>
				<li id="closethis">关闭当前</li>
				<li id="closeall">关闭全部</li>
			</ul>
		</div>
		
	</body>
</html>
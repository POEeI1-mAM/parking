<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include/page.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<title>管理员列表 - 用户中心</title>
		<%@ include file="/common/include/title.jsp" %>
		<!--请在下方写此页面业务相关的脚本-->
		<script type="text/javascript" src="${rootPath }/common/resource/H-ui.admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
		<script type="text/javascript" src="${rootPath }/common/resource/H-ui.admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="${rootPath }/common/resource/H-ui.admin/lib/laypage/1.2/laypage.js"></script>
		<script type="text/javascript">
			/*
			 参数解释：
			 title	标题
			 url		请求的url
			 id		需要操作的数据id
			 w		弹出层宽度（缺省调默认值）
			 h		弹出层高度（缺省调默认值）
			 */
			/*管理员-增加*/
			function admin_add(title, url, w, h) {
				layer_show(title, url, w, h);
			}
			/*管理员-删除*/
			function admin_del(obj, id) {
				layer.confirm('确认要删除吗？', function(index) {
					$.ajax({
						type : 'POST',
						url : '',
						dataType : 'json',
						success : function(data) {
							$(obj).parents("tr").remove();
							layer.msg('已删除!', {
								icon : 1,
								time : 1000
							});
						},
						error : function(data) {
							console.log(data.msg);
						},
					});
				});
			}
	
			/*管理员-编辑*/
			function admin_edit(title, url, id, w, h) {
				layer_show(title, url, w, h);
			}
			/*管理员-停用*/
			function admin_stop(obj, id) {
				layer
						.confirm(
								'确认要停用吗？',
								function(index) {
									//此处请求后台程序，下方是成功后的前台处理……
	
									$(obj)
											.parents("tr")
											.find(".td-manage")
											.prepend(
													'<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
									$(obj)
											.parents("tr")
											.find(".td-status")
											.html(
													'<span class="label label-default radius">已禁用</span>');
									$(obj).remove();
									layer.msg('已停用!', {
										icon : 5,
										time : 1000
									});
								});
			}
	
			/*管理员-启用*/
			function admin_start(obj, id) {
				layer
						.confirm(
								'确认要启用吗？',
								function(index) {
									//此处请求后台程序，下方是成功后的前台处理……
	
									$(obj)
											.parents("tr")
											.find(".td-manage")
											.prepend(
													'<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
									$(obj)
											.parents("tr")
											.find(".td-status")
											.html(
													'<span class="label label-success radius">已启用</span>');
									$(obj).remove();
									layer.msg('已启用!', {
										icon : 6,
										time : 1000
									});
								});
			}
		</script>
	</head>
	<body>
		<nav class="breadcrumb">
			<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
			管理员管理 <span class="c-gray en">&gt;</span> 管理员列表 <a
				class="btn btn-success radius r"
				style="line-height: 1.6em; margin-top: 3px"
				href="javascript:location.replace(location.href);" title="刷新"><i
				class="Hui-iconfont">&#xe68f;</i></a>
		</nav>
		<div class="page-container">
			<form action="${rootPath }/back/admins/adminsList.html" method="post">
				<div class="text-c">
					<input type="text" class="input-text" style="width: 250px" placeholder="输入关键字" 
					id="" name="keyword" value="${requestScope.keyword }">
					状态:
					<select name="status">
						<option value="" ${requestScope.status == '' ? 'selected' : ''}>请选择</option>
						<option value="1"  ${requestScope.status == '1' ? 'selected' : ''}>启用</option>
						<option value="0" ${requestScope.status == '0' ? 'selected' : ''}>禁用</option>
					</select>
					日期范围：
					<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" 
					id="datemin" name="st" readonly="readonly" class="input-text" 
					 value="${requestScope.st }"
					style="width: 150px;">
					- 
					<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" 
					id="datemax" name="ed" readonly="readonly" class="input-text" 
					value="${requestScope.ed }"
					style="width: 150px;">
					<button type="submit" class="btn btn-success" id="" name="">
						<i class="Hui-iconfont">&#xe665;</i> 搜索
					</button>
				</div>
			</form>
			<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
					<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">
						<i class="Hui-iconfont">&#xe6e2;</i>
						批量删除
					</a>
					<%--
						onclick事件
						参数1:弹出选项卡的标题,
						参数2:url
						参数3:宽度
						参数4:高度
					 --%>
					<a href="javascript:;" onclick="admin_add('添加管理员','${rootPath}/back/AdminsBackServlet?method=adminsInsert','800','500')"
						class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
						添加管理员
					</a>
				</span>
				<span class="r">共有数据：<strong>${requestScope.pageInfoUtil.totalRecord }</strong> 条
				</span>
			</div>
			<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper no-footer">
				<table class="table table-border table-bordered table-bg">
					<thead>
						<tr>
							<th scope="col" colspan="9">管理员列表</th>
						</tr>
						<tr class="text-c">
							<th width="25"><input type="checkbox" name="" value=""></th>
							<th width="80">id</th>
							<th width="80">邮箱</th>
							<th width="80">真实姓名</th>
							<th width="50">状态</th>
							<th width="140">创建时间</th>
							<th width="140">上次登陆时间</th>
							<th width="80">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.adminsList }" var="admins" varStatus="stat">
							<tr class="text-c">
								<td><input type="checkbox" value="1" name=""></td>
								<td>${admins.id }</td>
								<td>${admins.email }</td>
								<td>${admins.trueName }</td>
								<td class="td-status">
									<span class="label label-success radius">
										<%-- <c:choose>
											<c:when test="${admins.status == 1 }">
												启用
											</c:when>
											<c:when test="${admins.status == 0 }">
												禁用
											</c:when>
											<c:otherwise>
												未知
											</c:otherwise>
										</c:choose> --%>
										<!-- 默认调用get方法 -->
										${admins.statusStr}
									</span>
								</td>
								<td><fmt:formatDate value="${admins.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${admins.lastLoginTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td class="td-manage">
									<!-- <a style="text-decoration: none" onClick="admin_stop(this,'10001')" href="javascript:;" title="停用">
										<i class="Hui-iconfont">&#xe631;</i>
									</a> -->
									<a title="查看" href="javascript:;" onclick="admin_edit('管理员查看','${rootPath}/back/AdminsBackServlet?method=adminsUpdate&id=${admins.id }','admins_view_${admins.id }','800','500')"
										class="ml-5" style="text-decoration: none">
										<i class="Hui-iconfont">&#xe631;</i>
									</a>
									<a title="编辑" href="javascript:;" onclick="admin_edit('管理员编辑','${rootPath}/back/AdminsBackServlet?method=adminsUpdate&operType=adminsUpdate&id=${admins.id }','admins_edit_${admins.id }','800','500')"
										class="ml-5" style="text-decoration: none">
										<i class="Hui-iconfont">&#xe6df;</i>
									</a>
									<a title="删除" href="javascript:;" onclick="admin_del(this,'1')" class="ml-5"
									style="text-decoration: none">
										<i class="Hui-iconfont">&#xe6e2;</i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<form action="${rootPath }/back/AdminsBackServlet?method=adminsList" id="pageForm" method="post">
					<!-- 在每次提交的时候,将搜索条件放到表单中
						hidden:隐藏域,不会在页面上显示
					 -->
					<input type="hidden" name="keyword" value="${requestScope.keyword }">
					<input type="hidden" name="status" value="${requestScope.status }">
					<input type="hidden" name="st" value="${requestScope.st }">
					<input type="hidden" name="ed" value="${requestScope.ed }">
				
					<div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">
						共 ${requestScope.pageInfoUtil.totalRecord } 条,
						共${requestScope.pageInfoUtil.totalPage }页 
					</div>
					<div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate">
						<a class="paginate_button previous"
							aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0"
							href="#"
							onclick="return pageFormSubmit('pageForm','currentPage','1','pageSize','${requestScope.pageInfoUtil.pageSize }')"
							id="DataTables_Table_0_previous">首页
						</a>
						<a class="paginate_button previous"
							aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0"
							onclick="return pageFormSubmit('pageForm','currentPage','${requestScope.pageInfoUtil.prePage }','pageSize','${requestScope.pageInfoUtil.pageSize }')"
							id="DataTables_Table_0_previous">上一页
						</a>
						<!-- <span>
							<a class="paginate_button current" aria-controls="DataTables_Table_0"
							data-dt-idx="1" tabindex="0">
							1
							</a>
						</span> -->
						<a class="paginate_button next"
							aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0"
							onclick="return pageFormSubmit('pageForm','currentPage','${requestScope.pageInfoUtil.nextPage }','pageSize','${requestScope.pageInfoUtil.pageSize }')"
							id="DataTables_Table_0_next">
							下一页
						</a>
						<a class="paginate_button previous"
							aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0"
							onclick="return pageFormSubmit('pageForm','currentPage','${requestScope.pageInfoUtil.totalPage }','pageSize','${requestScope.pageInfoUtil.pageSize }')"
							id="DataTables_Table_0_previous">尾页
						</a>
						第<input type="text" id="currentPage" name="currentPage" value="${requestScope.pageInfoUtil.currentPage }" size="5" maxlength="5" class="paginate_button">页
						每页<input type="text" id="pageSize" name="pageSize" value="${requestScope.pageInfoUtil.pageSize }" size="5" maxlength="5" class="paginate_button">条
						<input type="submit" value="GO" class="paginate_button">
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
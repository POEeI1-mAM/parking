<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jsp所有公共的部分
	静态包含
 --%>
<%-- 引入JSTL标签 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%-- 设置上下文路径(项目名)
	String rootPath = request.getContextPath();
 --%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
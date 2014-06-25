<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.orm.User"%>
<%@page import="com.bean.PageBean"%>
<%@ page language="java" pageEncoding="GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'contact.jsp' starting page</title>
</head>

<body>
	<%
		PageBean pBean = (PageBean) request.getAttribute("page");
		List data = pBean.getData();
		Iterator it = data.iterator();
	%>
	<center>
		<font color=blue>用户管理页面:</font><br>
		<p></p>
		<table bgcolor=ffffff cellspacing="1" cellpadding="1" width=600>
			<tr bgcolor=55cc88>
				<th>用户ID</th>
				<th>用户名</th>
				<th>密码</th>
			</tr>

			<%
				while (it.hasNext()) {
					User user = (User) it.next();
					int id = user.getId();
					String userName = user.getUserName();
					String password = user.getPassword();
			%>
			<tr bgcolor=55cc88 align=center>
				<td><%=id%></td>
				<td><%=userName%></td>
				<td><%=password%></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			//if (pBean.totalPage != 1) {
		%>
		<jsp:include page="foot.jsp">
			<jsp:param name="rowsPage" value="<%=pBean.rowsPage %>" />
			<jsp:param name="totalRows" value="<%=pBean.totalRows %>" />
			<jsp:param name="currentPage" value="<%=pBean.currentPage %>" />
			<jsp:param name="totalPage" value="<%=pBean.totalPage %>" />
		</jsp:include>

		<%
			//}
		%>
	</center>
</body>
</html>

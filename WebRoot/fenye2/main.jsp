<%@page import="com.pager.Pager_demo"%>
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
		Pager_demo<User> pager = (Pager_demo<User>) request.getAttribute("pager");
		List<User> users = pager.getList();
	%>
	<center>
		<font color=blue>�û�����ҳ��:</font><br>
		<p></p>
		<table bgcolor=ffffff cellspacing="1" cellpadding="1" width=600>
			<tr bgcolor=55cc88>
				<th>�û�ID</th>
				<th>�û���</th>
				<th>����</th>
			</tr>

			<%
				for(User user :users) {
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
			<jsp:param name="rowsPage" value="<%=pager.getCurPageNum()%>" />
			<jsp:param name="totalRows" value="<%=pager.getTotalRecode() %>" />
			<jsp:param name="currentPage" value="<%=pager.getCurPageNum() %>" />
			<jsp:param name="totalPage" value="<%=pager.getPageRecode() %>" />
		</jsp:include>

		<%
			//}
		%>
	</center>
</body>
</html>

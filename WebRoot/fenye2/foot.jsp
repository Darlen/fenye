<%@page import="com.bean.PageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	int rowsPage = Integer.valueOf(request.getParameter("rowsPage"));
	int totalRows = Integer.valueOf(request.getParameter("totalRows"));
	int currentPage = Integer.valueOf(request.getParameter("currentPage"));
	int totalPage = Integer.valueOf(request.getParameter("totalPage"));
%>

<script type="text/javascript">
	function Jumping(obj) {
		/*var select = document.getElementById("jumpNum");
	    var index = select.selectedIndex;
	    var text = select.options[index].text;
	    var value = select.options[index].value;*/
	    document.PageForm.jumpPage.value = obj.value;
		document.PageForm.submit();
	}
	function gotoPage(pagenum) {
		document.PageForm.jumpPage.value = pagenum;
		document.PageForm.submit();
	}
</script>
每页<%=rowsPage%>行 共<%=totalRows%>行 第<%=currentPage%>页 共<%=totalPage%>页
<%
	if (currentPage == 1) {
		out.print("首页　上一页");
	} else {
%>
<a href="javascript:gotoPage(1)">首页</a>
<a href="javascript:gotoPage(<%=currentPage - 1%>)">上一页</a>
<%
	}
	if (currentPage == totalPage) {
		out.print("下一页　尾页");
	} else {
%>
<a href="javascript:gotoPage(<%=currentPage + 1%>)">下一页</a>
<a href="javascript:gotoPage(<%=totalPage%>)">尾页</a>
<%
	}
%>

转到第
<select name="jumpPage"  onchange="Jumping(this)">
	<%
		for (int i = 1; i <= totalPage; i++) {
			if (i == currentPage) {
	%>

	<option selected value=<%=i%>><%=i%></option>
	<%
		} else {
	%>
	<option value=<%=i%>><%=i%></option>
	<%
		}
		}
	%>
</select>
页
<form name="PageForm" action="fenye2" method="post">
	<input type="hidden" name="jumpPage" value="">
</form>


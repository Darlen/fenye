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
ÿҳ<%=rowsPage%>�� ��<%=totalRows%>�� ��<%=currentPage%>ҳ ��<%=totalPage%>ҳ
<%
	if (currentPage == 1) {
		out.print("��ҳ����һҳ");
	} else {
%>
<a href="javascript:gotoPage(1)">��ҳ</a>
<a href="javascript:gotoPage(<%=currentPage - 1%>)">��һҳ</a>
<%
	}
	if (currentPage == totalPage) {
		out.print("��һҳ��βҳ");
	} else {
%>
<a href="javascript:gotoPage(<%=currentPage + 1%>)">��һҳ</a>
<a href="javascript:gotoPage(<%=totalPage%>)">βҳ</a>
<%
	}
%>

ת����
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
ҳ
<form name="PageForm" action="fenye2" method="post">
	<input type="hidden" name="jumpPage" value="">
</form>


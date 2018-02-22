<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.Expense"%>
<%
	FERService ferService = new FERServiceImpl();

	int Expense_id = Integer.parseInt(request.getParameter("Expense_id"));

	boolean deleteExpenseFlag = ferService.deleteExpense(Expense_id);

	if (deleteExpenseFlag) {
%>
<jsp:include page="HeaderAndLeftFrame.jsp"/>

<%
	out.println("Delete Successfully");
	} else {
		out.println("Delete Failed");
	}
%>
<jsp:include page="Footer.jsp"/>
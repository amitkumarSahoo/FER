<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.Expense"%>
	<%@ page session="false" %>
<%
		FERService ferService = new FERServiceImpl();
		HttpSession session = request.getSession();
		Expense expense = new Expense();
		
		int numberOfItems = Integer.parseInt(request.getParameter("numberOfItems"));
		int Expense_id= Integer.parseInt(session.getAttribute("Expense_id").toString());
		
		expense.setExpense_id(Expense_id);
		expense.setExpense_type(request.getParameter("expenseType"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(request.getParameter("price"));
		expense.setNo_of_items(numberOfItems);
		expense.setTotal(request.getParameter("total"));
		expense.setBywhom(request.getParameter("byWhom"));

		boolean editExpenseReportFlag = ferService.editExpense(expense);
		
		if (editExpenseReportFlag) {
%>
<jsp:include page="HeaderAndLeftFrame.jsp"/>
<%
out.println("edit successfully");
		} else {
			out.println("edit failed");
		}
%>
<jsp:include page="Footer.jsp"/>
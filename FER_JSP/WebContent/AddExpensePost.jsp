<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.Expense"%>
<%
	FERService ferService = new FERServiceImpl();

	Expense expense = new Expense();

	int noOfItems = Integer.parseInt(request.getParameter("numberOfItems"));
	expense.setExpense_type(request.getParameter("expenseType"));
	expense.setDate(request.getParameter("date"));
	expense.setPrice(request.getParameter("price"));
	expense.setNo_of_items(noOfItems);
	expense.setTotal(request.getParameter("total"));
	expense.setBywhom(request.getParameter("byWhom"));

	boolean addExpenseFlag = ferService.addExpense(expense);

	if (addExpenseFlag) {
%>
<jsp:include page="HeaderAndLeftFrame.jsp"/>

<%
	out.println("Expense Add Successfully");
	}

	else {
		out.println("Add expense Failed");

	}
%>
<jsp:include page="Footer.jsp"/>
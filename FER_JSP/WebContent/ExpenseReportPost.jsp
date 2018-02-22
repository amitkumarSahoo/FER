<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.Expense,java.util.List"%>

<% 
	FERService ferService = new FERServiceImpl();

	String expenseType = request.getParameter("expenseType");
	String fromDate = request.getParameter("fromDate");
	String toDate = request.getParameter("toDate");
	
	List<Expense> expenses = ferService.getExpenseReport(expenseType, fromDate, toDate);
	if (expenses != null) {
	%>
	<jsp:include page="HeaderAndLeftFrame.jsp"/>
<table border='1' align='center'>
	<tr height='50px'>
		<td>Expense Type</td>
		<td>Date</td>
		<td>Price</td>
		<td>Number of Items</td>
		<td>Total</td>
		<td>By Whom</td>
	</tr>
	<% 	for (Expense expense : expenses) {%>

	<tr>
		<td><%= expense.getExpense_type()%></td>
		<td><%= expense.getDate()%></td>
		<td><%= expense.getPrice()%></td>
		<td><%= expense.getNo_of_items()%></td>
		<td><%= expense.getTotal()%></td>
		<td><%= expense.getBywhom()%></td>
		<td colspan='2'></td>
	</tr>
	<% }%>
</table>

<%}
	else {
			out.println("No Expenses Found For the Given input");
		}
	
%>
<jsp:include page="Footer.jsp"/>

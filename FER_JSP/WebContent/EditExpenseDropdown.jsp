<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.Expense,java.util.List"%>

<%
	FERService ferService = new FERServiceImpl();
	List<Expense> expenses = ferService.getExpenses();
%>
<jsp:include page="HeaderAndLeftFrame.jsp"/>
<form action='EditExpense.jsp' method='post'>
	<table border='1'>

		<align='center'>ExpenseId <select name='Expense_id'>
			<%
				for (Expense expense : expenses) {
			%>
			<option value= <%= expense.getExpense_id() %>>
				<%=expense.getExpense_id()+" "+ expense.getExpense_type()+" "+ expense.getDate()%>
			</option>
			<%} %>
		</select> <br>
		<br>
		<input type='submit' value='Edit'>&nbsp;&nbsp;&nbsp;
		</td>
	</table>
<jsp:include page="Footer.jsp"/>

<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.Expense"%>
<%@ page session="false"%>
<%
	FERService ferservice = new FERServiceImpl();
	int Expense_id = Integer.parseInt(request.getParameter("Expense_id"));
	Expense expense = ferservice.getExpense(Expense_id);
	
	

	HttpSession session = request.getSession();
	session.setAttribute("Expense_id", Expense_id);
%>
<jsp:include page="HeaderAndLeftFrame.jsp"/>
<form action='EditExpensePost.jsp' method='post'>
	<table border='1'>
		<tr>
			<td align='center' colspan='2'>Edit Expense</td>
		</tr>

		<tr>
			<td>Expense Type</td>
			<td align='center'><input type='text' name='expenseType'
				value=<%=expense.getExpense_type()%>></td>
		</tr>

		<tr>
			<td>Date</td>
			<td align='center'><input type='text' name='date'
				value=<%=expense.getDate()%>></td>
		</tr>

		<tr>
			<td>Price</td>
			<td align='center'><input type='text' name='price'
				value=<%=expense.getPrice()%>></td>
		</tr>

		<tr>
			<td>Number Of Items</td>
			<td align='center'><input type='text' name='numberOfItems'
				value=<%=expense.getNo_of_items()%>></td>
		</tr>

		<tr>
			<td>Total</td>
			<td align='center'><input type='text' name='total'
				value=<%=expense.getTotal()%>></td>
		</tr>

		<tr>
			<td>ByWhom</td>
			<td align='center'><input type='text' name='byWhom'
				value=<%=expense.getBywhom()%>></td>
		</tr>

		<tr>
			<td align='center' colspan='2'><input type='submit' value='Edit'>&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
	</table>
<jsp:include page="Footer.jsp"/>
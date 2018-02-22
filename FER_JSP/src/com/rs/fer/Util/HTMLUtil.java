package com.rs.fer.Util;

import java.io.PrintWriter;

public class HTMLUtil {
	public static void generateHeaderAndLeftFrame(PrintWriter out) {
		
		out.println("</html>");
		out.println("</body>");
		out.println("<table border='1' align='center' width='800px' height='500px'> ");
		out.println("<tr height= '100px'>");
		out.println("<td align='center' colspan='2'> ");
		out.println("<b>Family Expense Report</b> ");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr> ");
		out.println("<td width='150px'>");
		out.println("<br> <a href='displayAddExpense'>Add expense</a> ");
		out.println("<br> <a href='displayEditExpenseDropdown'>Edit expense</a> ");
		out.println("<br> <a href='displayDeleteExpense'>Delete expense</a>");
		out.println("<br> <a href='displayExpenseReport'>Expense report</a> ");
		out.println("<br> <a href='displayResetPassword'>Reset password</a>");
		out.println("<br> <a href='displayPersonalName'>Update personal info</a>");
		out.println("</td>");
		out.println("<td align='center'>");

	}

	public static void generateFooter(PrintWriter out) {
		
		out.println("</td>");
		out.println("<tr  height='100px'>");
		out.println("<td align='center' colspan='2'>");
		out.println("Footer");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>"); 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}
}

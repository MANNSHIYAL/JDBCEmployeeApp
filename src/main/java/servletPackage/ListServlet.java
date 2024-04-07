package servletPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String insertEmployee = "insertEmployee.html";
		String deleteServlet = "DeleteServlet";
		ArrayList<Employee> employeeList;
		PrintWriter out = response.getWriter();
		try {
			employeeList = Operations.listEmployee();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>List of Employees");
			out.println("</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<table>");
			out.println("<tr>"
					+ "<th>Sr.No</th>"
					+ "<th>Name</th>"
					+ "<th>Phone</th>"
					+ "<th>Email</th>"
					+ "<th>Country</th>"
					+ "<th>Salary</th>"
					+ "<th>Style</th>"
					+ "<th>Delete</th>"
					+ "</tr>");
			for(Employee employee : employeeList) {
				out.println("<tr>");
				out.println("<td>"+employee.sr_no+"</td>");
				out.println("<td>"+employee.name+"</td>");
				out.println("<td>"+employee.phoneNumber+"</td>");
				out.println("<td>"+employee.email+"</td>");
				out.println("<td>"+employee.country+"</td>");
				out.println("<td>"+employee.salary+"</td>");
				out.println("<td>"+employee.style+"</td>");
				out.println("<td><a href="+deleteServlet+"?sr_no="+employee.sr_no+">remove</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<form action='"+insertEmployee+"'>");			
			out.println("<input type='submit' value='ADD'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}catch(Exception e) {}
	}

}

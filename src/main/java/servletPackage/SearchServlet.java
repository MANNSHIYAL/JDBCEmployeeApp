package servletPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int sr_no = Integer.parseInt(request.getParameter("id"));
		try {
			Employee employee = Operations.findEmployee(sr_no);
			out.println("<html>");
			out.println("<head>");
			out.println("<title> Show Employee Data");
			out.println("</title>");
			out.println("<body>");
			if(employee != null) {
				out.println("<p>Name: '"+employee.name+"'<br>"
						+ "Phone: '"+employee.phoneNumber+"'<br>"
						+ "E-Mail: '"+employee.email+"'<br>"
						+ "Country: '"+employee.country+"'<br>"
						+ "Salary: '"+employee.salary+"'<br>"
						+ "Style: '"+employee.style+"'<br>"
						+ "</p>");
			}else {
				out.println("<p>No employee found with ID: '"+sr_no+"'</p>");
			}
			out.println("</body>");
			out.println("</html>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("ListServlet");
		}
	}

}

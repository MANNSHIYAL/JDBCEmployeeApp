package servletPackage;
//import AJPProject.MyProject.src.employeePackage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		int salary;
		if(!request.getParameter("salary").equals("")) {
			salary = Integer.parseInt(request.getParameter("salary"));
		}else {
			salary = 0;
		}
		String style = request.getParameter("style");
		int recordChanged = 0;
		String message = "Record Added";
		
			recordChanged = Operations.insertEmployee(name, phoneNumber, email, country, salary, style);
			out.println("<html>");
			out.println("<head>");
			out.println("<title> Alert");
			out.println("</title>");
			out.println("</head>");
			out.println("<body>");
			if(recordChanged == 1) {
				String myAlert = "alert('"+recordChanged+" '+'"+message+"')";
				out.println("<script>"+myAlert+"</script>");
			}else {
				
			}
			out.println("<script>");
			out.println("window.location.replace('ListServlet');");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>");			
		}catch(Exception e) {
			response.sendRedirect("ListServlet");
		}
	}
	public void destroy() {
		
	}
}

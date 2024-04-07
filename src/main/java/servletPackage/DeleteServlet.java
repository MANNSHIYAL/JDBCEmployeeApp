package servletPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String message = "Record Deleted";
		try {
			int sr_no = 0;
			if(!(request.getParameter("sr_no") == null)) {
				sr_no = Integer.parseInt(request.getParameter("sr_no"));
			}
			int status = Operations.deleteEmployee(sr_no);
			if(status == 1) {
				out.println("<html>");
				out.println("<head>");
				out.println("<title> Alert");
				out.println("</title>");
				String myAlert = "alert('"+status+" '+'"+message+"');";
				out.println("<script>"+myAlert+"</script>");
				out.println("<script>");
				out.println("window.location.replace('ListServlet');");
				out.println("</script>");
				out.println("</head>");
				out.println("<body>");
				out.println("</body>");				
				out.println("</html>");
			}
		} catch (ClassNotFoundException e) {
		}
	}
}
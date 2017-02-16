

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/anyadir")
public class AñadirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AñadirServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String atributo = request.getParameter("atributo");
		String valor = request.getParameter("valor");
		
		HttpSession sesion = request.getSession();
		sesion.setAttribute(atributo, valor);
		
		Enumeration nombresAtributos = sesion.getAttributeNames(); 
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Sesion de usuario</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Datos de la sesión de usuario</h1>");
		
		while(nombresAtributos.hasMoreElements()){
			String nombreAtributo = (String)nombresAtributos.nextElement();
			String valorAtributo = (String)sesion.getAttribute(nombreAtributo);
			out.println(nombreAtributo + " - " + valorAtributo + "<br>");
			
		}
		
		out.println("</body>");

		out.println("</html>");
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

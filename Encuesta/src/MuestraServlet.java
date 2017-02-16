

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

@WebServlet("/mostrar")
public class MuestraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MuestraServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellido");
		String estudios = request.getParameter("estudios");
		String[] preferencias = request.getParameterValues("preferencias");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>IE</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Resultado Encuesta</h1>");
		out.println("<p>Nombre: " + nombre + "</p>");
		out.println("<p>Apellidos: " + apellidos + "</p>");
		out.println("<p>Estudios: " + estudios + "</p>");
		out.println("Preferencias: <br>");
		for (String pref : preferencias) {
			out.println("-" + pref + "<br>");	
		}
		
		out.println("</body>");

		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

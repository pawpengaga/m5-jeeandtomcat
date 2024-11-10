package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaTilines
 */
@WebServlet("/hola-tilines")
public class HolaTilines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaTilines() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath())
		
		// Vamos a imprimir HTML
		response.setContentType("text/html");
		
		// Vamos a usar los params de GET
		String nombre = request.getParameter("nombre");
		
		String rut = request.getParameter("rut");
		String edad = request.getParameter("edad");
		
		int edadFormateada;
		

		
		
		// Este es lo mismo que el syso
		PrintWriter salida = response.getWriter();
		salida.println("<html><body>");
		salida.println("<h1>Hola " + nombre + "</h1>");
		
		salida.println("<p>Su rut es " + rut + "</p>");

		if (edad.isEmpty() == false){
			edadFormateada = Integer.parseInt(edad);
			salida.println("<p>Su edad es de: " + edadFormateada + " anios...</p>");
		} else {
			edadFormateada = 0;
		}
		
		salida.println("<form action='http://localhost:8090/holaTilines/hola-tilines' method='GET'>");
		salida.println("<input type=\"edad\" name=\"edad\" placeholder=\"INGRESE SU EDAD\" />");
		salida.println("<input type=\"submit\" value=\"Enviar\" />");
		salida.println("</form>");
		
		salida.println("<br/> <br/>");
		
		salida.println("<h2>Calculadora</h2>");
		salida.println("<br />");
		// Ahora el profesor va a hacer la suma de dos valores
		salida.println("<form action='/holaTilines/hola-tilines' method='POST'>");
		salida.println("NUMERO 1: <input type=\"text\" name=\"num1\"/><br/>");
		salida.println("NUMERO 2: <input type=\"text\" name=\"num2\"/><br/>");
		salida.println("<input type=\"submit\" value=\"Sumar\" />");
		salida.println("</form>");
		
		
		if (edadFormateada > 0 && edadFormateada < 18) {
			salida.println("<p>Usted no es mayor de edad...</p>");
		} else if (edadFormateada >= 18) {
			salida.println("<p>Usted ES mayor de edad</p>");
		} else {
			salida.println("<p>La edad tiene que ser mayor que 0.</p>");
		}
		
		salida.println("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Aqui va a llegar la suma de los numeros...
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
		
		String nom1 = request.getParameter("num1");
		String nom2 = request.getParameter("num2");
		
		int num1 = Integer.parseInt(nom1);
		int num2 = Integer.parseInt(nom2);
		int resultado = num1 + num2;
		
		//doGet(request, response);
		
		salida.println("<html><body>");
		salida.println("<h3>RESULTADO</h3>");
		salida.println("<p>La suma de los valores " + num1 + " y " + num2 + " es: " + resultado + "</p>");
		salida.println("</html></body>");
		
		
		
	}

}

package org.example;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exeption.PermisoRepetidoExcepcion;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;



@WebServlet(name = "AgregarPermisoC", value = "/agregar-permisoC")
public class AgregarPermisoC extends HttpServlet {
    @EJB
    PNCRemote permisoC;
    public AgregarPermisoC() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("numero");
        String patente = request.getParameter("texto");
        String fecha = request.getParameter("fecha");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechav = null;
        RequestDispatcher rd;


        try {
            int numero = Integer.parseInt(id);
            fechav = formatter.parse(fecha);
            try {
                permisoC.agregarPermisoC(numero, fechav, patente);
            } catch (PermisoRepetidoExcepcion e) {
                response.setContentType("text/html");
                response.setHeader("Refresh", "2;url=AltaPC.jsp");

                PrintWriter out = response.getWriter();
                out.println("<html><head><title>Repetido</title></head><body>");
                out.println("<h1>Operación Fallida</h1>");
                out.println("<p>La id que a insertado ya esta siendo usada por otro permiso</p>");
                out.println("<p>Redirigiendo a la página en 2 segundos...</p>");
                out.println("</body></html>");
                out.close();
                throw new RuntimeException(e);
            }
            response.setContentType("text/html");
            response.setHeader("Refresh", "2;url=AltaPC.jsp");

            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Mensaje de éxito</title></head><body>");
            out.println("<h1>Operación realizada con éxito</h1>");
            out.println("<p>Redirigiendo a la página en 2 segundos...</p>");
            out.println("</body></html>");
            out.close();

            /*rd = request.getRequestDispatcher("/AltaPC.jsp");
            rd.forward(request, response);*/

        } catch (Exception e) {
            response.setContentType("text/html");
            response.setHeader("Refresh", "2;url=AltaPC.jsp");

            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Mensaje de Fracaso</title></head><body>");
            out.println("<h1>Operación Fallida</h1>");
            out.println("<p>Redirigiendo a la página en 2 segundos...</p>");
            out.println("</body></html>");
            out.close();
            throw new RuntimeException(e);
        }
    }
}




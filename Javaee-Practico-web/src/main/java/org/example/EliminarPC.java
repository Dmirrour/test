package org.example;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EliminarEmpresa", value = "/eliminar-PC")
public class EliminarPC extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    PNCRemote permiso;

    public EliminarPC() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println(request.getParameter("delete"));
            String id = request.getParameter("delete");

            int numero= Integer.parseInt(id);
            //System.out.println(numero+"/n  asdadasds\n\n");
            permiso.eliminarPermisoC(numero);
            response.setContentType("text/html");
            response.setHeader("Refresh", "5;url=index.jsp");

            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Mensaje de éxito</title></head><body>");
            out.println("<h1>Operación realizada con éxito</h1>");
            out.println("<p>Redirigiendo a la página en 5 segundos...</p>");
            out.println("</body></html>");
            out.close();
        }catch (Exception e){
            response.setContentType("text/html");
            response.setHeader("Refresh", "5;url=index.jsp");

            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Mensaje de fallo</title></head><body>");
            out.println("<h1>La Operación no logro encotrar su permiso a borrar</h1>");
            out.println("<p>Redirigiendo a la página en 5 segundos...</p>");
            out.println("</body></html>");
            out.close();
            throw new RuntimeException(e);
        }
    }
}

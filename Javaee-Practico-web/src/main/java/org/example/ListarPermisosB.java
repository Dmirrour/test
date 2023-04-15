package org.example;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.PNCirculacion;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListarpermisosB", value = "/listar-permisosB")
public class ListarPermisosB extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    PNCRemote permisoR;
    public ListarPermisosB() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PNCirculacion> permisC = permisoR.listadoPermisosC();
        request.setAttribute("permiso", permisC);
        RequestDispatcher rd;

        rd = request.getRequestDispatcher("/borrar.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

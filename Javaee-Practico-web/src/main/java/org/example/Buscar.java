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

@WebServlet(name = "Buscar", value = "/buscar-permisosC")
public class Buscar extends HttpServlet {
    @EJB
    PNCRemote permisoR;
    public Buscar() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Antes de entrad \n");
        /*if(request.getParameter("todoOK")==null){
            System.out.println("Primera entrad \n");
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/buscar.jsp");
            rd.forward(request, response);
        }else{*/
            System.out.println("Segunda entrad \n");
            String tipo = request.getParameter("tipo");
            String buscar = request.getParameter("buscar");
            List<PNCirculacion> permisC = permisoR.buscarlista(tipo,buscar);
            request.setAttribute("permiso", permisC);
            request.setAttribute("muestrolistado", "ok");
            RequestDispatcher rd;
            System.out.println("setio ok\n");
            rd = request.getRequestDispatcher("/buscar.jsp");
            rd.forward(request, response);
        //}
    }
}

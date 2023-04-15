package org.example;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import org.example.beans.MySingletonRemote;
import org.example.exeption.PermisoRepetidoExcepcion;
import org.example.model.PNCirculacion;

import java.util.Date;
import java.util.List;

@Stateless
public class PNC implements PNCRemote{
    @EJB
    MySingletonRemote singleton;
    public PNC() {
        super();
    }
    @Override
    public void agregarPermisoC(int numero, Date pvalidez, String patente) throws PermisoRepetidoExcepcion {
        singleton.agregarPNC(numero, pvalidez, patente);
    }
    @Override
    public List<PNCirculacion> listadoPermisosC() {
        return singleton.getPermisos();
    }
    @Override
    public List<PNCirculacion> buscarlista(String tipo,String buscar){
        return singleton.buscarPermisosC(tipo,buscar);
    }
    @Override
    public boolean eliminarPermisoC(int idPNC) {
         return singleton.eliminarPNC(idPNC);
    }
}

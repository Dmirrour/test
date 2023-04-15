package org.example;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import org.example.exeption.PermisoRepetidoExcepcion;
import org.example.model.PNCirculacion;

import java.util.Date;
import java.util.List;

@Local
public interface PNCLocal {
    void agregarPermisoC(int numero, Date pvalidez, String patente) throws PermisoRepetidoExcepcion;
    List<PNCirculacion> listadoPermisosC();
    List<PNCirculacion> buscarlista(String tipo,String buscar);
    boolean eliminarPermisoC(int idPNC);
}

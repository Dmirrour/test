package org.example.beans;

import jakarta.ejb.Local;
import org.example.exeption.PermisoRepetidoExcepcion;
import org.example.model.PNCirculacion;

import java.util.Date;
import java.util.List;

@Local
public interface MySingletonLocal {
    void agregarPNC(int numero, Date pvalidez, String patente) throws PermisoRepetidoExcepcion;
    List<PNCirculacion> getPermisos();
    List<PNCirculacion> buscarPermisosC(String tipo,String buscar);
    boolean eliminarPNC(int idPND);
}

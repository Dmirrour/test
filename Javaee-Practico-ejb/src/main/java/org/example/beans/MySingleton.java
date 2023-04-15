package org.example.beans;

import jakarta.ejb.Singleton;
import org.example.exeption.PermisoRepetidoExcepcion;
import org.example.model.PNCirculacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;

@Singleton
public class MySingleton implements MySingletonLocal, MySingletonRemote{
    List<PNCirculacion> permisosC = new ArrayList<>();

    public MySingleton(){}

    public void agregarPNC(int numero, Date pvalidez, String patente) throws PermisoRepetidoExcepcion {
        boolean existePersona = permisosC.stream().anyMatch(permisosC -> permisosC.getNumero()==numero);

        if (existePersona) {
            throw new PermisoRepetidoExcepcion("El permiso con el numero: "+ numero +" ya existe en el Sistema");
        } else {
            System.out.println("No se encontró ninguna persona con el DNI 12345678");Date a= new Date();
            PNCirculacion PNC = new PNCirculacion(numero,pvalidez,patente);
            permisosC.add(PNC);
        }

        /*for (PNCirculacion permiso : permisosC){
            String cadena = String.valueOf(permiso.getNumero());
            System.out.println("ID de periso: "+ cadena+"\n");
            System.out.println("Patente: "+permiso.getPatente()+"\n");
            System.out.println(permiso.getPvalidez());
            System.out.println("\n");
        }*/
    }

    public List<PNCirculacion> getPermisos() {
        return permisosC;
    }

    public List<PNCirculacion> buscarPermisosC(String tipo,String buscar){
        System.out.println("resivo"+buscar+"\n");
        System.out.println("a"+tipo+"\n");
        switch (tipo){
            case "ID":
                int numero= Integer.parseInt(buscar);
                return permisosC.stream().filter(permisosC -> permisosC.getNumero() == numero).collect(Collectors.toList());
            case "Patente":
                return permisosC.stream().filter(permisosC -> permisosC.getPatente().equals(buscar)).collect(Collectors.toList());
            case "Fecha":
                System.out.println("resivo"+buscar+"\n");
                for(PNCirculacion p : permisosC){
                    System.out.println(p.getPvalidez());
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    Date fechav = formatter.parse(buscar);
                    String fechaBuscada = formatter.format(fechav);

                    System.out.println("tranfo"+fechav+"\n");
                    return permisosC.stream().filter(permisosC -> permisosC.getPvalidez().toString().equals(fechav.toString())).collect(Collectors.toList());
                    //return permisosC.stream().filter(permisosC -> permisosC.getPvalidez().contains(fechav)).collect(Collectors.toList());

                }catch (Exception e){
                    throw new RuntimeException(e);
                }

            default:
                throw new RuntimeException();
        }
    }

    @Override
    public boolean eliminarPNC(int idPND){
        Optional<PNCirculacion> optionalEmpresa = permisosC.stream().filter(item -> item.getNumero() == idPND).findFirst();
        if(optionalEmpresa.isEmpty())
            return false;
        permisosC.remove(optionalEmpresa.get());
        return true;
    }
}

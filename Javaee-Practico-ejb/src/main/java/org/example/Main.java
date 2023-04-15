package org.example;

import org.example.beans.MySingletonRemote;
import org.wildfly.naming.client.WildFlyInitialContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;
import java.util.Properties;
public class Main {
    public static void main(String[] args) throws NamingException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
        Context ctx = new InitialContext(props);
        //InitialContext ctx = new WildFlyInitialContext();
        String jdniName = "ejb:Javaee-Practico/Javaee-Practico-ejb/Empr!org.example.EmprRemote";

        PNCRemote permisosCBean = (PNCRemote) ctx.lookup(jdniName);
        Date a=new Date();
       /*permisosCBean.agregarPermisoC(2018, a, "LSA2018");
        permisosCBean.agregarPermisoC(2017, a, "LSA2017");
        permisosCBean.agregarPermisoC(2013, a, "LSA2013");
        permisosCBean.agregarPermisoC(2019, a, "LSA2019");*/

        /*permisosCBean.listadoPermisosC().forEach(permiso -> {
            String cadena = String.valueOf(permiso.getNumero());
            System.out.println("ID de periso: "+ cadena+"\n");
            System.out.println("Patente: "+permiso.getPatente()+"\n");
            System.out.println(permiso.getPvalidez());
            System.out.println("\n");
        });*/
    }
}

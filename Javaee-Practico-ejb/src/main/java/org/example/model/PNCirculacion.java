package org.example.model;

import java.io.Serializable;
import java.util.Date;

public class PNCirculacion implements Serializable {
    private int numero;
    private Date pvalidez;
    private String patente;


    public PNCirculacion() {
        super();
    }
    public PNCirculacion(int numero, Date pvalidez, String patente) {
        super();
        this.numero =numero;
        this.pvalidez = pvalidez;
        this.patente = patente;
    }

    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public Date getPvalidez() {
        return pvalidez;
    }


    public void setPvalidez(Date pvalidez) {
        this.pvalidez = pvalidez;
    }


    public String getPatente() {
        return patente;
    }


    public void setPatente(String patente) {
        this.patente = patente;
    }
}

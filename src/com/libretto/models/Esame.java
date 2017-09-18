package com.libretto.models;


import java.time.LocalDate;

/**
 * Oggetto Semplice che contiene i dati relativi ad un singolo esame
 */

public class Esame {

    private String codice;
    private String titolo;
    private String docente;
    // private Docente docente ;

    private boolean superato ;
    private int voto ;
    private LocalDate dataSuperamento ;

    public Esame(String codice, String titolo, String docente) {
        this.codice = codice;
        this.titolo = titolo;
        this.docente = docente;
    }
}

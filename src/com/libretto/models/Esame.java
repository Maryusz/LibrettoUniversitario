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

    /**
     * Costruttore dell'oggetto Esame, non ancora superato
     *
     * @param codice  codice esame
     * @param titolo  denominazione corso
     * @param docente cognome e nome del docente titolare
     */
    public Esame(String codice, String titolo, String docente) {
        this.codice = codice;
        this.titolo = titolo;
        this.docente = docente;

        this.superato = false;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public boolean isSuperato() {
        return superato;
    }

    public void setSuperato(boolean superato) {
        this.superato = superato;
    }

    /**
     * Restituisce il voto solo se l'esame è stato superato.
     *
     * @return il voto
     */
    public int getVoto() {
        if (this.superato) {
            return voto;
        } else {
            throw new IllegalStateException("Esame " + this.codice + " non superato.");
        }

    }

    private void setVoto(int voto) {
        this.voto = voto;
    }

    public LocalDate getDataSuperamento() {
        if (this.superato) {
            return dataSuperamento;
        } else {
            throw new IllegalStateException("Esame " + this.codice + " non superato.");
        }
    }

    private void setDataSuperamento(LocalDate dataSuperamento) {
        this.dataSuperamento = dataSuperamento;
    }

    @Override
    public String toString() {
        return "Esame{" +
                "codice='" + codice + '\'' +
                ", titolo='" + titolo + '\'' +
                ", docente='" + docente + '\'' +
                ", superato=" + superato +
                ", voto=" + voto +
                ", dataSuperamento=" + dataSuperamento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Esame)) return false;

        Esame esame = (Esame) o;

        return getCodice().equals(esame.getCodice());
    }

    @Override
    public int hashCode() {
        return getCodice().hashCode();
    }

    /**
     * Se l'esame non è ancora superato, lo considera superato con il voto e la data specificati
     * Se invece l'esame era già superato, genera un'eccezione.
     *
     * @param voto
     * @param data
     */
    public void supera(int voto, LocalDate data) {
        if (!this.superato) {
            this.superato = true;
            this.voto = voto;
            this.dataSuperamento = data;
        } else {
            throw new IllegalStateException("Esame " + this.codice + " già superato.");
        }
    }
}

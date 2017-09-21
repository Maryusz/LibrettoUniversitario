package com.libretto.models;


import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Esame> esami;

    public Model() {
        this.esami = new ArrayList<Esame>();
    }

    /**
     * Aggiunge un nuovo esame al modello verificando che non ci sia già
     *
     * @param e
     * @return true se viene inserito, false se esiste già nella lista e non può essere inserito
     */
    public boolean addEsame(Esame e) {
        if (!esami.contains(e)) {
            esami.add(e);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Restituisce l'esame contente il codice esame uguale e univoco
     *
     * @param codice codice esame ricercato.
     * @return se l'esame non viene trovato, il metodo restituisce null.
     */
    public Esame searchEsame(String codice) {
        int index = this.esami.indexOf(new Esame(codice, null, null));
        if (index == -1) {
            return null;
        } else {
            return this.esami.get(index);
        }
    }

}

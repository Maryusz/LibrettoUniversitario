package com.libretto.models;


import com.libretto.models.db.EsameDAO;

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
        EsameDAO dao = new EsameDAO();

        return dao.create(e);
    }

    /**
     * Restituisce l'esame contente il codice esame uguale e univoco
     *
     * @param codice codice esame ricercato.
     * @return se l'esame non viene trovato, il metodo restituisce null.
     */
    public Esame searchEsame(String codice) {
        EsameDAO dao = new EsameDAO();
        Esame e = dao.find(codice);
        return e;
    }

}

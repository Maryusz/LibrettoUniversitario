package com.libretto.models.db;

import com.libretto.models.Esame;

public class TestEsameDAO {
    public static void main(String[] args) {
        EsameDAO dao = new EsameDAO();

        Esame e1 = dao.find("03FYZ");
        System.out.println(e1);

        Esame e2 = dao.find("31231");
        System.out.println(e2);
    }
}

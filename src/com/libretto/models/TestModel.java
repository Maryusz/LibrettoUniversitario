package com.libretto.models;

public class TestModel {
    public static void main(String[] args) {
        Model m = new Model();

        System.out.println(m.addEsame(new Esame("03FYZ", "Tecniche di Programmazione", "Fulvio Corno")));
        System.out.println(m.addEsame(new Esame("03F3Z", "CRTK", "Alberto Sordi")));
        System.out.println(m.addEsame(new Esame("0333Z", "Tecniche di Programmazione", "Fulvio Corno")));
        System.out.println(m.addEsame(new Esame("0333Z", "Tecniche di Programmazione", "Fulvio Corno")));

        System.out.println(m.searchEsame("0333Z"));
        System.out.println(m.searchEsame("033Z"));
        System.out.println(m.searchEsame("033Z"));
    }
}

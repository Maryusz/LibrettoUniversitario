package com.libretto.models.db;

import com.libretto.models.Esame;

import java.sql.*;

public class EsameDAO {
    // Classe che farà solo le query

    public Esame find(String codice) {
        String sql = "SELECT codice, titolo, docente,superato,voto,data_superamento " +
                "FROM esame " +
                "WHERE codice= ? ";

        Esame esame = null;

        String jdbcURL = "jdbc:mysql://localhost/libretto?user=root&password=Mariusz";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL);

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, codice);

            ResultSet result = st.executeQuery();

            if (result.next()) {
                Esame esameTmp = new Esame(
                        result.getString("codice"),
                        result.getString("titolo"),
                        result.getString("docente")
                );

                esame = esameTmp;

            } else {
                esame = null;
            }
            connection.close();
            return esame;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean create(Esame e) {
        String sql = "INSERT INTO `libretto`.`esame` (`codice`, `titolo`, `docente`) VALUES (?, ?, ?);";
        String jdbcURL = "jdbc:mysql://localhost/libretto?user=root&password=Mariusz";


        try {
            Connection connection = DriverManager.getConnection(jdbcURL);
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, e.getCodice());
            st.setString(2, e.getTitolo());
            st.setString(3, e.getDocente());

            int result = st.executeUpdate();
            connection.close();

            if (result == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }


    }
}

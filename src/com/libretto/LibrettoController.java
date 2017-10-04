/**
 * Sample Skeleton for 'Libretto.fxml' Controller Class
 */

package com.libretto;

import com.libretto.models.Esame;
import com.libretto.models.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LibrettoController {

    Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessage"
    private TextArea txtMessage; // Value injected by FXMLLoader

    @FXML
    void handleCerca(ActionEvent event) {
        //Recupera i dati dall'interfaccia
        String codice = txtCodice.getText();

        if (codice.length() < 5) {
            txtMessage.appendText("Codice ricercato troppo corto.\n");
            return;
        }

        Esame e = model.searchEsame(codice);
        if (e == null) {
            txtMessage.appendText("Esame non trovato.\n");
            return;
        } else {
            txtCodice.setText(e.getCodice());
            txtTitolo.setText(e.getTitolo());
            txtDocente.setText(e.getDocente());
        }

    }

    @FXML
    void handleInserisci(ActionEvent event) {
        //Recupera i dati dall'interfaccia
        String codice = txtCodice.getText();
        String titolo = txtTitolo.getText();
        String docente = txtDocente.getText();

        // Verifica la validità dei dati
        if (codice.length() < 5 || titolo.length() == 0 || docente.length() == 0) {
            txtMessage.appendText("Dati non validi\n");
            return;
        }

        // Chiede al model di effettuare l'operazione

        Esame e = new Esame(codice, titolo, docente);
        boolean result = model.addEsame(e);

        // Aggiorna la vista

        if (result) {
            txtMessage.appendText("Esame aggiunto con successo\n");
        } else {
            txtMessage.appendText("Esame non aggiunto - Esame già presente\n");
        }

    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Libretto.fxml'.";

    }


    public void setModel(Model model) {
        this.model = model;
    }
}

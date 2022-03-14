package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco = new Parole();

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtParola;
    @FXML
    private Button btnInserisci;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnCancella;
    @FXML
    private TextArea txtTime;
    
    @FXML
    void doInsert(ActionEvent event) {
    	
    	String parola = txtParola.getText();
    	
    	if(parola == "")
    		return;
    	
    	this.elenco.addParola(parola);
   
    	this.stampaLista();
    	
    	txtTime.appendText("Aggiunta *" + parola + "*: " + System.nanoTime() + "\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	this.elenco.reset();
    	this.txtResult.clear();
    	this.txtParola.clear();
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	String daTogliere = this.txtResult.getSelectedText();
    	
    	elenco.togliParola(daTogliere);
    	
    	this.stampaLista();
    }
    
    void stampaLista()
    {
    	List<String> lista = elenco.getElenco();
    	
    	String ret = "";
    	
    	for(String x: lista)
    	{
    		if(ret != "")
    		{
    			ret = ret + "\n";
    		}
    		
    		ret = ret + x;	
    	}
    	
    	this.txtResult.clear();
    	this.txtParola.clear();
    	this.txtResult.setText(ret);
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}

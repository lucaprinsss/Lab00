/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.esercitazione_1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private int tRimasti=3;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="button"
    private Button button; // Value injected by FXMLLoader

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtPassword"
    private TextField txtPassword; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtTentativi"
    private Label txtTentativi; // Value injected by FXMLLoader
    
    @FXML
    void doLogin(ActionEvent event) {
     
    	if(tRimasti==3) {
    		String nome=txtNome.getText();
    		String password=txtPassword.getText();
    		//txtNome.setText("");
    		txtPassword.setText("");
    	
    		if(nome.compareTo("")==0 || password.compareTo("")==0) {
    			txtNome.setText("");
    			return;
    			}
    		if(nome.compareTo("")!=0 && 
    				password.compareTo("")!=0 && 
    				(password.length()>=7) && 
    				password.matches("[a-zA-Z0-9?!@#]*") && 
    				!password.matches("[a-z0-9?!@#]*") && 
    				!password.matches("[a-z0-9]*") && 
    				!password.matches("[a-z]*") &&
    				!password.matches("[A-Z0-9?!@#]*") && 
    				!password.matches("[A-Z0-9]*") &&
    				!password.matches("[A-Z]*") &&
    				!password.matches("[0-9a-zA-Z]*") &&
    				!password.matches("[0-9a-z]*") &&
    				!password.matches("[0-9]*") &&
    				!password.matches("[?!@#a-zA-Z]*") &&
    				!password.matches("[?!@#a-z]*") &&
    				!password.matches("[?!@#]*")) {
    			label.setText("ACCESSO ESEGUITO");
    			txtNome.setText("");
    		} else {
    			label.setText("ACCESSO NEGATO");
    			txtNome.setDisable(true);
    			tRimasti--;
    			txtTentativi.setText("Tentativi rimasti: "+tRimasti);
    		}
    	} else {
    		String nome=txtNome.getText();
    		String password=txtPassword.getText();
    		//txtNome.setText("");
    		txtPassword.setText("");
    	
    		if(password.compareTo("")==0)
    			return;
    		if(nome.compareTo("")!=0 && 
    				password.compareTo("")!=0 && 
    				(password.length()>=7) && 
    				password.matches("[a-zA-Z0-9?!@#]*") && 
    				!password.matches("[a-z0-9?!@#]*") && 
    				!password.matches("[a-z0-9]*") && 
    				!password.matches("[a-z]*") &&
    				!password.matches("[A-Z0-9?!@#]*") && 
    				!password.matches("[A-Z0-9]*") &&
    				!password.matches("[A-Z]*") &&
    				!password.matches("[0-9a-zA-Z]*") &&
    				!password.matches("[0-9a-z]*") &&
    				!password.matches("[0-9]*") &&
    				!password.matches("[?!@#a-zA-Z]*") &&
    				!password.matches("[?!@#a-z]*") &&
    				!password.matches("[?!@#]*") ) {
    			label.setText("ACCESSO ESEGUITO");
    			tRimasti=3;
    			txtNome.setDisable(false);
    			txtTentativi.setText("");
    			txtNome.setText("");
    		} else {
    			label.setText("ACCESSO NEGATO");
    			tRimasti--;
    			txtTentativi.setText("Tentativi rimasti: "+tRimasti);
    			if(tRimasti==0) {
    				txtPassword.setDisable(true);
    				button.setDisable(true);
    			}
    		}
    	}
    }
    
    @FXML
    void doClear(ActionEvent event) {
    	tRimasti=3;
    	txtNome.setText("");
    	txtNome.setDisable(false);
    	txtPassword.setDisable(false);
    	button.setDisable(false);
    	txtTentativi.setText("");
    	label.setText("");
    }    	

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'Scene.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
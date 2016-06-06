/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.reservation.system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static ticket.reservation.system.Client.outToServer;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLSignUpController implements Initializable {

    @FXML
    private Label user_name;
    @FXML
    private Label mail_id;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField mailField;
    @FXML
    private Label phone_no;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField credit_cardField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button submit_btn;
    @FXML
    private Label credit_card;
    @FXML
    private Label password;

    private String nme, mail,phn,credit,pass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submit_btn_clicked(ActionEvent event) {
        try {
            outToServer.writeBytes("signup"+'\n');
            nme = usernameField.getText();
            mail = mailField.getText();
            phn = phoneField.getText();
            credit = credit_cardField.getText();
            pass = passwordField.getText();
            outToServer.writeBytes(nme+'\n');
            outToServer.writeBytes(mail+'\n');
            outToServer.writeBytes(phn+'\n');
            outToServer.writeBytes(credit+'\n');
            outToServer.writeBytes(pass+'\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLthanks.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage=new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
}

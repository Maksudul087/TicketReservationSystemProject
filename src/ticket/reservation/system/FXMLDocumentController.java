/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.reservation.system;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static ticket.reservation.system.Client.inFromServer;
import static ticket.reservation.system.Client.outToServer;

/**
 *
 * @author ASUS
 */
public class FXMLDocumentController implements Initializable {
    private String nme;
    private String  pass;
    
    
    private Label label;
    @FXML
    private Button sign_up_btn;
    @FXML
    private Label sign_up_lebel;
    @FXML
    private Button sign_in_btn;
    @FXML
    private Label username_lebel;
    @FXML
    private Label password_lebel;
    @FXML
    private TextField username_field;
    @FXML
    private PasswordField password_field;
    private Label invalid_signin;
    @FXML
    private Label invalid_sign_in;
    
    @FXML
    private void sign_in_btn_clicked(ActionEvent event) throws IOException {
        System.out.println("ok");
        nme = username_field.getText();
        pass = password_field.getText();
       // if(!nme.equals(validName) || !pass.equals(validPass)){
        //invalid_sign_in.setText("Invalid username or password!");
       // }
        //else{
        outToServer.writeBytes("login"+'\n');
        outToServer.writeBytes(nme + '\n');
        outToServer.writeBytes(pass + '\n');
        if(inFromServer.readLine().equals("ok")){
            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = FXMLLoader.load(getClass().getResource("FXMLAfterLogIn.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            invalid_sign_in.setText("Invalid username or password!");
        
       // String nme,pass;
       // String modifiedSentence;
       // BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
       // Socket clientSocket = new Socket("localhost", 6789);
       // DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        //BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //while(true)
        //{
            //sentence = inFromUser.readLine();

            //modifiedSentence = inFromServer.readLine();
           // System.out.println("From Server : "+modifiedSentence);
        //}

        
       // }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void sign_up_btn_clicked(ActionEvent event) throws IOException{
       // TicketReservationSystem.showSignUpPage();
   
       //Parent root;

        Pane root = FXMLLoader.load(getClass().getResource("FXMLSignUp.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
   // public String getName(){
    //    return nme;
    //}
    
}

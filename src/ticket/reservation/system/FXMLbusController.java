/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.reservation.system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static java.lang.Thread.sleep;
import static ticket.reservation.system.Client.inFromServer;
import static ticket.reservation.system.Client.outToServer;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLbusController implements Initializable {
    private String s;
    @FXML
    private Label msg1;
    @FXML
    private Label msg2;

    @FXML
    private CheckBox b_s5;
    @FXML
    private CheckBox b_s7;
    @FXML
    private CheckBox b_s9;
    @FXML
    private CheckBox b_s1;
    @FXML
    private CheckBox b_s3;
    @FXML
    private CheckBox b_s2;
    @FXML
    private CheckBox b_s4;
    @FXML
    private CheckBox b_s11;
    @FXML
    private CheckBox b_s12;
    @FXML
    private Button b_s_nxt;
    @FXML
    private CheckBox b_s6;
    @FXML
    private CheckBox b_s8;
    @FXML
    private CheckBox b_s10;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void b_s7_clk(ActionEvent event) {
        s="7";
    }

    @FXML
    private void b_s5_clk(ActionEvent event) {
        s="5";
    }

    @FXML
    private void b_s9_clk(ActionEvent event) {
        s="9";
    }

    @FXML
    private void b_s1_clk(ActionEvent event) {
        s="1";
    }

    @FXML
    private void b_s3_clk(ActionEvent event) {
        s="3";
    }

    @FXML
    private void b_s2_clk(ActionEvent event) {
        s="2";
    }

    @FXML
    private void b_s4_clk(ActionEvent event) {
        s="4";
    }

    @FXML
    private void b_s11_clk(ActionEvent event) {
        s="11";
    }

    @FXML
    private void b_s12_clk(ActionEvent event) {
        s="12";
    }

    @FXML
    private void b_s_nxt_clk(ActionEvent event) throws IOException {

        outToServer.writeBytes(s+'\n');
        String msg;
        msg = inFromServer.readLine();
        System.out.println(msg);
        if(msg.equals("ok")){
            Pane root = FXMLLoader.load(getClass().getResource("FXMLconfirmation.fxml"));
            Stage stage=new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        else
        {
            msg1.setText("NOT AVAILABLE!");
            msg2.setText("PLEASE TRY ANOTHER!");
        }

    }

    @FXML
    private void b_s6_clk(ActionEvent event) {
       s="6";
    }

    @FXML
    private void b_s8_clk(ActionEvent event) {
        s="8";
    }

    @FXML
    private void b_s10_clk(ActionEvent event) {
        s="10";
    }
    
}

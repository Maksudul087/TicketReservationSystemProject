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
public class FXMLtrainController implements Initializable {
    private String s;
    @FXML
    private Label msg1;
    @FXML
    private Label msg2;
    @FXML
    private CheckBox t_s1;
    @FXML
    private CheckBox t_s2;
    @FXML
    private CheckBox t_s5;
    @FXML
    private CheckBox t_s6;
    @FXML
    private CheckBox t_s9;
    @FXML
    private CheckBox t_s10;
    @FXML
    private CheckBox t_s13;
    @FXML
    private CheckBox t_s14;
    @FXML
    private CheckBox t_s17;
    @FXML
    private CheckBox t_s18;
    @FXML
    private CheckBox t_s3;
    @FXML
    private CheckBox t_s4;
    @FXML
    private CheckBox t_s7;
    @FXML
    private CheckBox t_s8;
    @FXML
    private CheckBox t_s11;
    @FXML
    private CheckBox t_s12;
    @FXML
    private CheckBox t_s15;
    @FXML
    private CheckBox t_s16;
    @FXML
    private CheckBox t_s19;
    @FXML
    private CheckBox t_s20;
    @FXML
    private CheckBox t_s21;
    @FXML
    private CheckBox t_s22;
    @FXML
    private CheckBox t_s23;
    @FXML
    private CheckBox t_s24;
    @FXML
    private Button t_s_nxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void t_s1_clk(ActionEvent event) {
        s="1";
    }

    @FXML
    private void t_s2_clk(ActionEvent event) {
        s="2";
    }

    @FXML
    private void t_s5_clk(ActionEvent event) {
        s="5";
    }

    @FXML
    private void t_s6_clk(ActionEvent event) {
        s="6";
    }

    @FXML
    private void t_s9_clk(ActionEvent event) {
        s="9";
    }

    @FXML
    private void t_s10_clk(ActionEvent event) {
        s="10";
    }

    @FXML
    private void t_s13_clk(ActionEvent event) {
        s="13";
    }

    @FXML
    private void t_s14_clk(ActionEvent event) {
        s="14";
    }

    @FXML
    private void t_s17_clk(ActionEvent event) {
        s="17";
    }

    @FXML
    private void t_s18_clk(ActionEvent event) {
        s="18";
    }

    @FXML
    private void t_s3_clk(ActionEvent event) {
        s="3";
    }

    @FXML
    private void t_s4_clk(ActionEvent event) {
        s="4";
    }

    @FXML
    private void t_s7_clk(ActionEvent event) {
        s="7";
    }

    @FXML
    private void t_s8_clk(ActionEvent event) {
        s="8";
    }

    @FXML
    private void t_s11_clk(ActionEvent event) {
        s="11";
    }

    @FXML
    private void t_s12_clk(ActionEvent event) {
        s="12";
    }

    @FXML
    private void t_s15_clk(ActionEvent event) {
        s="15";
    }

    @FXML
    private void t_s16_clk(ActionEvent event) {
        s="16";
    }

    @FXML
    private void t_s19_clk(ActionEvent event) {
        s="19";
    }

    @FXML
    private void t_s20_clk(ActionEvent event) {
        s="20";
    }

    @FXML
    private void t_s21_clk(ActionEvent event) {
        s="21";
    }

    @FXML
    private void t_s22_clk(ActionEvent event) {
        s="22";
    }

    @FXML
    private void t_s23_clk(ActionEvent event) {
        s="23";
    }

    @FXML
    private void t_s24_clk(ActionEvent event) {
        s="24";
    }

    @FXML
    private void t_s_nxt_clk(ActionEvent event) throws IOException {
        String msg;
        outToServer.writeBytes(s+'\n');
        msg = inFromServer.readLine();
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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.reservation.system;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.io.DataOutputStream;
import java.io.IOException;
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
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLAfterLogInController extends FXMLDocumentController {
    private String busName,busRoot,busTime,busDay;
    private String trainRoot,trainDate;
    private String movieTime, movieDate;
    
    @FXML
    private CheckBox b_p;
    @FXML
    private CheckBox b_sr;
    @FXML
    private CheckBox r_p2d;
    @FXML
    private CheckBox r_d2p;
    @FXML
    private CheckBox b_s;
    @FXML
    private CheckBox r_p2c;
    @FXML
    private CheckBox r_c2p;
    @FXML
    private CheckBox d1;
    @FXML
    private CheckBox d2;
    @FXML
    private CheckBox d3;
    @FXML
    private CheckBox t9;
    @FXML
    private CheckBox t3;
    @FXML
    private CheckBox t6;
    @FXML
    private Button b_nxt;
    @FXML
    private CheckBox tr_d1;
    @FXML
    private CheckBox tr_i2d;
    @FXML
    private CheckBox tr_c2i;
    @FXML
    private CheckBox tr_i2c;
    @FXML
    private CheckBox tr_d2i;
    @FXML
    private Button tr_nxt;
    @FXML
    private CheckBox tr_d3;
    @FXML
    private CheckBox tr_d2;
    @FXML
    private CheckBox m_t12;
    @FXML
    private CheckBox m_t3;
    @FXML
    private CheckBox m_d1;
    @FXML
    private CheckBox m_d2;
    @FXML
    private Button m_nxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void b_p_clk(ActionEvent event) {
        busName = "Pabna Express";

    }

    @FXML
    private void b_sr_clk(ActionEvent event) {
        busName = "Sarker Travels";
    }

    @FXML
    private void r_p2d_clk(ActionEvent event) {
        busRoot = "p2d";

    }

    @FXML
    private void r_d2p_clk(ActionEvent event) {
        busRoot = "d2p";
    }

    @FXML
    private void b_s_clk(ActionEvent event) {
        busName = "Shyamoli Paribahan";
    }

    @FXML
    private void r_p2c_clk(ActionEvent event) {
        busRoot = "p2c";
    }

    @FXML
    private void r_c2p_clk(ActionEvent event) {
        busRoot = "c2p";
    }

    @FXML
    private void d1_clk(ActionEvent event) {
        busDay = "d1";
    }

    @FXML
    private void d2_clk(ActionEvent event) {
        busDay = "d2";
    }

    @FXML
    private void d3_clk(ActionEvent event) {
        busDay = "d3";
    }

    @FXML
    private void t9_clk(ActionEvent event) {
        busTime = "t1";

    }

    @FXML
    private void t3_clk(ActionEvent event) {
        busTime = "t3";
    }

    @FXML
    private void t6_clk(ActionEvent event) {
        busTime = "t2";
    }

    @FXML
    private void b_nxt_clk(ActionEvent event) {
        
        
        Pane root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLbus.fxml"));
        
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        //while(true)
        //{
            //sentence = inFromUser.readLine();
            System.out.println("Writing....");
            
            Client.outToServer.writeBytes("bus" + '\n');
           System.out.println(busName+busDay+busRoot+busTime);
            Client.outToServer.writeBytes(busName + '\n');
            Client.outToServer.writeBytes(busRoot + '\n');
            Client.outToServer.writeBytes(busDay + '\n');
           Client.outToServer.writeBytes(busTime + '\n');
     } catch (Exception ex) {
            printStackTrace();
        }
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void tr_d1_clk(ActionEvent event) {
        trainDate = "d1";
    }

    @FXML
    private void tr_i2d_clk(ActionEvent event) {
        trainRoot = "i2d";
    }

    @FXML
    private void tr_c2i_clk(ActionEvent event) {
        trainRoot = "c2i";
    }

    @FXML
    private void tr_i2c_clk(ActionEvent event) {
        trainRoot = "i2c";
    }

    @FXML
    private void tr_d2i_clk(ActionEvent event) {
        trainRoot = "d2i";
    }

    @FXML
    private void tr_nxt_clk(ActionEvent event) throws IOException {
           Pane root = FXMLLoader.load(getClass().getResource("FXMLtrain.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

        Client.outToServer.writeBytes("train" + '\n');
        Client.outToServer.writeBytes(trainRoot + '\n');
        Client.outToServer.writeBytes(trainDate + '\n');
        //Client.outToServer.writeBytes(busDay + '\n');
        //Client.outToServer.writeBytes(busTime + '\n');
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void tr_d3_clk(ActionEvent event) {
        trainDate = "d3";
    }

    @FXML
    private void tr_d2_clk(ActionEvent event) {
        trainDate = "d2";
    }

    @FXML
    private void m_t12_clk(ActionEvent event) {
        movieTime ="t1";
    }

    @FXML
    private void m_t3_clk(ActionEvent event) {
        movieTime ="t2";
    }

    @FXML
    private void m_d1_clk(ActionEvent event) {
         movieDate ="d1";
    }

    @FXML
    private void m_d2_clk(ActionEvent event) {
        movieDate ="d2";
    }

    @FXML
    private void m_nxt_clk(ActionEvent event) throws IOException {
            Pane root = FXMLLoader.load(getClass().getResource("FXMLtheater.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        Client.outToServer.writeBytes("movie" + '\n');
        //System.out.println(busName+busDay+busRoot+busTime);
        //Client.outToServer.writeBytes(busName + '\n');
        //Client.outToServer.writeBytes(busRoot + '\n');
        Client.outToServer.writeBytes(movieDate + '\n');
        Client.outToServer.writeBytes(movieTime + '\n');
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
    }
    
}

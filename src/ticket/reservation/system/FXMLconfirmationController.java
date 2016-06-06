/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.reservation.system;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class FXMLconfirmationController implements Initializable {
    @FXML
    private Button info_btn;
    @FXML
    private Button clse_btn;
    @FXML
    private PasswordField cnfrn_crdt_id;
    @FXML
    private Button cnfrm_cnfrm_btn;
    @FXML
    private Label cnfrm_msg;
    @FXML
    private Label tnx;
    private String credit,cnfrm_srvr;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cnfrm_cnfirm_btn_clk(ActionEvent event) throws InterruptedException {
        credit=cnfrn_crdt_id.getText();

        try {
            outToServer.writeBytes(credit+'\n');
            cnfrm_srvr = inFromServer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

            System.out.println(cnfrm_srvr);
            if(cnfrm_srvr.equals("ok")){
                cnfrm_msg.setText("A ticket has been reserved!");
                tnx.setText("THANK U!");

                }
            else{
                cnfrm_msg.setText("Invalid credit id!");
            }

    }
    @FXML
    private void info_btn_clk(ActionEvent event){
        try {
            outToServer.writeBytes("ok"+'\n');
            String p;
            String q;
            p=inFromServer.readLine();
           FileWriter fwriter = new FileWriter("C:\\Users\\ASUS\\Desktop\\"+p+".txt",true);
            PrintWriter appfile = new PrintWriter(fwriter);

            while(!p.equals("end")){
                appfile.println(p);
                p=inFromServer.readLine();
                System.out.println(p);
            }
            appfile.close();

            Pane root = FXMLLoader.load(getClass().getResource("FXMLprofile.fxml"));
            Stage stage=new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void clse_btn_clk(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}

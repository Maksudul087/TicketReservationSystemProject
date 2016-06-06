/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.reservation.system;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class Server {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           System.out.println("server has successfully run!");
        // int workerThreadCount = 0;
        int id = 1;
        ServerSocket welcomeSocket;
        try {
            welcomeSocket = new ServerSocket(6789);
        
        while(true)
        {
        Socket connectionSocket = welcomeSocket.accept();
        WorkerThread wt = new WorkerThread(connectionSocket, id);
        Thread t = new Thread(wt);
        t.start();
        }
        
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

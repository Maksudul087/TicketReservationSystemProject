/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.reservation.system;

import com.sun.xml.internal.fastinfoset.tools.TransformInputOutput;

import java.io.*;
import java.net.Socket;
import java.sql.Struct;

/**
 *
 * @author ASUS
*/
class WorkerThread implements Runnable {

        static Socket connectionSocket=null;
        private final int id;

        public WorkerThread(Socket ConnectionSocket, int id) {
            this.connectionSocket = ConnectionSocket;
            this.id = id;
        }
        @Override
        public void run() {
            String key1, key2,key3;
            String vnme;
            String vpass;
            String nme,pass;
            String S;
            String bus_name, bus_root, bus_date, bus_time,bus_seat;
            String train_root, train_date,train_seat;
            String movie_date, movie_time,movie_seat;
            String vcredit,vmail,vphne;
            String credit;
            String nnme,nmail,nphone,ncredit,npass;

           // while(true)
            //{
            try {
                DataOutputStream outToServer = new DataOutputStream(connectionSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

                key1 = inFromServer.readLine();
                System.out.println(key1);
                if(key1.equals("login")){
                    nme = inFromServer.readLine();
                    pass = inFromServer.readLine();
                    FileReader file = new FileReader("C:\\Users\\ASUS\\Desktop\\Ticket Reservation System\\"+nme+".txt");
                    BufferedReader read = new BufferedReader(file);
                    vnme = read.readLine();
                    vpass = read.readLine();
                    vmail= read.readLine();
                    vphne = read.readLine();
                    vcredit = read.readLine();
                    read.close();
                    System.out.println(vnme+vpass);
                    if(nme.equals(vnme) && pass.equals(vpass)){
                        outToServer.writeBytes("ok"+'\n');
                        S = inFromServer.readLine();
                        if(S.equals("bus")){
                            bus_name = inFromServer.readLine();
                            bus_root = inFromServer.readLine();
                            bus_date = inFromServer.readLine();
                            bus_time = inFromServer.readLine();
                            bus_seat = inFromServer.readLine();

                            String q="";
                            if(bus_name.equals("Pabna Express") && bus_root.equals("p2d") && bus_date.equals("d1") && bus_time.equals("t1")){
                                q = "b1";
                            }
                            if(bus_name.equals("Pabna Express") && bus_root.equals("p2d") && bus_date.equals("d1") && bus_time.equals("t2")){
                                q = "b2";
                            }
                            if(bus_name.equals("Pabna Express") && bus_root.equals("p2d") && bus_date.equals("d2") && bus_time.equals("t1")){
                                q = "b3";
                            }
                            if(bus_name.equals("Pabna Express") && bus_root.equals("p2d") && bus_date.equals("d2") && bus_time.equals("t2")){
                                q = "b4";
                            }
                            if(bus_name.equals("Pabna Express") && bus_root.equals("d2p") && bus_date.equals("d1") && bus_time.equals("t1")){
                                q = "b5";
                            }
                            if(bus_name.equals("Pabna Express") && bus_root.equals("d2p") && bus_date.equals("d1") && bus_time.equals("t2")){
                                q = "b6";
                            }
                            if(bus_name.equals("Pabna Express") && bus_root.equals("d2p") && bus_date.equals("d2") &&bus_time.equals("t1")){
                                q = "b7";
                            }
                            if(bus_name.equals("Sarker Travels") && bus_root.equals("d2p") && bus_date.equals("d2") && bus_time.equals("t2")){
                                q = "b8";
                            }

                            if(bus_name.equals("Sarker Travels") && bus_root.equals("p2d") && bus_date.equals("d1") && bus_time.equals("t1")){
                                q = "b9";
                            }
                            if(bus_name.equals("Sarker Travels") && bus_root.equals("p2d") && bus_date.equals("d1") && bus_time.equals("t2")){
                                q = "b10";
                            }
                            if(bus_name.equals("Sarker Travels") && bus_root.equals("p2d") && bus_date.equals("d2") && bus_time.equals("t1")){
                                q = "b11";
                            }
                            if(bus_name.equals("Sarker Travels") && bus_root.equals("p2d") && bus_date.equals("d2") && bus_time.equals("t2")){
                                q = "b12";
                            }
                            if(bus_name.equals("Sarker Travels") && bus_root.equals("d2p") && bus_date.equals("d1") && bus_time.equals("t1")){
                                q = "b13";
                            }
                            if(bus_name.equals("Sarker Travels") && bus_root.equals("d2p") && bus_date.equals("d1") && bus_time.equals("t2")){
                                q = "b14";
                            }
                            if(bus_name.equals("Sarker Travels") && bus_root.equals("d2p") && bus_date.equals("d2") &&bus_time.equals("t1")){
                                q = "b15";
                            }
                            if(bus_name.equals("Sarker Travels") && bus_root.equals("d2p") && bus_date.equals("d2") && bus_time.equals("t2")){
                                q = "b16";
                            }

                            System.out.println(q);
                           FileReader bfile = new FileReader("C:\\Users\\ASUS\\Desktop\\Ticket Reservation System\\"+q+".txt");
                            BufferedReader bread = new BufferedReader(bfile);
                            String p;
                            int f =1;
                            p=bread.readLine();
                            while(p!=null){
                                if(p.equals(bus_seat)){
                                    f=0;
                                    break;
                                }
                                System.out.println(p+" "+bus_seat);
                                p=bread.readLine();
                            }
                            bread.close();
                            if(f==1){
                                outToServer.writeBytes("ok"+'\n');
                                System.out.println(nme + " " + pass + " " +S+" "+ bus_name + " " + bus_root + " " + bus_date + " " + bus_time + " " +bus_seat + " ");

                                FileWriter fwriter = new FileWriter(vnme+".txt",true);
                                PrintWriter appfile = new PrintWriter(fwriter);
                                appfile.println("                   BUS                 ");
                                appfile.println(bus_name);
                                appfile.println(bus_root);
                                appfile.println(bus_date);
                                appfile.println(bus_time);
                                appfile.println(bus_seat);
                                appfile.close();
                                FileWriter bwriter = new FileWriter(q+".txt",true);
                                PrintWriter appbfile = new PrintWriter(bwriter);
                                appbfile.println(bus_seat);
                                appbfile.close();
                            }
                            else
                                outToServer.writeBytes(" "+'\n');


                        }
                        if(S.equals("train")){
                            //bus_name = inFromServer.readLine();
                            train_root = inFromServer.readLine();
                            train_date = inFromServer.readLine();
                            //bus_time = inFromServer.readLine();
                            train_seat = inFromServer.readLine();
                            String q="";
                            if(train_root.equals("i2d") && train_date.equals("d1")){
                                q = "t1";
                            }
                            if(train_root.equals("i2d") && train_date.equals("d2")){
                                q = "t2";
                            }
                            if(train_root.equals("d2i") && train_date.equals("d1")){
                                q = "t3";
                            }
                            if(train_root.equals("d2i") && train_date.equals("d2")){
                                q = "t4";
                            }



                            System.out.println(q);
                            FileReader tfile = new FileReader("C:\\Users\\ASUS\\Desktop\\Ticket Reservation System\\"+q+".txt");
                            BufferedReader tread = new BufferedReader(tfile);
                            String p;
                            int f =1;
                            p=tread.readLine();
                            while(p!=null){
                                if(p.equals(train_seat)){
                                    f=0;
                                    break;
                                }
                                System.out.println(p+" "+train_seat);
                                p=tread.readLine();
                            }
                            tread.close();
                            if(f==1){
                                outToServer.writeBytes("ok"+'\n');
                                System.out.println(nme + " " + pass + " " +S+" "+ " " + train_root + " " + train_date + " " + " " + train_seat + " ");

                                FileWriter fwriter = new FileWriter(vnme+".txt",true);
                                PrintWriter appfile = new PrintWriter(fwriter);
                                appfile.println("                    TRAIN                  ");
                                appfile.println(train_root);
                                appfile.println(train_date);
                                appfile.println(train_seat);
                                appfile.close();
                                FileWriter twriter = new FileWriter(q+".txt",true);
                                PrintWriter apptfile = new PrintWriter(twriter);
                                apptfile.println(train_seat);
                                apptfile.close();
                            }
                            else
                                outToServer.writeBytes(" "+'\n');







                        }
                        if(S.equals("movie")){
                            //bus_name = inFromServer.readLine();
                            //train_root = inFromServer.readLine();
                            movie_date = inFromServer.readLine();
                            movie_time = inFromServer.readLine();
                            movie_seat = inFromServer.readLine();
                            System.out.println(nme + " " + pass + " " +S+" "+ " " + " " + movie_date + " " + " "+movie_time+" "+ movie_seat + " ");

                            String q="";
                            if(movie_date.equals("d1") && movie_time.equals("t1")){
                                q = "m1";
                            }
                            if(movie_date.equals("d1") && movie_time.equals("t2")){
                                q = "m2";
                            }
                            if(movie_date.equals("d2") && movie_time.equals("t1")){
                                q = "m3";
                            }
                            if(movie_date.equals("d2") && movie_time.equals("t2")){
                                q = "m4";
                            }



                            System.out.println(q);
                            FileReader mfile = new FileReader("C:\\Users\\ASUS\\Desktop\\Ticket Reservation System\\"+q+".txt");
                            BufferedReader mread = new BufferedReader(mfile);
                            String p;
                            int f =1;
                            p=mread.readLine();
                            while(p!=null){
                                if(p.equals(movie_seat)){
                                    f=0;
                                    break;
                                }
                                System.out.println(p+" "+movie_seat);
                                p=mread.readLine();
                            }
                            mread.close();
                            if(f==1){
                                outToServer.writeBytes("ok"+'\n');
                                System.out.println(nme + " " + pass + " " +S+" "+ " " + movie_date + " " + movie_time + " " + " " + movie_seat + " ");

                                FileWriter fwriter = new FileWriter(vnme+".txt",true);
                                PrintWriter appfile = new PrintWriter(fwriter);
                                appfile.println("                    MOVIE                  ");
                                appfile.println(movie_date);
                                appfile.println(movie_time);
                                appfile.println(movie_seat);
                                appfile.close();
                                FileWriter mwriter = new FileWriter(q+".txt",true);
                                PrintWriter appmfile = new PrintWriter(mwriter);
                                appmfile.println(movie_seat);
                                appmfile.close();
                            }
                            else
                                outToServer.writeBytes(" "+'\n');


                        }

                        credit = inFromServer.readLine();
                        if(credit.equals(vcredit)){
                            outToServer.writeBytes("ok"+'\n');
                        }
                        else
                            outToServer.writeBytes(" "+'\n');
                    }
                    else{
                        outToServer.writeBytes(" "+'\n');
                    }


                    key2 = inFromServer.readLine();
                    System.out.println(key2);
                    if(key2.equals("ok")){
                        String m;
                        FileReader pfile = new FileReader("C:\\Users\\ASUS\\Desktop\\Ticket Reservation System\\"+vnme+".txt");
                        BufferedReader pread = new BufferedReader(pfile);
                        m=pread.readLine();
                        while(m!=null){
                            System.out.println(m);
                            outToServer.writeBytes(m+'\n');
                            m=pread.readLine();
                        }
                        outToServer.writeBytes("end"+'\n');
                        pread.close();
                    }


                }

                if(key1.equals("signup")){
                    nnme = inFromServer.readLine();
                    nmail = inFromServer.readLine();
                    nphone= inFromServer.readLine();
                    ncredit = inFromServer.readLine();
                    npass = inFromServer.readLine();

                    PrintWriter nfile = new PrintWriter(nnme+".txt");
                    nfile.println(nnme);
                    nfile.println(npass);
                    nfile.println(nmail);
                    nfile.println(nphone);
                    nfile.println(ncredit);
                    nfile.close();

                }


            } catch (Exception e) {

            }
            //}
        }

    }

  package com.socket;

import com.ui.ChatFrame;
import java.io.*;
import java.net.*;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
public class SocketClient implements Runnable{
    
    public int port, k1p1,k1p2,k2p1,k2p2,k3p1,k3p2,k4p1,k4p2,k5p1,k5p2,k6p1,k6p2,k7p1,k7p2,k8p1,k8p2,k9p1,k9p2, resetsendiri,resetmusuh;
    public String serverAddr;
    public Socket socket;
    public ChatFrame ui;
    public ObjectInputStream In;
    public ObjectOutputStream Out;
    public History hist;
    
    public SocketClient(ChatFrame frame) throws IOException{
        ui = frame; this.serverAddr = ui.serverAddr; this.port = ui.port;
        socket = new Socket(InetAddress.getByName(serverAddr), port);
            
        Out = new ObjectOutputStream(socket.getOutputStream());
        Out.flush();
        In = new ObjectInputStream(socket.getInputStream());
        
        
    }

    @Override
    public void run() {
        boolean keepRunning = true;
        k1p1=0; k1p2=0;
        k2p1=0; k2p2=0;
        k3p1=0; k3p2=0;
        k4p1=0; k4p2=0;
        k5p1=0; k5p2=0;
        k6p1=0; k6p2=0;
        k7p1=0; k7p2=0;
        k8p1=0; k8p2=0;
        k9p1=0; k9p2=0;
        resetsendiri=0;
        resetmusuh=0;
        
        while(keepRunning){
            try {
                Message msg = (Message) In.readObject();
                System.out.println("Incoming : "+msg.toString());
                
                if(msg.type.equals("yourid")){
                    if(ui.jTextField3.getText().length()==0){ui.jTextField3.setText(msg.content);
                    ui.jButton2.setEnabled(true);
                    }
                }
                else if(msg.type.equals("message")){
                    if(msg.recipient.equals(ui.username)){
                        ui.jTextArea1.append("["+msg.sender +" > Me] : " + msg.content + "\n");
                    }                                            
                    if(!msg.content.equals(".bye") && !msg.sender.equals(ui.username)){
                        String msgTime = (new Date()).toString();
                    }
                }
                else if(msg.type.equals("k1")){
                    ui.j1.setText(msg.sender);
                    ui.j1.setEnabled(false);
                    if(msg.sender.equals(ui.username)){
                       k1p1=1; 
                       ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                    }
                    else{
                        k1p2=1;
                        if(k1p1==1 || k1p2==1){
                            ui.j1.setEnabled(false);
                        }
                        else{
                            ui.j1.setEnabled(true);
                        }
                        if(k2p1==1||k2p2==1){
                            ui.j2.setEnabled(false);
                        }
                        else{
                            ui.j2.setEnabled(true);
                        }
                        if(k3p1==1||k3p2==1){
                            ui.j3.setEnabled(false);
                        }
                        else{
                            ui.j3.setEnabled(true);
                        }
                        if(k4p1==1||k4p2==1){
                            ui.j4.setEnabled(false);
                        }else{
                            ui.j4.setEnabled(true);
                        }
                        if(k5p1==1||k5p2==1){
                            ui.j5.setEnabled(false);
                        }else{
                            ui.j5.setEnabled(true);
                        }
                        if(k6p1==1||k6p2==1){
                            ui.j6.setEnabled(false);
                        }else{
                            ui.j6.setEnabled(true);
                        }
                        if(k7p1==1||k7p2==1){
                            ui.j7.setEnabled(false);
                        }else{
                            ui.j7.setEnabled(true);
                        }
                        if(k8p1==1||k8p2==1){
                            ui.j8.setEnabled(false);
                        }else{
                            ui.j8.setEnabled(true);
                        }
                        if(k9p1==1||k9p2==1){
                            ui.j9.setEnabled(false);
                        }else{
                            ui.j9.setEnabled(true);
                        }
                        
                    }
                    if((k1p1==1&&k2p1==1&&k3p1==1) || (k1p2==1&&k2p2==1&&k3p2==1)||
                            (k4p1==1&&k5p1==1&&k6p1==1) || (k4p2==1&&k5p2==1&&k6p2==1)||
                            (k7p1==1&&k8p1==1&&k9p1==1) || (k7p2==1&&k8p2==1&&k9p2==1)||
                            (k1p1==1&&k4p1==1&&k7p1==1) || (k1p2==1&&k4p2==1&&k7p2==1)||
                            (k2p1==1&&k5p1==1&&k8p1==1) || (k2p2==1&&k5p2==1&&k8p2==1)||
                            (k3p1==1&&k6p1==1&&k9p1==1) || (k3p2==1&&k6p2==1&&k9p2==1)||
                            (k1p1==1&&k5p1==1&&k9p1==1) || (k1p2==1&&k5p2==1&&k9p2==1)||
                            (k3p1==1&&k5p1==1&&k7p1==1) || (k3p2==1&&k5p2==1&&k7p2==1)||
                            ((k1p1==1 ||k1p2==1)&&(k2p1==1 ||k2p2==1)&&(k3p1==1 ||k3p2==1)&&
                            (k4p1==1 ||k4p2==1)&&(k5p1==1 ||k5p2==1)&&(k6p1==1 ||k6p2==1)&&
                            (k7p1==1 ||k7p2==1)&&(k8p1==1 ||k8p2==1)&&(k9p1==1 ||k9p2==1))){
                        ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                        ui.reset.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "game selesai !!");
                    }
                    
                }
                else if(msg.type.equals("k2")){
                    ui.j2.setText(msg.sender);
                    ui.j2.setEnabled(false);
                    if(msg.sender.equals(ui.username)){
                        k2p1=1;
                        
                       ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                    }else{
                        k2p2=1;
                        if(k1p1==1 || k1p2==1){
                            ui.j1.setEnabled(false);
                        }
                        else{
                            ui.j1.setEnabled(true);
                        }
                        if(k2p1==1||k2p2==1){
                            ui.j2.setEnabled(false);
                        }
                        else{
                            ui.j2.setEnabled(true);
                        }
                        if(k3p1==1||k3p2==1){
                            ui.j3.setEnabled(false);
                        }
                        else{
                            ui.j3.setEnabled(true);
                        }
                        if(k4p1==1||k4p2==1){
                            ui.j4.setEnabled(false);
                        }else{
                            ui.j4.setEnabled(true);
                        }
                        if(k5p1==1||k5p2==1){
                            ui.j5.setEnabled(false);
                        }else{
                            ui.j5.setEnabled(true);
                        }
                        if(k6p1==1||k6p2==1){
                            ui.j6.setEnabled(false);
                        }else{
                            ui.j6.setEnabled(true);
                        }
                        if(k7p1==1||k7p2==1){
                            ui.j7.setEnabled(false);
                        }else{
                            ui.j7.setEnabled(true);
                        }
                        if(k8p1==1||k8p2==1){
                            ui.j8.setEnabled(false);
                        }else{
                            ui.j8.setEnabled(true);
                        }
                        if(k9p1==1||k9p2==1){
                            ui.j9.setEnabled(false);
                        }else{
                            ui.j9.setEnabled(true);
                        }
                    }
                    if((k1p1==1&&k2p1==1&&k3p1==1) || (k1p2==1&&k2p2==1&&k3p2==1)||
                            (k4p1==1&&k5p1==1&&k6p1==1) || (k4p2==1&&k5p2==1&&k6p2==1)||
                            (k7p1==1&&k8p1==1&&k9p1==1) || (k7p2==1&&k8p2==1&&k9p2==1)||
                            (k1p1==1&&k4p1==1&&k7p1==1) || (k1p2==1&&k4p2==1&&k7p2==1)||
                            (k2p1==1&&k5p1==1&&k8p1==1) || (k2p2==1&&k5p2==1&&k8p2==1)||
                            (k3p1==1&&k6p1==1&&k9p1==1) || (k3p2==1&&k6p2==1&&k9p2==1)||
                            (k1p1==1&&k5p1==1&&k9p1==1) || (k1p2==1&&k5p2==1&&k9p2==1)||
                            (k3p1==1&&k5p1==1&&k7p1==1) || (k3p2==1&&k5p2==1&&k7p2==1)||
                            ((k1p1==1 ||k1p2==1)&&(k2p1==1 ||k2p2==1)&&(k3p1==1 ||k3p2==1)&&
                            (k4p1==1 ||k4p2==1)&&(k5p1==1 ||k5p2==1)&&(k6p1==1 ||k6p2==1)&&
                            (k7p1==1 ||k7p2==1)&&(k8p1==1 ||k8p2==1)&&(k9p1==1 ||k9p2==1))){
                        ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                        ui.reset.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "game selesai !!");
                    }
                }
                else if(msg.type.equals("k3")){
                    ui.j3.setText(msg.sender);
                    ui.j3.setEnabled(false);
                    if(msg.sender.equals(ui.username)){
                        k3p1=1;
                        
                       ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                    }
                    else{
                        k3p2=1;
                        if(k1p1==1 || k1p2==1){
                            ui.j1.setEnabled(false);
                        }
                        else{
                            ui.j1.setEnabled(true);
                        }
                        if(k2p1==1||k2p2==1){
                            ui.j2.setEnabled(false);
                        }
                        else{
                            ui.j2.setEnabled(true);
                        }
                        if(k3p1==1||k3p2==1){
                            ui.j3.setEnabled(false);
                        }
                        else{
                            ui.j3.setEnabled(true);
                        }
                        if(k4p1==1||k4p2==1){
                            ui.j4.setEnabled(false);
                        }else{
                            ui.j4.setEnabled(true);
                        }
                        if(k5p1==1||k5p2==1){
                            ui.j5.setEnabled(false);
                        }else{
                            ui.j5.setEnabled(true);
                        }
                        if(k6p1==1||k6p2==1){
                            ui.j6.setEnabled(false);
                        }else{
                            ui.j6.setEnabled(true);
                        }
                        if(k7p1==1||k7p2==1){
                            ui.j7.setEnabled(false);
                        }else{
                            ui.j7.setEnabled(true);
                        }
                        if(k8p1==1||k8p2==1){
                            ui.j8.setEnabled(false);
                        }else{
                            ui.j8.setEnabled(true);
                        }
                        if(k9p1==1||k9p2==1){
                            ui.j9.setEnabled(false);
                        }else{
                            ui.j9.setEnabled(true);
                        }
                    }
                    if((k1p1==1&&k2p1==1&&k3p1==1) || (k1p2==1&&k2p2==1&&k3p2==1)||
                            (k4p1==1&&k5p1==1&&k6p1==1) || (k4p2==1&&k5p2==1&&k6p2==1)||
                            (k7p1==1&&k8p1==1&&k9p1==1) || (k7p2==1&&k8p2==1&&k9p2==1)||
                            (k1p1==1&&k4p1==1&&k7p1==1) || (k1p2==1&&k4p2==1&&k7p2==1)||
                            (k2p1==1&&k5p1==1&&k8p1==1) || (k2p2==1&&k5p2==1&&k8p2==1)||
                            (k3p1==1&&k6p1==1&&k9p1==1) || (k3p2==1&&k6p2==1&&k9p2==1)||
                            (k1p1==1&&k5p1==1&&k9p1==1) || (k1p2==1&&k5p2==1&&k9p2==1)||
                            (k3p1==1&&k5p1==1&&k7p1==1) || (k3p2==1&&k5p2==1&&k7p2==1)||
                            ((k1p1==1 ||k1p2==1)&&(k2p1==1 ||k2p2==1)&&(k3p1==1 ||k3p2==1)&&
                            (k4p1==1 ||k4p2==1)&&(k5p1==1 ||k5p2==1)&&(k6p1==1 ||k6p2==1)&&
                            (k7p1==1 ||k7p2==1)&&(k8p1==1 ||k8p2==1)&&(k9p1==1 ||k9p2==1))){
                        ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                        ui.reset.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "game selesai !!");
                    }
                }
                else if(msg.type.equals("k4")){
                    ui.j4.setText(msg.sender);
                    ui.j4.setEnabled(false);
                    if(msg.sender.equals(ui.username)){
                       k4p1=1; 
                       
                       ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                    }
                    else{
                        k4p2=1;
                        if(k1p1==1 || k1p2==1){
                            ui.j1.setEnabled(false);
                        }
                        else{
                            ui.j1.setEnabled(true);
                        }
                        if(k2p1==1||k2p2==1){
                            ui.j2.setEnabled(false);
                        }
                        else{
                            ui.j2.setEnabled(true);
                        }
                        if(k3p1==1||k3p2==1){
                            ui.j3.setEnabled(false);
                        }
                        else{
                            ui.j3.setEnabled(true);
                        }
                        if(k4p1==1||k4p2==1){
                            ui.j4.setEnabled(false);
                        }else{
                            ui.j4.setEnabled(true);
                        }
                        if(k5p1==1||k5p2==1){
                            ui.j5.setEnabled(false);
                        }else{
                            ui.j5.setEnabled(true);
                        }
                        if(k6p1==1||k6p2==1){
                            ui.j6.setEnabled(false);
                        }else{
                            ui.j6.setEnabled(true);
                        }
                        if(k7p1==1||k7p2==1){
                            ui.j7.setEnabled(false);
                        }else{
                            ui.j7.setEnabled(true);
                        }
                        if(k8p1==1||k8p2==1){
                            ui.j8.setEnabled(false);
                        }else{
                            ui.j8.setEnabled(true);
                        }
                        if(k9p1==1||k9p2==1){
                            ui.j9.setEnabled(false);
                        }else{
                            ui.j9.setEnabled(true);
                        }
                    }
                    if((k1p1==1&&k2p1==1&&k3p1==1) || (k1p2==1&&k2p2==1&&k3p2==1)||
                            (k4p1==1&&k5p1==1&&k6p1==1) || (k4p2==1&&k5p2==1&&k6p2==1)||
                            (k7p1==1&&k8p1==1&&k9p1==1) || (k7p2==1&&k8p2==1&&k9p2==1)||
                            (k1p1==1&&k4p1==1&&k7p1==1) || (k1p2==1&&k4p2==1&&k7p2==1)||
                            (k2p1==1&&k5p1==1&&k8p1==1) || (k2p2==1&&k5p2==1&&k8p2==1)||
                            (k3p1==1&&k6p1==1&&k9p1==1) || (k3p2==1&&k6p2==1&&k9p2==1)||
                            (k1p1==1&&k5p1==1&&k9p1==1) || (k1p2==1&&k5p2==1&&k9p2==1)||
                            (k3p1==1&&k5p1==1&&k7p1==1) || (k3p2==1&&k5p2==1&&k7p2==1)||
                            ((k1p1==1 ||k1p2==1)&&(k2p1==1 ||k2p2==1)&&(k3p1==1 ||k3p2==1)&&
                            (k4p1==1 ||k4p2==1)&&(k5p1==1 ||k5p2==1)&&(k6p1==1 ||k6p2==1)&&
                            (k7p1==1 ||k7p2==1)&&(k8p1==1 ||k8p2==1)&&(k9p1==1 ||k9p2==1))){
                        ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                        ui.reset.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "game selesai !!");
                    }
                }
                else if(msg.type.equals("k5")){
                    ui.j5.setText(msg.sender);
                    ui.j5.setEnabled(false);
                    if(msg.sender.equals(ui.username)){
                        k5p1=1;
                        
                       ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                    }
                    else{
                        k5p2=1;
                        if(k1p1==1 || k1p2==1){
                            ui.j1.setEnabled(false);
                        }
                        else{
                            ui.j1.setEnabled(true);
                        }
                        if(k2p1==1||k2p2==1){
                            ui.j2.setEnabled(false);
                        }
                        else{
                            ui.j2.setEnabled(true);
                        }
                        if(k3p1==1||k3p2==1){
                            ui.j3.setEnabled(false);
                        }
                        else{
                            ui.j3.setEnabled(true);
                        }
                        if(k4p1==1||k4p2==1){
                            ui.j4.setEnabled(false);
                        }else{
                            ui.j4.setEnabled(true);
                        }
                        if(k5p1==1||k5p2==1){
                            ui.j5.setEnabled(false);
                        }else{
                            ui.j5.setEnabled(true);
                        }
                        if(k6p1==1||k6p2==1){
                            ui.j6.setEnabled(false);
                        }else{
                            ui.j6.setEnabled(true);
                        }
                        if(k7p1==1||k7p2==1){
                            ui.j7.setEnabled(false);
                        }else{
                            ui.j7.setEnabled(true);
                        }
                        if(k8p1==1||k8p2==1){
                            ui.j8.setEnabled(false);
                        }else{
                            ui.j8.setEnabled(true);
                        }
                        if(k9p1==1||k9p2==1){
                            ui.j9.setEnabled(false);
                        }else{
                            ui.j9.setEnabled(true);
                        }
                    }
                    if((k1p1==1&&k2p1==1&&k3p1==1) || (k1p2==1&&k2p2==1&&k3p2==1)||
                            (k4p1==1&&k5p1==1&&k6p1==1) || (k4p2==1&&k5p2==1&&k6p2==1)||
                            (k7p1==1&&k8p1==1&&k9p1==1) || (k7p2==1&&k8p2==1&&k9p2==1)||
                            (k1p1==1&&k4p1==1&&k7p1==1) || (k1p2==1&&k4p2==1&&k7p2==1)||
                            (k2p1==1&&k5p1==1&&k8p1==1) || (k2p2==1&&k5p2==1&&k8p2==1)||
                            (k3p1==1&&k6p1==1&&k9p1==1) || (k3p2==1&&k6p2==1&&k9p2==1)||
                            (k1p1==1&&k5p1==1&&k9p1==1) || (k1p2==1&&k5p2==1&&k9p2==1)||
                            (k3p1==1&&k5p1==1&&k7p1==1) || (k3p2==1&&k5p2==1&&k7p2==1)||
                            ((k1p1==1 ||k1p2==1)&&(k2p1==1 ||k2p2==1)&&(k3p1==1 ||k3p2==1)&&
                            (k4p1==1 ||k4p2==1)&&(k5p1==1 ||k5p2==1)&&(k6p1==1 ||k6p2==1)&&
                            (k7p1==1 ||k7p2==1)&&(k8p1==1 ||k8p2==1)&&(k9p1==1 ||k9p2==1))){
                        ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                        ui.reset.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "game selesai !!");
                    }
                }
                else if(msg.type.equals("k6")){
                    ui.j6.setText(msg.sender);
                    ui.j6.setEnabled(false);
                    if(msg.sender.equals(ui.username)){
                        k6p1=1;
                        
                       ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                    }else{
                        k6p2=1;
                        if(k1p1==1 || k1p2==1){
                            ui.j1.setEnabled(false);
                        }
                        else{
                            ui.j1.setEnabled(true);
                        }
                        if(k2p1==1||k2p2==1){
                            ui.j2.setEnabled(false);
                        }
                        else{
                            ui.j2.setEnabled(true);
                        }
                        if(k3p1==1||k3p2==1){
                            ui.j3.setEnabled(false);
                        }
                        else{
                            ui.j3.setEnabled(true);
                        }
                        if(k4p1==1||k4p2==1){
                            ui.j4.setEnabled(false);
                        }else{
                            ui.j4.setEnabled(true);
                        }
                        if(k5p1==1||k5p2==1){
                            ui.j5.setEnabled(false);
                        }else{
                            ui.j5.setEnabled(true);
                        }
                        if(k6p1==1||k6p2==1){
                            ui.j6.setEnabled(false);
                        }else{
                            ui.j6.setEnabled(true);
                        }
                        if(k7p1==1||k7p2==1){
                            ui.j7.setEnabled(false);
                        }else{
                            ui.j7.setEnabled(true);
                        }
                        if(k8p1==1||k8p2==1){
                            ui.j8.setEnabled(false);
                        }else{
                            ui.j8.setEnabled(true);
                        }
                        if(k9p1==1||k9p2==1){
                            ui.j9.setEnabled(false);
                        }else{
                            ui.j9.setEnabled(true);
                        }
                    }
                    if((k1p1==1&&k2p1==1&&k3p1==1) || (k1p2==1&&k2p2==1&&k3p2==1)||
                            (k4p1==1&&k5p1==1&&k6p1==1) || (k4p2==1&&k5p2==1&&k6p2==1)||
                            (k7p1==1&&k8p1==1&&k9p1==1) || (k7p2==1&&k8p2==1&&k9p2==1)||
                            (k1p1==1&&k4p1==1&&k7p1==1) || (k1p2==1&&k4p2==1&&k7p2==1)||
                            (k2p1==1&&k5p1==1&&k8p1==1) || (k2p2==1&&k5p2==1&&k8p2==1)||
                            (k3p1==1&&k6p1==1&&k9p1==1) || (k3p2==1&&k6p2==1&&k9p2==1)||
                            (k1p1==1&&k5p1==1&&k9p1==1) || (k1p2==1&&k5p2==1&&k9p2==1)||
                            (k3p1==1&&k5p1==1&&k7p1==1) || (k3p2==1&&k5p2==1&&k7p2==1)||
                            ((k1p1==1 ||k1p2==1)&&(k2p1==1 ||k2p2==1)&&(k3p1==1 ||k3p2==1)&&
                            (k4p1==1 ||k4p2==1)&&(k5p1==1 ||k5p2==1)&&(k6p1==1 ||k6p2==1)&&
                            (k7p1==1 ||k7p2==1)&&(k8p1==1 ||k8p2==1)&&(k9p1==1 ||k9p2==1))){
                        ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                        ui.reset.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "game selesai !!");
                    }
                }
                else if(msg.type.equals("k7")){
                    ui.j7.setText(msg.sender);
                    ui.j7.setEnabled(false);
                    if(msg.sender.equals(ui.username)){
                        k7p1=1;
                        
                       ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                    }else{
                        k7p2=1;
                        if(k1p1==1 || k1p2==1){
                            ui.j1.setEnabled(false);
                        }
                        else{
                            ui.j1.setEnabled(true);
                        }
                        if(k2p1==1||k2p2==1){
                            ui.j2.setEnabled(false);
                        }
                        else{
                            ui.j2.setEnabled(true);
                        }
                        if(k3p1==1||k3p2==1){
                            ui.j3.setEnabled(false);
                        }
                        else{
                            ui.j3.setEnabled(true);
                        }
                        if(k4p1==1||k4p2==1){
                            ui.j4.setEnabled(false);
                        }else{
                            ui.j4.setEnabled(true);
                        }
                        if(k5p1==1||k5p2==1){
                            ui.j5.setEnabled(false);
                        }else{
                            ui.j5.setEnabled(true);
                        }
                        if(k6p1==1||k6p2==1){
                            ui.j6.setEnabled(false);
                        }else{
                            ui.j6.setEnabled(true);
                        }
                        if(k7p1==1||k7p2==1){
                            ui.j7.setEnabled(false);
                        }else{
                            ui.j7.setEnabled(true);
                        }
                        if(k8p1==1||k8p2==1){
                            ui.j8.setEnabled(false);
                        }else{
                            ui.j8.setEnabled(true);
                        }
                        if(k9p1==1||k9p2==1){
                            ui.j9.setEnabled(false);
                        }else{
                            ui.j9.setEnabled(true);
                        }
                    }
                    if((k1p1==1&&k2p1==1&&k3p1==1) || (k1p2==1&&k2p2==1&&k3p2==1)||
                            (k4p1==1&&k5p1==1&&k6p1==1) || (k4p2==1&&k5p2==1&&k6p2==1)||
                            (k7p1==1&&k8p1==1&&k9p1==1) || (k7p2==1&&k8p2==1&&k9p2==1)||
                            (k1p1==1&&k4p1==1&&k7p1==1) || (k1p2==1&&k4p2==1&&k7p2==1)||
                            (k2p1==1&&k5p1==1&&k8p1==1) || (k2p2==1&&k5p2==1&&k8p2==1)||
                            (k3p1==1&&k6p1==1&&k9p1==1) || (k3p2==1&&k6p2==1&&k9p2==1)||
                            (k1p1==1&&k5p1==1&&k9p1==1) || (k1p2==1&&k5p2==1&&k9p2==1)||
                            (k3p1==1&&k5p1==1&&k7p1==1) || (k3p2==1&&k5p2==1&&k7p2==1)||
                            ((k1p1==1 ||k1p2==1)&&(k2p1==1 ||k2p2==1)&&(k3p1==1 ||k3p2==1)&&
                            (k4p1==1 ||k4p2==1)&&(k5p1==1 ||k5p2==1)&&(k6p1==1 ||k6p2==1)&&
                            (k7p1==1 ||k7p2==1)&&(k8p1==1 ||k8p2==1)&&(k9p1==1 ||k9p2==1))){
                        ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                        ui.reset.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "game selesai !!");
                    }
                }
                else if(msg.type.equals("k8")){
                    ui.j8.setText(msg.sender);
                    ui.j8.setEnabled(false);
                    if(msg.sender.equals(ui.username)){
                        k8p1=1;
                        
                       ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                    }
                    else{
                        k8p2=1;
                        if(k1p1==1 || k1p2==1){
                            ui.j1.setEnabled(false);
                        }
                        else{
                            ui.j1.setEnabled(true);
                        }
                        if(k2p1==1||k2p2==1){
                            ui.j2.setEnabled(false);
                        }
                        else{
                            ui.j2.setEnabled(true);
                        }
                        if(k3p1==1||k3p2==1){
                            ui.j3.setEnabled(false);
                        }
                        else{
                            ui.j3.setEnabled(true);
                        }
                        if(k4p1==1||k4p2==1){
                            ui.j4.setEnabled(false);
                        }else{
                            ui.j4.setEnabled(true);
                        }
                        if(k5p1==1||k5p2==1){
                            ui.j5.setEnabled(false);
                        }else{
                            ui.j5.setEnabled(true);
                        }
                        if(k6p1==1||k6p2==1){
                            ui.j6.setEnabled(false);
                        }else{
                            ui.j6.setEnabled(true);
                        }
                        if(k7p1==1||k7p2==1){
                            ui.j7.setEnabled(false);
                        }else{
                            ui.j7.setEnabled(true);
                        }
                        if(k8p1==1||k8p2==1){
                            ui.j8.setEnabled(false);
                        }else{
                            ui.j8.setEnabled(true);
                        }
                        if(k9p1==1||k9p2==1){
                            ui.j9.setEnabled(false);
                        }else{
                            ui.j9.setEnabled(true);
                        }
                    }
                    if((k1p1==1&&k2p1==1&&k3p1==1) || (k1p2==1&&k2p2==1&&k3p2==1)||
                            (k4p1==1&&k5p1==1&&k6p1==1) || (k4p2==1&&k5p2==1&&k6p2==1)||
                            (k7p1==1&&k8p1==1&&k9p1==1) || (k7p2==1&&k8p2==1&&k9p2==1)||
                            (k1p1==1&&k4p1==1&&k7p1==1) || (k1p2==1&&k4p2==1&&k7p2==1)||
                            (k2p1==1&&k5p1==1&&k8p1==1) || (k2p2==1&&k5p2==1&&k8p2==1)||
                            (k3p1==1&&k6p1==1&&k9p1==1) || (k3p2==1&&k6p2==1&&k9p2==1)||
                            (k1p1==1&&k5p1==1&&k9p1==1) || (k1p2==1&&k5p2==1&&k9p2==1)||
                            (k3p1==1&&k5p1==1&&k7p1==1) || (k3p2==1&&k5p2==1&&k7p2==1)||
                            ((k1p1==1 ||k1p2==1)&&(k2p1==1 ||k2p2==1)&&(k3p1==1 ||k3p2==1)&&
                            (k4p1==1 ||k4p2==1)&&(k5p1==1 ||k5p2==1)&&(k6p1==1 ||k6p2==1)&&
                            (k7p1==1 ||k7p2==1)&&(k8p1==1 ||k8p2==1)&&(k9p1==1 ||k9p2==1))){
                        ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                        ui.reset.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "game selesai !!");
                    }
                }
                else if(msg.type.equals("k9")){
                    ui.j9.setText(msg.sender);
                    ui.j9.setEnabled(false);
                    if(msg.sender.equals(ui.username)){
                        k9p1=1;
                        
                       ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                    }else{
                        k9p2=1;
                        if(k1p1==1 || k1p2==1){
                            ui.j1.setEnabled(false);
                        }
                        else{
                            ui.j1.setEnabled(true);
                        }
                        if(k2p1==1||k2p2==1){
                            ui.j2.setEnabled(false);
                        }
                        else{
                            ui.j2.setEnabled(true);
                        }
                        if(k3p1==1||k3p2==1){
                            ui.j3.setEnabled(false);
                        }
                        else{
                            ui.j3.setEnabled(true);
                        }
                        if(k4p1==1||k4p2==1){
                            ui.j4.setEnabled(false);
                        }else{
                            ui.j4.setEnabled(true);
                        }
                        if(k5p1==1||k5p2==1){
                            ui.j5.setEnabled(false);
                        }else{
                            ui.j5.setEnabled(true);
                        }
                        if(k6p1==1||k6p2==1){
                            ui.j6.setEnabled(false);
                        }else{
                            ui.j6.setEnabled(true);
                        }
                        if(k7p1==1||k7p2==1){
                            ui.j7.setEnabled(false);
                        }else{
                            ui.j7.setEnabled(true);
                        }
                        if(k8p1==1||k8p2==1){
                            ui.j8.setEnabled(false);
                        }else{
                            ui.j8.setEnabled(true);
                        }
                        if(k9p1==1||k9p2==1){
                            ui.j9.setEnabled(false);
                        }else{
                            ui.j9.setEnabled(true);
                        }
                    }
                    if((k1p1==1&&k2p1==1&&k3p1==1) || (k1p2==1&&k2p2==1&&k3p2==1)||
                            (k4p1==1&&k5p1==1&&k6p1==1) || (k4p2==1&&k5p2==1&&k6p2==1)||
                            (k7p1==1&&k8p1==1&&k9p1==1) || (k7p2==1&&k8p2==1&&k9p2==1)||
                            (k1p1==1&&k4p1==1&&k7p1==1) || (k1p2==1&&k4p2==1&&k7p2==1)||
                            (k2p1==1&&k5p1==1&&k8p1==1) || (k2p2==1&&k5p2==1&&k8p2==1)||
                            (k3p1==1&&k6p1==1&&k9p1==1) || (k3p2==1&&k6p2==1&&k9p2==1)||
                            (k1p1==1&&k5p1==1&&k9p1==1) || (k1p2==1&&k5p2==1&&k9p2==1)||
                            (k3p1==1&&k5p1==1&&k7p1==1) || (k3p2==1&&k5p2==1&&k7p2==1)||
                            ((k1p1==1 ||k1p2==1)&&(k2p1==1 ||k2p2==1)&&(k3p1==1 ||k3p2==1)&&
                            (k4p1==1 ||k4p2==1)&&(k5p1==1 ||k5p2==1)&&(k6p1==1 ||k6p2==1)&&
                            (k7p1==1 ||k7p2==1)&&(k8p1==1 ||k8p2==1)&&(k9p1==1 ||k9p2==1))){
                        ui.j1.setEnabled(false);
                        ui.j2.setEnabled(false);
                        ui.j3.setEnabled(false);
                        ui.j4.setEnabled(false);
                        ui.j5.setEnabled(false);
                        ui.j6.setEnabled(false);
                        ui.j7.setEnabled(false);
                        ui.j8.setEnabled(false);
                        ui.j9.setEnabled(false);
                        ui.reset.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "game selesai !!");
                    }
                }
                else if(msg.type.equals("reset")){
                    if(msg.sender.equals(ui.username)){
                        resetsendiri=1;
                    }
                    else{
                        resetmusuh=1;
                    }
                    if(resetsendiri==1 && resetmusuh==1){
                        if(ui.username.equalsIgnoreCase("X")){
                        ui.j1.setEnabled(true);
                        ui.j2.setEnabled(true);
                        ui.j3.setEnabled(true);
                        ui.j4.setEnabled(true);
                        ui.j5.setEnabled(true);
                        ui.j6.setEnabled(true);
                        ui.j7.setEnabled(true);
                        ui.j8.setEnabled(true);
                        ui.j9.setEnabled(true);
                        }
                        ui.j1.setText("");
                        ui.j2.setText("");
                        ui.j3.setText("");
                        ui.j4.setText("");
                        ui.j5.setText("");
                        ui.j6.setText("");
                        ui.j7.setText("");
                        ui.j8.setText("");
                        ui.j9.setText("");
                        k1p1=0; k1p2=0;
                        k2p1=0; k2p2=0;
                        k3p1=0; k3p2=0;
                        k4p1=0; k4p2=0;
                        k5p1=0; k5p2=0;
                        k6p1=0; k6p2=0;
                        k7p1=0; k7p2=0;
                        k8p1=0; k8p2=0;
                        k9p1=0; k9p2=0;
                        resetsendiri=0;
                        resetmusuh=0;
                        ui.reset.setEnabled(false);
                    }
                }
                else if(msg.type.equals("login")){
                    if(msg.content.equals("TRUE")){
                        ui.jButton2.setEnabled(false);   
                        if(ui.username.equalsIgnoreCase("X")){
                            ui.j1.setEnabled(true);
                        ui.j1.setText("");
                        ui.j2.setEnabled(true);
                        ui.j2.setText("");
                        ui.j3.setEnabled(true);
                        ui.j3.setText("");
                        ui.j4.setEnabled(true);
                        ui.j4.setText("");
                        ui.j5.setEnabled(true);
                        ui.j5.setText("");
                        ui.j6.setEnabled(true);
                        ui.j6.setText("");
                        ui.j7.setEnabled(true);
                        ui.j7.setText("");
                        ui.j8.setEnabled(true);
                        ui.j8.setText("");
                        ui.j9.setEnabled(true);
                        ui.j9.setText("");
                        }
                        ui.jTextArea1.append("[SERVER > Me] : Login Successful\n");
                        ui.jTextField3.setEnabled(false); 
                        
                    }
                    else{
                        ui.jTextArea1.append("[SERVER > Me] : Login Failed\n");
                    }
                }
                else if(msg.type.equals("test")){
                    ui.jButton1.setEnabled(false);
                    ui.jButton2.setEnabled(true); 
                    ui.jTextField3.setEnabled(true); 
                    ui.jTextField1.setEditable(false); ui.jTextField2.setEditable(false);
                    
                }
                else if(msg.type.equals("signout")){
                    if(msg.content.equals(ui.username)){
                        ui.jTextArea1.append("["+ msg.sender +" > Me] : Bye\n");
                        ui.jTextField1.setEditable(true); ui.jTextField2.setEditable(true);
                        
                        for(int i = 1; i < ui.model.size(); i++){
                            ui.model.removeElementAt(i);
                        }
                        
                        ui.clientThread.stop();
                    }
                    else{
                        ui.model.removeElement(msg.content);
                        ui.jTextArea1.append("["+ msg.sender +" > All] : "+ msg.content +" has signed out\n");
                    }
                }
                else{
                }
            }
            catch(Exception ex) {
                keepRunning = false;
                ui.jTextArea1.append("[Application > Me] : Connection Failure\n");
                ui.jButton1.setEnabled(true); ui.jTextField1.setEditable(true); ui.jTextField2.setEditable(true);
               
                
                for(int i = 1; i < ui.model.size(); i++){
                    ui.model.removeElementAt(i);
                }
                
                ui.clientThread.stop();
                
                System.out.println("Exception SocketClient run()");
                ex.printStackTrace();
            }
        }
    }
    
    public void send(Message msg){
        try {
            Out.writeObject(msg);
            Out.flush();
            System.out.println("Outgoing : "+msg.toString());
            
            if(msg.type.equals("message") && !msg.content.equals(".bye")){
                String msgTime = (new Date()).toString();
                
            }
        } 
        catch (IOException ex) {
            System.out.println("Exception SocketClient send()");
        }
    }
    
    public void closeThread(Thread t){
        t = null;
    }
}

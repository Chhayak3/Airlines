package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BoardingPass extends JFrame implements ActionListener{
   JLabel tfname,tfnationality,tfsrc,tfdest,tfcode,tfdate,labelfname;
   JTextField tfpnr;
    public BoardingPass(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel l1=new  JLabel("AIR INDIA");
        l1.setBounds(380,20,450,35);
        l1.setFont(new Font("Tahoma",Font.PLAIN,30));
        l1.setForeground(Color.black);
        add(l1);
        
        JLabel l2=new  JLabel("Boarding Pass");
        l2.setBounds(360,60,300,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        l2.setForeground(Color.black);
        add(l2);
        
        
        JLabel pnr=new  JLabel("PNR Details");
        pnr.setBounds(60,100,150,25);
        pnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(pnr);
        
        tfpnr=new JTextField();
        tfpnr.setBounds(220,100,150,25);
        //tfpnr.setForeground(Color.white);
        add(tfpnr);
        
        JButton enter=new JButton ("ENTER");
       enter.setBackground(Color.BLACK);
       enter.setForeground(Color.WHITE);
       enter.setBounds(380,100,120,25);
       enter.addActionListener(this);
       add(enter);
       
       JLabel name=new JLabel("NAME");
       name.setBounds(60,140,150,25);
       name.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(name);
       
       tfname=new JLabel();
       tfname.setBounds(220,140,150,25);
      add(tfname);
      
      JLabel lblnationality=new JLabel("NATIONALITY");
       lblnationality.setBounds(60,180,150,25);
       lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblnationality);
       
       tfnationality=new JLabel();
       tfnationality.setBounds(220,180,150,25);
       add(tfnationality);
     
       JLabel lblsrc=new JLabel("SRC");
       lblsrc.setBounds(60,220,150,25);
       lblsrc.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblsrc);
       
      tfsrc=new JLabel();
       tfsrc.setBounds(220,220,150,25);
      add(tfsrc);
       
        JLabel lbldest=new JLabel("DEST");
       
       lbldest.setBounds(315,220,150,25);
       lbldest.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lbldest);
       
       tfdest=new JLabel();
       tfdest.setBounds(420,220,150,25);
       add(tfdest);
       
        JLabel lblfname=new JLabel("FLIGHT NAME");
       lblfname.setBounds(60,260,150,25);
       lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblfname);
       
       labelfname=new JLabel();
       labelfname.setBounds(220,260,150,25);
       add(labelfname);
       
       JLabel lblfcode=new JLabel("FLIGHT CODE");
       lblfcode.setBounds(315,260,150,25);
       lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblfcode);
       
       tfcode=new JLabel();
       tfcode.setBounds(315,260,150,25);
       tfcode.setBounds(420,260,150,25);
       add(tfcode);
       
        JLabel lbldate=new JLabel("DATE");
        lbldate.setBounds(60,300,150,25);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
       
       tfdate=new JLabel();
       tfdate.setBounds(220,300,150,25);
       add(tfdate);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
       Image i2=i1.getImage().getScaledInstance(300,230,Image.SCALE_DEFAULT);
       ImageIcon lblimage=new ImageIcon(i2);
       JLabel labelimage=new JLabel(lblimage);
       labelimage.setBounds(600,0,300,300);
       add(labelimage);
       
        setSize(1000,450);
        setLocation(350,150);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    String pnr=tfpnr.getText();
    try{
    
    Conn c=new Conn();
    String query="select * from reservation where PNR ='"+pnr+"'";
    ResultSet rs=c.s.executeQuery(query);
    if(rs.next()){
      tfname.setText(rs.getString("name"));  
      tfnationality.setText(rs.getString("nationality"));
      tfsrc.setText(rs.getString("src"));
       tfdest.setText(rs.getString("destination"));
         labelfname.setText(rs.getString("flightname"));
       tfcode.setText(rs.getString("flightcode"));
       tfdate.setText(rs.getString("ddate"));
     }else{
    JOptionPane.showMessageDialog(null, "Please enter correct PNR");}
    }
    catch(Exception e){
    e.printStackTrace();
    }
    }
       
      
    public static void main(String args[])
    {
        new BoardingPass();
    }
}

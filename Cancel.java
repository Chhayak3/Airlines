package airlinemanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;


public class Cancel extends JFrame implements ActionListener{
    JTextField tfpnr;
    JLabel tfname, cancellationno,fcode,ddate;
    JButton fetchbutton,cancel;
   
            
    public Cancel(){
       setLayout(null);
       getContentPane().setBackground(Color.WHITE);
       
       Random random=new Random();
       
       JLabel heading =new JLabel("CANCELLATION");
       heading.setBounds(180,20,250,35);
       heading.setFont(new Font("Tahoma",Font.PLAIN,32));
       add(heading);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2= i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(470,120,250,250);
        add(image);
       
       JLabel lblpnr =new JLabel("PNR Number");
       lblpnr.setBounds(60,80,150,25);
       lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblpnr);
       
       tfpnr =new JTextField();
       tfpnr.setBounds(220,80,150,25);
       add(tfpnr);
       
       fetchbutton=new JButton("Show Details");
       fetchbutton.setBounds(380,80,120,25);
       fetchbutton.setForeground(Color.WHITE);
       fetchbutton.setBackground(Color.BLACK);
       fetchbutton.addActionListener(this);
       add(fetchbutton);
      
       JLabel name=new JLabel("Name");
       name.setBounds(60,130,150,25);
       name.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(name);
       
       tfname=new JLabel();
       tfname.setBounds(220,130,150,25);
       add(tfname);
         
       JLabel lblcancel=new JLabel("Cancellation No");
       lblcancel.setBounds(60,180,150,25);
       lblcancel.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblcancel);
       
       cancellationno =new JLabel(""+random.nextInt(1000000));
        cancellationno.setBounds(220,180,150,25);
       add( cancellationno);
       
       JLabel lblfcode=new JLabel("Flight Code");
       lblfcode.setBounds(60,230,150,25);
       lblfcode.setForeground(Color.BLACK);
      lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblfcode);
       
       fcode=new JLabel();
       fcode.setBounds(220,230,150,25);
       add(fcode);
       
       JLabel date=new JLabel("Date");
       date.setBounds(60,280,150,25);
       date.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(date);
       
      ddate =new JLabel();
      ddate.setBounds(220,280,150,25);
       add(ddate);
     
       
       cancel=new JButton("Cancel");
       cancel.setBounds(220,380,120,25);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
       add(cancel);
       
       
       
        setSize(800,450);
        setLocation(350,150);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchbutton){
        String pnr =tfpnr.getText();
        
        try{
        Conn c=new Conn();
        String query="select * from reservation where PNR='"+pnr+"'";
        ResultSet rs=c.s.executeQuery(query);
        if(rs.next()){
            tfname.setText(rs.getString("name"));
            //cancellationno.setText(rs.getString("cancellationno"));
            fcode.setText(rs.getString("flightcode"));
            ddate.setText(rs.getString("ddate"));
            
        }else{
        JOptionPane.showMessageDialog(null,"Please enter correct PNR");
        }
        }catch(Exception e){
        e.printStackTrace();
        }
       } 
        else if(ae.getSource()==cancel){
       String name=tfname.getText();
       String pnr=tfpnr.getText();
       String cancelno=cancellationno.getText();
       String flightcode=fcode.getText();
       String date=ddate.getText();
       try{
       Conn c=new Conn();
       String query="insert into cancel values ('"+pnr+"','"+name+"','"+cancelno+"','"+flightcode+"','"+date+"')";
       c.s.executeUpdate(query);
       c.s.executeUpdate("delete from reservation where PNR ='"+pnr+"'");
       
       JOptionPane.showMessageDialog(null, "Ticket cancelled");
       setVisible(false);
       
       }catch(Exception e){
       e.printStackTrace();
       }
       }
       
       
    }
    public static void main(String args[]){
        new Cancel();
    }
    
}


package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton reset,submit,close;
    JTextField tfusername,pfpassword;
    
  public  Login(){
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel lblusername=new JLabel("Username");
      lblusername.setBounds(20, 20, 100, 20);
      add(lblusername);
      
      JLabel lblpassword=new JLabel("Password");
      lblpassword.setBounds(20,60,100,20);
      add(lblpassword);
      
      tfusername=new JTextField();
      tfusername.setBounds(130,20,200,20);
      add(tfusername);
      
      pfpassword=new JPasswordField();
      pfpassword.setBounds(130,60,200,20);
      add(pfpassword);
      
      reset=new JButton("Reset");
      reset.setBounds(30,120,120,20);
      reset.addActionListener(this);
      add(reset);
      
       submit=new JButton("Submit");
       submit.setBounds(190,120,120,20);
       submit.addActionListener(this);
      add(submit);
      
       close=new JButton("close");
       close.setBounds(120,150,120,20);
       close.addActionListener(this);
       add(close);
      
      
      setSize(400,250);
      setLocation(600,250);
      setVisible(true);
    }
  public void actionPerformed(ActionEvent ae){
  if(ae.getSource()== submit){
      String username=tfusername.getText();
      String password=pfpassword.getText();
      try{
      Conn c=new Conn();
      String query="select * from login where username='"+username+"' and password='"+password+"'";
      ResultSet rs=c.s.executeQuery(query);
      if(rs.next()){
         new Home();
          setVisible(false);
      }else{
      JOptionPane.showMessageDialog(null,"invalid username and passeord");
      setVisible(false);
      }
      }catch(Exception e){
          e.printStackTrace();
      }
  }else if(ae.getSource() == reset){
      tfusername.setText("");
      pfpassword.setText("");
  }else if(ae.getSource() == close){
      setVisible(false);
  }
      }
          
  public static void main(String args[]){
      new Login();
  }
  
}

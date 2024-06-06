package airlinemanagementsystem;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class BookFlight extends JFrame implements ActionListener{
    JTextField tfaadhar;
    JLabel tfname,tfnationality,tfaddress,rbmale,rnfemale,tfgender,lblfname,lblfcode;
    JButton bookflight,fetchbutton,fetchflights;
    Choice source,dest;
    JDateChooser dcdate;
            
    public BookFlight(){
       setLayout(null);
       getContentPane().setBackground(Color.WHITE);
       
       JLabel heading =new JLabel("Book Flight");
       heading.setBounds(420,20,500,35);
       heading.setForeground(Color.BLUE);
       heading.setFont(new Font("Tahoma",Font.PLAIN,32));
       add(heading);
       
       JLabel aadhar =new JLabel("Aadhar");
       aadhar.setBounds(60,80,150,25);
       //aadhar.setForeground(Color.BLACK);
       aadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(aadhar);
       
       tfaadhar =new JTextField();
       tfaadhar.setBounds(220,80,150,25);
       add(tfaadhar);
       
       fetchbutton=new JButton("FetchUser");
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
         
       JLabel nationality=new JLabel("Nationality");
       nationality.setBounds(60,180,150,25);
       nationality.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(nationality);
       
       tfnationality =new JLabel();
       tfnationality.setBounds(220,180,150,25);
       add(tfnationality);
       
       JLabel address=new JLabel("Address");
       address.setBounds(60,230,150,25);
       address.setForeground(Color.BLACK);
       address.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(address);
       
       tfaddress=new JLabel();
       tfaddress.setBounds(220,230,150,25);
       add(tfaddress);
       
       JLabel gender=new JLabel("Gender");
       gender.setBounds(60,280,150,25);
       gender.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(gender);
       
       tfgender =new JLabel();
       tfgender.setBounds(220,280,150,25);
       add(tfgender);
     
       JLabel lblsource=new JLabel("Source");
       lblsource.setBounds(60,330,150,25);
       lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblsource);
       
        source=new Choice();
       source.setBounds(220,330,150,25);
       add(source);
       
       JLabel lbldest=new JLabel("Destination");
       lbldest.setBounds(60,380,150,25);
       lbldest.setForeground(Color.BLACK);
       lbldest.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lbldest);
       
       dest=new Choice();
       dest.setBounds(220,380,150,25);
       add(dest);
       
       try{
       Conn c=new Conn();
       String query="select * from flight";
       ResultSet rs=c.s.executeQuery(query);
       
       while(rs.next()){
             source.add(rs.getString("source"));
             dest.add(rs.getString("destination"));
       }
       
       
       }catch(Exception e){
           e.printStackTrace(); 
       }
       
       fetchflights=new JButton("FetchFlights");
       fetchflights.setBounds(380,380,120,25);
       fetchflights.setBackground(Color.BLACK);
       fetchflights.setForeground(Color.WHITE);
       fetchflights.addActionListener(this);
       add(fetchflights);
       
       JButton save=new JButton ("Save");
       save.setBackground(Color.BLACK);
       save.setForeground(Color.WHITE);
       save.setBounds(220,380,150,30);
       save.addActionListener(this);
       add(save);
       
        lblfname=new JLabel("Flight Name");
       lblfname.setBounds(60,430,150,25);
       lblfname.setForeground(Color.BLACK);
       lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblfname);
       
       lblfname=new JLabel();
       lblfname.setBounds(220,430,150,25);
       add(lblfname);
       
       lblfcode=new JLabel("Flight Code");
       lblfcode.setBounds(60,480,150,25);
       lblfcode.setForeground(Color.BLACK);
       lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lblfcode);
       
       lblfcode=new JLabel();
       lblfcode.setBounds(220,480,150,25);
       add(lblfcode);
       

       JLabel lbldate=new JLabel("Date Of Travel");
       lbldate.setBounds(60,530,150,25);
       lbldate.setForeground(Color.BLACK);
       lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
       add(lbldate);
       
        dcdate=new JDateChooser();
       dcdate.setBounds(220,530,150,25);
       add(dcdate);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
       Image i2=i1.getImage().getScaledInstance(450,320,Image.SCALE_DEFAULT);
       ImageIcon lblimage=new ImageIcon(i2);
       JLabel labelimage=new JLabel(lblimage);
       labelimage.setBounds(550,80,500,410);
       add(labelimage);
       
        bookflight=new JButton("Book Flight");
       bookflight.setBackground(Color.BLACK);
       bookflight.setForeground(Color.WHITE);
       bookflight.setBounds(220,580,150,25);
       bookflight.addActionListener(this);
       add(bookflight);
       
        setSize(1100,800);
        setLocation(200,50);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchbutton){
        String aadhar =tfaadhar.getText();
        
        try{
        Conn c=new Conn();
        String query="select * from passenger where aadhar='"+aadhar+"'";
        ResultSet rs=c.s.executeQuery(query);
        if(rs.next()){
            tfname.setText(rs.getString("name"));
            tfnationality.setText(rs.getString("nationality"));
            tfaddress.setText(rs.getString("address"));
            tfgender.setText(rs.getString("gender"));
            
        }else{
        JOptionPane.showMessageDialog(null,"Please enter correct aadhar");
        }
        }catch(Exception e){
        e.printStackTrace();
        }
       } 
        else if(ae.getSource()==fetchflights){
       String src=source.getSelectedItem();
       String destination=dest.getSelectedItem();
       try{
       Conn c=new Conn();
       String query="select * from flight where source='"+src+"' and destination='"+destination+"'";
       ResultSet rs=c.s.executeQuery(query);
       if(rs.next()){
           lblfname.setText(rs.getString("f_name"));
           lblfcode.setText(rs.getString("f_code"));
       }else{
       JOptionPane.showMessageDialog(null, "No Flights Found");
       }
       }catch(Exception e){
       e.printStackTrace();
       }
       }
       else{
           Random random=new Random();
           String aadhar=tfaadhar.getText();
     String name=tfname.getText();
     String nationality=tfnationality.getText();
     String address=tfaddress.getText();
     String flightname=lblfname.getText();
     String flightcode=lblfcode.getText();
     String src=source.getSelectedItem();
     String destination=dest.getSelectedItem();
     String ddate=((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
     try{
       Conn c=new Conn();
       String query="insert into reservation values('PNR-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(10000)+"','"+aadhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+destination+"','"+ddate+"')";
       c.s.executeUpdate(query);

       JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
       setVisible(false);
       }catch(Exception e){
       e.printStackTrace();
       }
       }
    }
    public static void main(String args[]){
        new BookFlight();
    }
    
}

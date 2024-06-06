package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class AddCustomer extends JFrame implements ActionListener{
    JTextField tfname,tfnationality,tfaadhar,tfaddress,tfphone;
    JRadioButton rbmale,rbfemale;
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("Add Customer Details");
        heading.setBounds(220,30,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(60,80,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
         tfname=new JTextField ();
        tfname.setBounds(220,80,150,25);
        add(tfname);
        
        JLabel nationality=new JLabel("Nationality");
        nationality.setBounds(60,130,150,25);
        nationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(nationality);
        
         tfnationality=new JTextField();
        tfnationality.setBounds(220,130,150,25);
        add(tfnationality);
        
        JLabel aadhar=new JLabel("Aadhar No");
        aadhar.setBounds(60,180,150,25);
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(aadhar);
        
        tfaadhar =new JTextField();
        tfaadhar.setBounds(220,180,150,25);
        add(tfaadhar);
        
        JLabel address=new JLabel("Address");
        address.setBounds(60,230,150,25);
        address.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(address);
        
         tfaddress=new JTextField();
        tfaddress.setBounds(220,230,150,25);
        add(tfaddress);
        
        JLabel gender=new JLabel("Gender");
        gender.setBounds(60,280,150,25);
        gender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(gender);
        
        ButtonGroup gendergroup=new ButtonGroup();
        
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(220,280,70,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale =new JRadioButton("Female");
        rbfemale.setBounds(300,280,70,25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel phone=new JLabel("Phone");
        phone.setBounds(60,330,150,25);
        phone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(phone);
        
         tfphone=new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);
        
        JButton save=new JButton("Save");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        save.setBounds(220,380,150,30);
        add(save);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel image=new JLabel(i1);
        image.setBounds(450,80,200,400);
        add(image);
        
    setSize(900,600);
    setLocation(300,150);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name=tfname.getText();
        String nationality=tfnationality.getText();
        String aadhar=tfaadhar.getText();
        String phone=tfphone.getText();
        String address=tfaddress.getText();
        
        String gender=null;
        if(rbmale.isSelected()){
            gender="Male";
        }else{
            gender="Female";
        }
    try{
        Conn conn=new Conn();
        String query="insert into passenger values('"+name+"','"+nationality+"','"+aadhar+"','"+phone+"','"+address+"','"+gender+"')";
        conn.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
        setVisible(false);
    }catch(Exception e){
    e.printStackTrace();
    }
    }
    public static void main(String args[]){
        new AddCustomer();
    }
}

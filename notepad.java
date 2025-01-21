import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class notepad extends JFrame implements ActionListener{
JButton login, clear, signup;
JTextField cardtextfield;
JPasswordField pintextfield;

 notepad(){
setLayout(null);
ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank-icon.png"));
Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel label = new JLabel(i3);
label.setBounds(150, 10, 100, 100);
add(label);

JLabel text = new JLabel("Welcome to ATM!");
add(text);
text.setBounds(280,20,400,100);
text.setFont(new Font("Osward", Font.BOLD, 38));

JLabel cardno = new JLabel("Card No :");
cardno.setBounds(170,120,150,100);
cardno.setFont(new Font("Railway", Font.BOLD, 28));
add(cardno);

cardtextfield = new JTextField();
cardtextfield.setFont(new Font("Arial",Font.BOLD, 15));
cardtextfield.setBounds(320,150,250,40);
add(cardtextfield);

JLabel pin = new JLabel("Pin :");
add(pin);
pin.setBounds(170,170,400,100);
pin.setFont(new Font("Raleway", Font.BOLD, 28));

pintextfield = new JPasswordField();
cardtextfield.setFont(new Font("Arial",Font.BOLD, 15));
pintextfield.setBounds(320,200,250,40);
add(pintextfield);

login = new JButton("Sign in");
login.setBounds(320,270,120,30);
login.setBackground(Color.BLACK);
login.setForeground(Color.WHITE);
add(login);
login.addActionListener(this);

clear = new JButton("Clear");
clear.setBounds(450,270,120,30);
add(clear);
clear.addActionListener(this);

signup = new JButton("Sign up");
signup.setBounds(320,320,250,30);
add(signup);
signup.addActionListener(this);


getContentPane().setBackground(Color.WHITE); 

setTitle("Automated Teller Machine");
setSize(800,480);
setVisible(true);
setLocation(350,200);


}
@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent ae){
if(ae.getSource() == clear){
	cardtextfield.setText("");
	pintextfield.setText("");
   }else if(ae.getSource() == login){
      conn connect = new conn();
      String cardno = cardtextfield.getText();
      String pinno = pintextfield.getText();
      String query = "select * from login where cardno = '"+cardno+"' and pinno = '"+pinno+"'";
      try{
         ResultSet rs = connect.s.executeQuery(query);
         if(rs.next()){
            setVisible(false);
            new transactions(pinno).setVisible(true);;
         }else{
            JOptionPane.showMessageDialog(null,"Incorrect Card No or Pin");
         }
      }catch(Exception e){
         System.out.println(e);
      }
   }else if(ae.getSource() == signup){
      setVisible(false);
      new signup().setVisible(true);
   }
}
public static void main(String args[]){
new notepad();
}
}
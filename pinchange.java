import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class pinchange extends JFrame implements ActionListener{
    JButton back, change;
    JTextField pinTextField, repinTextField;
    static String pinno;
        pinchange(String pinno){
            pinchange.pinno=pinno;
            setSize(900,900);
            setLocation(300,0);
            setLayout(null);
            setTitle("Change Pin");
    
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);
            
            JLabel text = new JLabel("Change your pin");
            text.setBounds(275,300,400,50);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("System",Font.BOLD,13));
            image.add(text);
    
            JLabel pintext = new JLabel("New Pin:");
            pintext.setBounds(180,415,300,30);
            pintext.setForeground(Color.WHITE);
            pintext.setFont(new Font("System",Font.BOLD,15));
            image.add(pintext);
    
            JLabel repintext = new JLabel("Re-Enter New Pin:");
            repintext.setForeground(Color.WHITE);
            repintext.setFont(new Font("System",Font.BOLD,15));
            repintext.setBounds(180,450,300,30);
            image.add(repintext);
    
            pinTextField = new JTextField();
            pinTextField.setFont(new Font("System",Font.BOLD,15));
            pinTextField.setBounds(350,415,150,30);
            image.add(pinTextField);
    
            repinTextField = new JTextField();
            repinTextField.setFont(new Font("System",Font.BOLD,15));
            repinTextField.setBounds(350,450,150,30);
            image.add(repinTextField);
    
            change =  new JButton("Change");
            change.setBounds(350,485,150,30);
            change.addActionListener(this);
            image.add(change);
    
            back =  new JButton("Back");
            back.setBounds(350,520,150,30);
            back.addActionListener(this);
            image.add(back);
    
            setVisible(true);
        }
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==change){
            try {
            String npin = pinTextField.getText();
            String rpin = repinTextField.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered pin does not match");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter New Pin");
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Re-enter New Pin");
            }
            conn c = new conn();
            String q1 = "update signup3 set pinno= '"+rpin+"' where pinno= '"+pinno+"'";
            String q2 = "update login set pinno = '"+rpin+"' where pinno = '"+pinno+"'";
            String q3 = "update bank set pinno = '"+rpin+"' where pinno = '"+pinno+"'";
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);
                JOptionPane.showMessageDialog(null,"Pin changed successfully");
                setVisible(false);
                new transactions(pinno).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource()== back){
            setVisible(false);
            new transactions(pinno).setVisible(true);
        }
    }
    public static void main(String[] args) {
            new pinchange(pinno);
}
}
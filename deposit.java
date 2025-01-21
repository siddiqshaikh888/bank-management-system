import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class deposit extends JFrame implements ActionListener{
    JButton deposit, back;
    JTextField depositAmount;
    String pinno;
    deposit(String pinno){
        this.pinno=pinno;
        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        setTitle("Deposit");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(200,300,400,50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        image.add(text);

        depositAmount = new JTextField();
        depositAmount.setFont(new Font("Raleway",Font.BOLD, 15));
        depositAmount.setBounds(180,350,300,30);
        image.add(depositAmount);

        deposit =  new JButton("Deposit");
        deposit.addActionListener(this);
        deposit.setBounds(355,485,150,30);
        image.add(deposit);

        back =  new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String number = depositAmount.getText();
            Date date = new Date();
            
            if(number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount to deposit");
            } else {
                try {
                    conn cn1 = new conn();
                    String q1 = "insert into bank values('"+pinno+"', '"+date+"', 'Deposit' , '"+number+"')";
                    
                    cn1.s.executeUpdate(q1);
                    
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                    setVisible(false);
                    new transactions(pinno).setVisible(true);
                    
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Error processing deposit. Please try again.");
                }
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new transactions(pinno).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new deposit("");
    }
}
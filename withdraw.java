import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
public class withdraw extends JFrame implements ActionListener{
    JButton withdraw, back;
    JTextField withdrawAmount;
    String pinno;
    withdraw(String pinno){
        this.pinno=pinno;
        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        setTitle("Withdrawl");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(200,300,400,50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        image.add(text);

        withdrawAmount = new JTextField();
        withdrawAmount.setFont(new Font("Raleway",Font.BOLD, 15));
        withdrawAmount.setBounds(180,350,300,30);
        image.add(withdrawAmount);

        withdraw =  new JButton("withdraw");
        withdraw.addActionListener(this);
        withdraw.setBounds(355,485,150,30);
        image.add(withdraw);

        back =  new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == withdraw) {
                String number = withdrawAmount.getText();  // Assuming withdrawAmount is a JTextField
                Date date = new Date();
                
                // Check if the withdraw amount is empty or invalid
                if (number.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Invalid amount selected. Please try again.");
                    return;
                }
                
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pinno = '" + pinno + "'");
                int balance = 0;
                
                // Calculate the balance from the database
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                // Check if balance is sufficient for the withdrawal
                if (balance < Integer.parseInt(number)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
    
                // Insert the withdrawal transaction into the database
                conn cn1 = new conn();
                String q1 = "insert into bank values('" + pinno + "', '" + date + "', 'Withdrawl', '" + number + "')";
                cn1.s.executeUpdate(q1);
                
                // Show success message
                JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawn Successfully");
                
                // Navigate to the transactions screen
                setVisible(false);
                new transactions(pinno).setVisible(true);
            }
            else if (ae.getSource() == back) {
                setVisible(false);
                new transactions(pinno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error processing withdrawal. Please try again.");
        }
    }
    
    
    public static void main(String[] args) {
        new withdraw("");
    }
}
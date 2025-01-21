import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class miniStatement extends JFrame implements ActionListener {
    JLabel l1;
    JButton back;

    miniStatement(String pinno) {
        setSize(400, 600);
        setLocation(600, 100);
        setLayout(null);
        setTitle("Mini Statement");

        JLabel bankName = new JLabel("Bank of India");
        bankName.setBounds(135, 20, 300, 30);
        bankName.setFont(new Font("System", Font.BOLD, 20));
        add(bankName);

        JLabel miniName = new JLabel("Mini Statement");
        miniName.setBounds(150, 50, 300, 30);
        miniName.setFont(new Font("System", Font.BOLD, 13));
        add(miniName);

        JLabel card = new JLabel();
        card.setBounds(100, 100, 300, 30);
        card.setFont(new Font("System", Font.BOLD, 13));
        add(card);

        // Adding a back button to return to previous screen
        back = new JButton("Back");
        back.setBounds(150, 520, 100, 30);
        back.addActionListener(this);
        add(back);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        l1 = new JLabel();
        l1.setBounds(20, 130, 350, 250); // Adjusted bounds for readability
        l1.setFont(new Font("System", Font.PLAIN, 12));
        add(l1);

        // Fetching Card Number
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinno = '" + pinno + "'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching card details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Fetching and displaying transaction details
        try {
            int balance = 0;
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank WHERE pinno = '" + pinno + "'");

            StringBuilder statement = new StringBuilder("<html>");
            while (rs.next()) {
                statement.append(rs.getString("date")).append("   ")
                        .append(rs.getString("type")).append("   ")
                        .append(rs.getString("amount")).append("<br><br>");
                int amount = Integer.parseInt(rs.getString("amount"));
                if (rs.getString("type").equals("Deposit")) {
                    balance += amount;
                } else {
                    balance -= amount;
                }
            }
            statement.append("</html>");
            l1.setText(statement.toString());
            l4.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching transactions: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new miniStatement("1234");  // Example pin number; replace with actual pin
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            // Assuming there's a class `transactions` that displays transaction details
            new transactions("").setVisible(true);
        }
    }
}

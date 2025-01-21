import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
public class balanceCheck extends JFrame implements ActionListener{
    JButton back;
    String pinno;
        balanceCheck(String pinno){
            this.pinno=pinno;
            setSize(900,900);
            setLocation(300,0);
            setLayout(null);
            setTitle("Balance Enquiry");
    
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);

        back =  new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        conn c = new conn();
        int balance = 0;
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pinno = '"+pinno+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }

        JLabel balanceText = new JLabel("Your Current Account Balance is Rs " + balance);
        balanceText.setBounds(190, 350, 400, 35);
        balanceText.setFont(new Font("System", Font.BOLD, 16));
        balanceText.setForeground(Color.WHITE);
        image.add(balanceText);

        setVisible(true);
    }
public static void main(String[] args) {
    new balanceCheck("");
}
@Override
public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==back){
        setVisible(false);
        new transactions(pinno).setVisible(true);
    }
}
}
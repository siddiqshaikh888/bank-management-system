import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class transactions extends JFrame implements ActionListener{
    JButton withdrawl, deposit, ministatement, exit, fastcash, pinchange, balanceEnquiry;
    String pinno;
    transactions(String pinno){
        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        setTitle("Transactions");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(250,300,400,50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        image.add(text);

        deposit =  new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl =  new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        ministatement =  new JButton("Mini Statement");
        ministatement.setBounds(170,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        fastcash =  new JButton("Fast Cash");
        fastcash.setBounds(355,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        pinchange =  new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceEnquiry =  new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,485,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit =  new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new deposit(pinno).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new withdraw(pinno).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new fastcash(pinno).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new pinchange(pinno).setVisible(true);
        }else if(ae.getSource()==balanceEnquiry){
            setVisible(false);
            new balanceCheck(pinno).setVisible(true);
        }else if(ae.getSource()==ministatement){
            setVisible(false);
            new miniStatement(pinno).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new transactions("");
    }
}
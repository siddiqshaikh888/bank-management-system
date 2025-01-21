import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class signup3 extends JFrame implements ActionListener{
    JLabel atype, cardnoLabel, card, d16, pin, pinnoLabel,p4;
    JRadioButton r1, r2, r3, r4;
    JCheckBox s1,s2,s3,s4,s5,s6,cc;
    JButton submit, cancel;
    String formno, pinno;
    signup3(String pinno){
        this.pinno=pinno;
        setSize(840,800);
        setLocation(350,50);
        setLayout(null);
        setTitle("Account Detais - Page 3");
        getContentPane().setBackground(Color.WHITE);

        JLabel pd = new JLabel("Page 3: Account Details");
        pd.setBounds(300, 0, 400, 50);
        pd.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pd);

        atype = new JLabel("Account Type");
        atype.setBounds(100,50,400,40);
        atype.setFont(new Font("Raleway", Font.BOLD, 20));
        add(atype);
 
        r1 = new JRadioButton("Savings Account");
        atype.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,100,200,40);
        add(r1);
        r2 = new JRadioButton("Current Account");
        r2.setBackground(Color.WHITE);
        r2.setBounds(400,100,200,40);
        add(r2);
        r3 = new JRadioButton("Recurring Deposit Account");
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,150,200,40);
        add(r3);
        r4 = new JRadioButton("Fix Deposit Account");
        r4.setBackground(Color.WHITE);
        r4.setBounds(400,150,200,40);
        add(r4);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(r1);
        radioGroup.add(r2);
        radioGroup.add(r3);
        radioGroup.add(r4);

        card = new JLabel("Card Number:");
        card.setBounds(100, 250, 400, 40);
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        add(card);

        cardnoLabel = new JLabel("XXXX-XXXX-XXXX-9604");
        cardnoLabel.setBounds(350, 250, 400, 40);
        cardnoLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(cardnoLabel);

        d16 = new JLabel("Your 16 Digit Card Number");
        d16.setBounds(100, 270, 400, 40);
        d16.setFont(new Font("Raleway", Font.BOLD, 12));
        add(d16);

        pin = new JLabel("Pin:");
        pin.setBounds(100, 350, 400, 40);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pin);

        pinnoLabel = new JLabel("XXXX");
        pinnoLabel.setBounds(350, 350, 400, 40);
        pinnoLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pinnoLabel);

        p4 = new JLabel("Your 4 Digit Password");
        p4.setBounds(100, 370, 400, 40);
        p4.setFont(new Font("Raleway", Font.BOLD, 12));
        add(p4);

        atype = new JLabel("Services Required:");
        atype.setBounds(100,450,400,40);
        atype.setFont(new Font("Raleway", Font.BOLD, 20));
        add(atype);
 
        s1 = new JCheckBox("ATM Card");
        atype.setFont(new Font("Raleway", Font.BOLD, 16));
        s1.setBackground(Color.WHITE);
        s1.setBounds(100,500,200,40);
        add(s1);
        s2 = new JCheckBox("Internet Banking");
        s2.setBackground(Color.WHITE);
        s2.setBounds(400,500,200,40);
        add(s2);
        s3 = new JCheckBox("Mobile Banking");
        s3.setBackground(Color.WHITE);
        s3.setBounds(100,550,200,40);
        add(s3);
        s4 = new JCheckBox("Email & SMS Alert");
        s4.setBackground(Color.WHITE);
        s4.setBounds(400,550,200,40);
        add(s4);
        s5 = new JCheckBox("Cheque Book");
        s5.setBackground(Color.WHITE);
        s5.setBounds(100,600,200,40);
        add(s5);
        s6 = new JCheckBox("E-Statement");
        s6.setBackground(Color.WHITE);
        s6.setBounds(400,600,200,40);
        add(s6);

        cc = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge");
        cc.setBounds(100,650,700,40);
        cc.setBackground(Color.WHITE);
        cc.setFont(new Font("Raleway", Font.BOLD, 10));
        add(cc);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250,700,100,40);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(450,700,100,40);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String atype = null;
            if(r1.isSelected()){
                atype = "Savings Account";
            }
            if(r2.isSelected()){
                atype = "Current Account";
            }
            if(r3.isSelected()){
                atype = "Recurring Deposit Account";
            }
            if(r4.isSelected()){
                atype = "Fixed Deposit Account";
            }

            Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

            String facility = "";
            if(s1.isSelected()){
                facility = facility + "ATM Card";
            }else if(s2.isSelected()){
                facility = facility + "Internet Banking";
            }else if(s3.isSelected()){
                facility = facility + "Mobile Banking";
            }else if(s4.isSelected()){
                facility = facility + "Email Alert";
            }else if(s5.isSelected()){
                facility = facility + "Cheque Book";
            }else if(s6.isSelected()){
                facility = facility + "E-Statement";
            }

            try{
                if(atype.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Account type requires");
                }else{
                    conn cn = new conn();
                    String query = "insert into signup3 values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    cn.s.executeUpdate(query);
                    cn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card no: "+cardno+"\n Pin: "+pin);
                    setVisible(false);
                    new notepad().setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource() == cancel){
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new signup3("");
    }
}

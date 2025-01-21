import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signup2 extends JFrame implements ActionListener{

    JTextField adhaarField, panField;
    JButton submitButton;
    JRadioButton yes2, no2, yes, no;
    String formno;
    @SuppressWarnings({ "rawtypes" })
    JComboBox religiontextfield, categorytextfield, incometextfield, edutextfield, ocutextfield;
    @SuppressWarnings({ "rawtypes", "unchecked" })
    signup2(String formno) {
        this.formno=formno;
        // Frame settings
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 50);
        setTitle("New Account Application Form - Page 2");

        JLabel pd = new JLabel("Page 2: Additional Details");
        pd.setBounds(300, 50, 400, 50);
        pd.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pd);

        JLabel religion = new JLabel("Religion:");
        religion.setBounds(100, 150, 200, 30);
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        add(religion);
        
        String valreligion[] = {"Muslim","Hindu","Christian","sikh","Others"};
        religiontextfield = new JComboBox(valreligion);
        religiontextfield.setBackground(Color.WHITE);
        religiontextfield.setBounds(300, 150, 400, 30);
        add(religiontextfield);

        JLabel lname = new JLabel("Category:");
        lname.setBounds(100, 200, 200, 30);
        lname.setFont(new Font("Raleway", Font.BOLD, 20));
        add(lname);

        String valcategory[] = {"General","OBC","ST","SC","Others"};
        categorytextfield = new JComboBox(valcategory);
        categorytextfield.setBackground(Color.WHITE);
        categorytextfield.setBounds(300, 200, 400, 30);
        add(categorytextfield);

        JLabel dob = new JLabel("Income:");
        dob.setBounds(100, 250, 200, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dob);
	 
        String valincome[] = {"null","< 1,00,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
        incometextfield = new JComboBox(valincome);
        incometextfield.setBackground(Color.WHITE);
        incometextfield.setBounds(300, 250, 400, 30);
        add(incometextfield);

        JLabel edu = new JLabel("Education:");
        edu.setBounds(100, 300, 200, 30);
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        add(edu);

        String valedu[] = {"non-graduation","Graduate","Post Graduation","Doctrate","PHD"};
        edutextfield = new JComboBox(valedu);
        edutextfield.setBackground(Color.WHITE);
        edutextfield.setBounds(300, 300, 400, 30);
        add(edutextfield);


        JLabel ocu = new JLabel("Occupation:");
        ocu.setBounds(100, 350, 200, 30);
        ocu.setFont(new Font("Raleway", Font.BOLD, 20));
        add(ocu);

        String valocu[] = {"Salarised","Self-employed","Business","Student","Retired"};
        ocutextfield = new JComboBox(valocu);
        ocutextfield.setBackground(Color.WHITE);
        ocutextfield.setBounds(300, 350, 400, 30);
        add(ocutextfield);

        JLabel pan = new JLabel("PAN Number:");
        pan.setBounds(100, 400, 200, 30);
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pan);

        panField = new JTextField();
        panField.setBounds(300, 400, 400, 30);
        add(panField);

        JLabel adhaar = new JLabel("Adhaar Number:");
        adhaar.setBounds(100, 450, 200, 30);
        adhaar.setFont(new Font("Raleway", Font.BOLD, 20));
        add(adhaar);

        adhaarField = new JTextField();
        adhaarField.setBounds(300, 450, 400, 30);
        add(adhaarField);

        JLabel sc = new JLabel("Senior Citizen:");
        sc.setBounds(100, 500, 200, 30);
        sc.setFont(new Font("Raleway", Font.BOLD, 20));
        add(sc);

        yes = new JRadioButton("Yes");
        yes.setBounds(300, 500, 100, 30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("no");
        no.setBounds(400, 500, 100, 30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup scGroup = new ButtonGroup();
        scGroup.add(yes);
        scGroup.add(no);

        JLabel ea = new JLabel("Exisiting Account");
        ea.setBounds(100, 550, 200, 30);
        ea.setFont(new Font("Raleway", Font.BOLD, 20));
        add(ea);

        yes2 = new JRadioButton("Yes");
        yes2.setBounds(300, 550, 100, 30);
        yes2.setBackground(Color.WHITE);
        add(yes2);

        no2 = new JRadioButton("no");
        no2.setBounds(400, 550, 100, 30);
        no2.setBackground(Color.WHITE);
        add(no2);

        ButtonGroup eaGroup = new ButtonGroup();
        eaGroup.add(yes2);
        eaGroup.add(no2);
        

        submitButton = new JButton("Submit");
        submitButton.setBounds(350, 650, 150, 40);
        submitButton.setFont(new Font("Raleway", Font.BOLD, 20));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);


    }
public void actionPerformed(ActionEvent ae){
    String sreligion = (String) religiontextfield.getSelectedItem();
    String scategory = (String) categorytextfield.getSelectedItem();
    String sedu = (String) edutextfield.getSelectedItem();
    String socu = (String) ocutextfield.getSelectedItem();
    String sincome  = (String) incometextfield.getSelectedItem();
    String pan  = panField.getText();
    String adhaar  = adhaarField.getText();
    String sc = null;
    if(yes.isSelected()){
        sc = "Yes";
    }else if(no.isSelected()){
        sc = "No";
    }
    String ea = null;
    if(yes2.isSelected()){
        ea = "yes";
    }else if(no2.isSelected()){
        ea = "no";
    }

    try{
        if(pan.equals("")){
            JOptionPane.showMessageDialog(null, "PAN is required");
        }else{
            conn c = new conn();
            String query = "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+sedu+"','"+socu+"','"+pan+"','"+adhaar+"','"+sc+"','"+ea+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new signup3(formno).setVisible(true);
        }
    }catch(Exception e){
        System.out.println(e);
    }
}
    public static void main(String[] args) {
        new signup2("");
    }
}

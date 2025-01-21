import java.util.*;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener{

    long random;
    JTextField nametextfield, lasttextfield, emailField, addressField,cityField,stateField,pincodeField;
    JDateChooser datechooser;
    JButton submitButton;
    JRadioButton male, female, single, married;
    signup() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 50);
        setTitle("Signup");

        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application Form No : " + random);
        formno.setBounds(230, 0, 500, 50);
        formno.setFont(new Font("Raleway", Font.BOLD, 30));
        add(formno);

        JLabel pd = new JLabel("Page 1: Personal Details");
        pd.setBounds(300, 50, 400, 50);
        pd.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pd);

        JLabel name = new JLabel("First Name:");
        name.setBounds(100, 150, 200, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        add(name);
        
        nametextfield = new JTextField();
        nametextfield.setBounds(300, 150, 400, 30);
        add(nametextfield);

        JLabel lname = new JLabel("Last Name:");
        lname.setBounds(100, 200, 200, 30);
        lname.setFont(new Font("Raleway", Font.BOLD, 20));
        add(lname);

        lasttextfield = new JTextField();
        lasttextfield.setBounds(300, 200, 400, 30);
        add(lasttextfield);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(100, 250, 200, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dob);
	 
        datechooser = new JDateChooser();
        datechooser.setBounds(300,250,400,30);
        add(datechooser);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100, 300, 200, 30);
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 300, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 300, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email:");
        email.setBounds(100, 350, 200, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        add(email);

        emailField = new JTextField();
        emailField.setBounds(300, 350, 400, 30);
        add(emailField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(100, 400, 200, 30);
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        add(marital);

        single = new JRadioButton("Single");
        single.setBounds(300, 400, 100, 30);
        single.setBackground(Color.WHITE);
        add(single);

        married = new JRadioButton("Married");
        married.setBounds(400, 400, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(single);
        maritalGroup.add(married);

        JLabel address = new JLabel("Address:");
        address.setBounds(100, 450, 200, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        add(address);

        addressField = new JTextField();
        addressField.setBounds(300, 450, 400, 30);
        add(addressField);

        JLabel city = new JLabel("City:");
        city.setBounds(100, 500, 200, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        add(city);

        cityField = new JTextField();
        cityField.setBounds(300, 500, 400, 30);
        add(cityField);

        JLabel state = new JLabel("State:");
        state.setBounds(100, 550, 200, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        add(state);

        stateField = new JTextField();
        stateField.setBounds(300, 550, 400, 30);
        add(stateField);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setBounds(100, 600, 200, 30);
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pincode);

        pincodeField = new JTextField();
        pincodeField.setBounds(300, 600, 400, 30);
        add(pincodeField);

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
    String formno = ""+random;
    String name = nametextfield.getText();
    String lname = lasttextfield.getText();
    String dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
    String gender = null;
    if(male.isSelected()){
        gender = "Male";
    }else if(female.isSelected()){
        gender = "Female";
    }
    String email = emailField.getText();
    String marital = null;
    if(single.isSelected()){
        marital = "Single";
    }else if(married.isSelected()){
        marital = "Married";
    }
    String address = addressField.getText();
    String city = cityField.getText();
    String state = stateField.getText();
    String pincode = pincodeField.getText();

    try{
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "name is required");
        }else{
            conn c = new conn();
            String query = "insert into signup values('"+formno+"','"+name+"','"+lname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new signup2(formno).setVisible(true);
        }
    }catch(Exception e){
        System.out.println(e);
    }
}
    public static void main(String[] args) {
        new signup();
    }
}

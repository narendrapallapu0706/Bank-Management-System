
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.text.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox<String> religion, category, occupation, education, income;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 200, 30);
        add(name);

        String valReligion[] = { "Hindu", "Muslim", "Christian", "Sikh", "Other" };
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valcategory[] = { "OC", "OBC", "SC", "ST", "Others" };
        category = new JComboBox<>(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String incomecategory[] = {  "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000" };
        income = new JComboBox<>(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String educationalValues[] = {  "Non-Graduate", "Graduate", "Post-Graduate", "Others" };
        education = new JComboBox<>(educationalValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100, 365, 200, 30);
        add(marital);

        String occupationValues[] = { "Employee", "Business", "Student", "Others" };
        occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300, 365, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 415, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.PLAIN, 20));
        pan.setBounds(300, 415, 400, 30);
        add(pan);
        limitTextField(pan, 10, false); 

        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 465, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.PLAIN, 20));
        aadhar.setBounds(300, 465, 400, 30);
        add(aadhar);
        limitTextField(aadhar, 16, true); 

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 515, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 515, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(420, 515, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 565, 200, 30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 565, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(420, 565, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBounds(600, 620, 100, 40);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 750);
        setLocation(350, 50);
        setVisible(true);
    }

   
    private void limitTextField(JTextField field, int maxLength, boolean digitsOnly) {
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
           
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                String current = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = current.substring(0, offset) + text + current.substring(offset + length);
                if (newText.length() <= maxLength) {
                    if (digitsOnly && !text.matches("\\d*")) return;
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (text == null) 
                    return;
                String current = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = current.substring(0, offset) + text + current.substring(offset);
                if (newText.length() <= maxLength) {
                    if (digitsOnly && !text.matches("\\d*"))
                        return; 
                    super.insertString(fb, offset, text, attrs);
                }
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = syes.isSelected() ? "Yes" : sno.isSelected() ? "No" : null;
        String existingaccount = eyes.isSelected() ? "Yes" : eno.isSelected() ? "No" : null;

        String span = pan.getText().trim();
        String saadhar = aadhar.getText().trim();

        try {
         
            if (sreligion.equals("Select"))
                JOptionPane.showMessageDialog(null, "Please select Religion");
            else if (scategory.equals("Select"))
                JOptionPane.showMessageDialog(null, "Please select Category");
            else if (sincome.equals("Select"))
                JOptionPane.showMessageDialog(null, "Please select Income");
            else if (seducation.equals("Select"))
                JOptionPane.showMessageDialog(null, "Please select Education Qualification");
            else if (soccupation.equals("Select"))
                JOptionPane.showMessageDialog(null, "Please select Occupation");
            else if (span.equals(""))
                JOptionPane.showMessageDialog(null, "PAN Number is required");
            else if (!span.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}"))
                JOptionPane.showMessageDialog(null, "Invalid PAN format! (e.g., ABCDE1234F)");
            else if (saadhar.equals(""))
                JOptionPane.showMessageDialog(null, "Aadhar Number is required");
            else if (!saadhar.matches("\\d{12}"))
                JOptionPane.showMessageDialog(null, "Aadhar Number must be exactly 12 digits");
            else if (seniorcitizen == null)
                JOptionPane.showMessageDialog(null, "Please select Senior Citizen option");
            else if (existingaccount == null)
                JOptionPane.showMessageDialog(null, "Please select Existing Account option");
            else {
                // ✅ All validations passed
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','"
                        + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','"
                        + seniorcitizen + "','" + existingaccount + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Details saved successfully!");
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}

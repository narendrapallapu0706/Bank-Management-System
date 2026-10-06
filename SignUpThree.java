
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    JLabel number, pnumber;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 26));
        l1.setBounds(260, 40, 400, 40);
        add(l1);

       
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 120, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");

        JRadioButton[] radioButtons = {r1, r2, r3, r4};
        int y = 160;
        for (JRadioButton r : radioButtons) {
            r.setFont(new Font("Raleway", Font.PLAIN, 16));
            r.setBackground(Color.WHITE);
            r.setBounds((r == r1 || r == r3) ? 100 : 350, y, 250, 30);
            add(r);
            if (r == r2)
                y += 40;
        }

        ButtonGroup groupaccount = new ButtonGroup();
        for (JRadioButton r : radioButtons) groupaccount.add(r);

        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 260, 200, 30);
        add(card);

        number = new JLabel("XXXX-XXXX-XXXX-XXXX");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 260, 350, 30);
        add(number);

        JLabel carddetail = new JLabel("Your 16 Digit Card Number (will be auto-generated)");
        carddetail.setFont(new Font("Raleway", Font.PLAIN, 12));
        carddetail.setBounds(100, 290, 400, 20);
        add(carddetail);

       
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 330, 200, 30);
        add(pin);

        pnumber = new JLabel("****");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 330, 200, 30);
        add(pnumber);

        JLabel pindetail = new JLabel("Your 4 Digit PIN (will be auto-generated)");
        pindetail.setFont(new Font("Raleway", Font.PLAIN, 12));
        pindetail.setBounds(100, 360, 300, 20);
        add(pindetail);

        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 400, 300, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");

        JCheckBox[] checkBoxes = {c1, c2, c3, c4, c5, c6};
        int yC = 440;
        for (int i = 0; i < checkBoxes.length; i++) {
            JCheckBox c = checkBoxes[i];
            c.setFont(new Font("Raleway", Font.PLAIN, 16));
            c.setBackground(Color.WHITE);
            c.setBounds((i % 2 == 0) ? 100 : 350, yC, 250, 30);
            add(c);
            if (i % 2 != 0) yC += 40;
        }

        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.PLAIN, 12));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100, 570, 650, 30);
        add(c7);

        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 630, 120, 35);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 630, 120, 35);
        cancel.addActionListener(this);
        add(cancel);

       
        c7.addActionListener(e -> submit.setEnabled(c7.isSelected()));

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 750);
        setLocation(350, 30);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) accountType = "Saving Account";
            else if (r2.isSelected()) accountType = "Fixed Deposit Account";
            else if (r3.isSelected()) accountType = "Current Account";
            else if (r4.isSelected()) accountType = "Recurring Deposit Account";

            Random random = new Random();

            
            long base = 1000000000000000L;
            long randomPart = (long)(random.nextDouble() * 9000000000000000L);
            String cardnumber = String.valueOf(base + randomPart);

           
            String formattedFullCard = cardnumber.replaceAll("(.{4})", "$1-").replaceAll("-$", "");

           
            String last4 = cardnumber.substring(cardnumber.length() - 4);
            String maskedCard = "XXXX-XXXX-XXXX-" + last4;

        
            String pinnumber = String.format("%04d", random.nextInt(10000));

            String facility = "";
            if (c1.isSelected()) facility += " ATM CARD";
            if (c2.isSelected()) facility += " Internet Banking";
            if (c3.isSelected()) facility += " Mobile Banking";
            if (c4.isSelected()) facility += " EMAIL & SMS Alerts";
            if (c5.isSelected()) facility += " Cheque Book";
            if (c6.isSelected()) facility += " E-Statement";

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                } else {
                   
                    number.setText(maskedCard);
                    pnumber.setText("****");

                   
                    Conn conn = new Conn();

                  
                    String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";

                    
                    String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                 
                    JOptionPane.showMessageDialog(
                        null,
                        "✅ Account Created Successfully!\n\nCard Number: " + formattedFullCard + "\nPIN: " + pinnumber,
                        "Account Created",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                    setVisible(false);
                    new Login().setVisible(true);
                    new Deposit(pinnumber).setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel?", "Confirm Cancel", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                setVisible(false);
                new Login().setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}

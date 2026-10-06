
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("DAN Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel("Mini Statement");
        card.setBounds(20, 80, 300, 20);
        add(card);
        
   
        back = new JButton("BACK");
        back.setBounds(140, 500, 100, 30);
        back.addActionListener(this);
        add(back);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + 
                             "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            StringBuilder statementText = new StringBuilder("<html>");
            while (rs.next()) {
                statementText.append(rs.getString("date"))
                             .append("&nbsp;&nbsp;&nbsp;")
                             .append(rs.getString("type"))
                             .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                             .append(rs.getString("amount"))
                             .append("<br><br>");
            }
            statementText.append("</html>");
            mini.setText(statementText.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        mini.setBounds(20, 140, 400, 300);
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new MiniStatement("");
    }
}

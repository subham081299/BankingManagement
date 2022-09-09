package DB_Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class MiniStatement extends  JFrame  implements  ActionListener
{
    JLabel l1,bank,l3,l4;
    JButton exit;
    String pin;
    MiniStatement(String pin)
    {
        setTitle("MiniStatement");
        setLayout(null);
        this.pin = pin;

        l1 = new JLabel();
        add(l1);

        bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){}

        try{
            int bal = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("mode").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+bal);
        }catch(Exception e){
            e.printStackTrace();
        }

        setLayout(null);
        exit = new JButton("Exit");
        exit.setBounds(20, 500, 100, 25);
        exit.addActionListener(this);
        add(exit);



        l1.setBounds(20, 140, 400, 200);


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);

    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}

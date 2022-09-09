package DB_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;


public class PinChange extends JFrame implements ActionListener {
    String pin;
    JPasswordField pintxt , repintxt;
    JButton change , back;
    PinChange(String pin)
    {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("DB_Project/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Change your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pintext = new JLabel("NEW PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

        pintxt = new JPasswordField();
        pintxt.setFont(new Font("Raleway",Font.BOLD,25));
        pintxt.setBounds(330,320,180,25);
        image.add(pintxt);

        JLabel repintext = new JLabel("Re Enter NEW PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);

        repintxt = new JPasswordField();
        repintxt.setFont(new Font("Raleway",Font.BOLD,25));
        repintxt.setBounds(330,360,180,25);
        image.add(repintxt);

        change = new JButton("Change");
        change.setBounds(355 , 485 ,150 ,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355 , 520 ,150 ,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }else{
            try {
                String newpin = pintxt.getText();
                String rpin = repintxt.getText();

                if(!newpin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered Pin doesn't match");
                    return;
                }
                if(newpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter PIN");
                    return;
                }
                if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter Re-PIN");
                    return;
                }
                Conn conn = new Conn();
                String q1 = "update bank set pin ='"+rpin+"' where pin = '"+pin+"'";
                String q2 = "update login set pin ='"+rpin+"' where pin = '"+pin+"'";
                String q3 = "update signupThree set pin ='"+rpin+"' where pin = '"+pin+"'";
                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"Pin Change Successful");
                setVisible(false);
                new Transaction(rpin).setVisible(true);

            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}

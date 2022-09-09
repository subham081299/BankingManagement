package DB_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Withdraw extends JFrame implements ActionListener {
    JButton withdraw , back;
    JTextField amount;
    String pin;
    Withdraw(String pin)
    {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("DB_Project/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD , 16));
        amount.setBounds(170,350 , 320 ,20);
        image.add(amount);


        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355 , 485 , 150 ,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355 , 520 , 150 ,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == withdraw)
        {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter the amount you want to withdraw");
            }else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pin+"' , '"+date+"' , 'Withdrawl' , '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs"+number+"Withdrawn Successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }catch (Exception e)
                {
                    System.out.println(e);
                }

            }
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdraw("");
    }
}

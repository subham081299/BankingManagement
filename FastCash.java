package DB_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import  java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit , withdrawl , fastcash , ministatement , pincange , balance ,exit;
    String pin;
    FastCash (String pin)
    {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("DB_Project/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel txt = new JLabel("SELECT WITHDRAWL AMOUNT");
        txt.setBounds(210,300,700,35);
        txt.setForeground(Color.ORANGE);
        txt.setFont(new Font("System",Font.BOLD,16));
        image.add(txt);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pincange = new JButton("Rs 5000");
        pincange.setBounds(170,485,150,30);
        pincange.addActionListener(this);
        image.add(pincange);

        balance = new JButton("Rs 10000");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(355,520,150,20);
        exit.setBackground(Color.YELLOW);
        exit.setForeground(Color.RED);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);//always in the end
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while (rs.next())
                {
                   if(rs.getString("type").equals("Deposit"))
                   {
                       balance+= Integer.parseInt(rs.getString("amount"));
                   }
                   else{
                       balance-= Integer.parseInt(rs.getString("amount"));
                   }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pin+"' , '"+date+"' , 'Withdrawl' , '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs"+amount+ " Debitted Succesfully");
                setVisible(false);
                new Transaction(pin).setVisible(true);
            }catch (Exception e)
            {
                System.out.println(e);
            }

        }
    }
    public static void main(String[] args) {
        new FastCash ("");
    }
}

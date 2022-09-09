package DB_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
JButton deposit , withdrawl , fastcash , ministatement , pincange , balance ,exit;
String pin;
    Transaction(String pin)
    {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("DB_Project/images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel txt = new JLabel("Please select your Transaction");
        txt.setBounds(210,300,700,35);
        txt.setForeground(Color.ORANGE);
        txt.setFont(new Font("System",Font.BOLD,16));
        image.add(txt);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdraw");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pincange = new JButton("Pin Change");
        pincange.setBounds(170,485,150,30);
        pincange.addActionListener(this);
        image.add(pincange);

        balance = new JButton("Balance enquiry");
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
            System.exit(0);
        }
        else if(ae.getSource() == deposit)
        {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdraw(pin).setVisible(true);
        }else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource() == pincange)
        {
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }
        else if(ae.getSource() == balance)
        {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if(ae.getSource() == ministatement)
        {
            new MiniStatement(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
    }
}

package DB_Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import  javax.swing.*;

public class Login extends JFrame implements ActionListener {
JButton signin,signup,clear;
JTextField cardnumTextField;
JPasswordField pinTextField;
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);
        //now lets add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("DB_Project/images/logo.jpg"));
        //now scale the image
        Image i2 = i1.getImage().getScaledInstance(100 , 100 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3); // place the image
        label.setBounds(70,20,100,100);
        add(label);

        //add text before the image
        //-----------------------------------------WELCOME--------------------------------------------------------------
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD ,40));
        text.setBounds(200,40,400,40);
        add(text);

        //------------------------------------------Card Number---------------------------------------------------------
        JLabel cno = new JLabel("Card No. : ");
        cno.setFont(new Font("Raleway",Font.BOLD ,28));
        cno.setBounds(120,150,250,28);
        add(cno);

        //________________________________________Text Box Before Card Number___________________________________________
        cardnumTextField = new JTextField();
        cardnumTextField.setBounds(300,150,250,28);
        add(cardnumTextField);

        //-----------------------------------------Pin Number-----------------------------------------------------------
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway",Font.BOLD ,28));
        pin.setBounds(120,225,250,28);
        add(pin);

        //___________________________________PIN Box Before Card Number_________________________________________________
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,225,250,28);
        add(pinTextField);

        //-----------------------------------BUTTONS--------------------------------------------------------------------

        signin = new JButton("SIGN IN");
        signin.setBounds(300 , 300,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.ORANGE);
        signin.addActionListener(this);
        add(signin);


        signup = new JButton("SIGN UP");
        signup.setBounds(450 , 300,100,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.ORANGE);
        signup.addActionListener(this);
        add(signup);

        clear = new JButton("CLEAR");
        clear.setBounds(300 , 360,244,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.ORANGE);
        clear.addActionListener(this);
        add(clear);




        //--------------------------------------------Frame-------------------------------------------------------------

        getContentPane().setBackground(Color.white);
        setSize(800 , 480); // setSize is used to set the size of the framework
        setVisible(true); // by default the visibility is hidden ie false , so in order to make it visible we have to set it true
        setLocation(350 , 200);
    }


    public static void main(String[] args) throws SQLException {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == clear){
            pinTextField.setText("");
            cardnumTextField.setText("");

        } else if (e.getSource() == signin) {
            Conn conn = new Conn();
            String cardnum = cardnumTextField.getText();
            String pin = pinTextField.getText();
            String query =  "select * from login where cardnum = '"+cardnum+"' and pin = '"+pin+"'";
            try {
                ResultSet rst = conn.s.executeQuery(query);
                if(rst.next())
                {
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin");
                }

            }catch (Exception a)
            {
                System.out.println(a);
            }

        } else if (e.getSource() == signup) {
             setVisible(false);
             new SignUpOne().setVisible(true);
        }
    }
}

package DB_Project;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import  java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener {
long random;
JTextField nametxt , fnametxt , etxt , adtxt , citytxt , statetxt ,pintxt;
JButton next;
JRadioButton male,female , single ,reserved;
    JDateChooser date;

    SignUpOne()
     {
         setLayout(null);

         Random rno = new Random();
         random = Math.abs((rno.nextLong()%9000L) + 1000L);
         JLabel formno = new JLabel("APPLICATION FORM No: "+ random);
         formno.setFont(new Font("Raleway",Font.BOLD,38));
         formno.setBounds(120,40,600,40);
         add(formno);

         JLabel personalDetails = new JLabel("Page 1 : Personal Details");
         personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
         personalDetails.setBounds(290,80,400,30);
         add(personalDetails);


         //----------------------------------------------Name-----------------------------------------------------------
         JLabel name = new JLabel("Name: ");
         name.setFont(new Font("Raleway",Font.BOLD,20));
         name.setBounds(100,140,100,30);
         add(name);

         //============================================Name Text Field==================================================
         nametxt = new JTextField();
         nametxt.setFont(new Font("Raleway",Font.BOLD,14));
         nametxt.setBounds(300,140,400,30);
         add(nametxt);

         //----------------------------------------Father's Name--------------------------------------------------------
         JLabel fname = new JLabel("Father's Name: ");
         fname.setFont(new Font("Raleway",Font.BOLD,20));
         fname.setBounds(100,190,200,30);
         add(fname);

         //============================================Father's Name Text Field=========================================
          fnametxt = new JTextField();
         fnametxt.setFont(new Font("Raleway",Font.BOLD,14));
         fnametxt.setBounds(300,190,400,30);
         add(fnametxt);

         //-------------------------------------DOB---------------------------------------------------------------------
         JLabel dob = new JLabel("Date of Birth: ");
         dob.setFont(new Font("Raleway",Font.BOLD,20));
         dob.setBounds(100 , 240 , 200 , 30);
         add(dob);

         //============================================DOB Calender=====================================================
         date = new JDateChooser();
          date.setBounds(300,240,200,30);
          date.setForeground(new Color(105,105,105));
          add(date);

         //-------------------------------------Gender------------------------------------------------------------------
         JLabel sex = new JLabel("Gender: ");
         sex.setFont(new Font("Raleway",Font.BOLD,20));
         sex.setBounds(100 , 290 , 100 , 30);
         add(sex);

         //================================================Radio Buttons Gender=========================================\
         male = new JRadioButton("Male");
         male.setBounds(300,290,60,30);
         male.setBackground(Color.white);
         add(male);

         female = new JRadioButton("Female");
         female.setBounds(400,290,90,30);
         female.setBackground(Color.white);
         add(female);

         ButtonGroup button1 = new ButtonGroup();
         button1.add(male);
         button1.add(female);


         //---------------------------------------E-mail----------------------------------------------------------------
         JLabel email = new JLabel("Email: ");
         email.setFont(new Font("Raleway",Font.BOLD,20));
         email.setBounds(100 , 340 , 100 , 30);
         add(email);

         //=========================================== EmailText Field==================================================
         etxt = new JTextField();
         etxt.setFont(new Font("Raleway",Font.BOLD,14));
         etxt.setBounds(300,340,400,30);
         add(etxt);

         //---------------------------------------Marital Status--------------------------------------------------------
         JLabel married = new JLabel("Marital Status: ");
         married.setFont(new Font("Raleway",Font.BOLD,20));
         married.setBounds(100 , 390 , 200 , 30);
         add(married);


         //================================================Radio Buttons Status=========================================\
         single = new JRadioButton("Single");
         single.setBounds(300,390,60,30);
         single.setBackground(Color.white);
         add(single);

         reserved = new JRadioButton("Married");
         reserved.setBounds(400,390,90,30);
         reserved.setBackground(Color.white);
         add(reserved);

         ButtonGroup button2 = new ButtonGroup();
         button2.add(male);
         button2.add(female);
         //------------------------------------Address------------------------------------------------------------------
         JLabel address = new JLabel("Address: ");
         address.setFont(new Font("Raleway",Font.BOLD,20));
         address.setBounds(100 , 440 , 200 , 30);
         add(address);

         //========================================Address  Text Field==================================================
         adtxt = new JTextField();
         adtxt.setFont(new Font("Raleway",Font.BOLD,14));
         adtxt.setBounds(300,440,400,30);
         add(adtxt);

         //------------------------------------City---------------------------------------------------------------------
         JLabel city = new JLabel("City: ");
         city.setFont(new Font("Raleway",Font.BOLD,20));
         city.setBounds(100 , 490 , 200 , 30);
         add(city);

         //========================================= City Text Field  ==================================================
         citytxt = new JTextField();
         citytxt.setFont(new Font("Raleway",Font.BOLD,14));
         citytxt.setBounds(300,490,400,30);
         add(citytxt);

         //------------------------------------State--------------------------------------------------------------------
         JLabel state = new JLabel("State: ");
         state.setFont(new Font("Raleway",Font.BOLD,20));
         state.setBounds(100 , 540 , 200 , 30);
         add(state);

         //===========================================State Text Field==================================================
         statetxt = new JTextField();
         statetxt.setFont(new Font("Raleway",Font.BOLD,14));
         statetxt.setBounds(300,540,400,30);
         add(statetxt);

         //------------------------------------PinCode------------------------------------------------------------------
         JLabel pin = new JLabel("Pin Code: ");
         pin.setFont(new Font("Raleway",Font.BOLD,20));
         pin.setBounds(100 , 590 , 200 , 30);
         add(pin);

         //===========================================Pin Text Field==================================================
         pintxt = new JTextField();
         pintxt.setFont(new Font("Raleway",Font.BOLD,14));
         pintxt.setBounds(300,590,400,30);
         add(pintxt);

         //------------------------------------------Next Button -------------------------------------------------------
         next = new JButton("Next");
         next.setBackground(Color.BLACK);
         next.setForeground(Color.cyan);
         next.setFont(new Font("Raleway",Font.BOLD,14));
         next.setBounds(620,660,80,30);
         next.addActionListener(this);
         add(next);

         //------------------------------------Creating Structure of the Layout ----------------------------------------
         getContentPane().setBackground(Color.white);
         setSize(850 , 800);
         setLocation(250 , 50);
         setVisible(true);
     }
@Override
     public void actionPerformed(ActionEvent ae)
     {
         String formno = random + "";
         String name = nametxt.getText();
         String fname = fnametxt.getText();
         String dob =((JTextField) date.getDateEditor().getUiComponent()).getText();
         String gender = null;
         if(male.isSelected())
             gender = "Male";
         else
             gender = "Female";

         String email = etxt.getText();
         String  marital = null;
         if(single.isSelected())
             marital = "Single";
         else
             marital = "Married";
         String address = adtxt.getText();
         String city = citytxt.getText();
         String  state = statetxt.getText();
         String pin = pintxt.getText();

         try {

             if(name.equals("")){
                 JOptionPane.showMessageDialog(null,"Name is Required");
             }
             else {
                 Conn c = new Conn();
                 String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                 c.s.executeUpdate(query);
                 setVisible(false);
                 new SignUpTwo(formno).setVisible(true);
             }
         }catch (Exception e)
         {
             System.out.println(e);
         }
     }
    public static void main(String[] args) {
        new SignUpOne();
    }
}

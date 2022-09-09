package DB_Project;
import java.sql.SQLException;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///db","root","mysql1234");
            s = c.createStatement();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

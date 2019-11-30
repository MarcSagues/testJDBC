import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testJDBC {
    public static Connection c = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;
    public static PreparedStatement pstmt = null;

    public static void main (String[] args) {
        //Backend app = new Backend();

        try {

            Class.forName("org.postgresql.Driver");

            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dreamhouse", "postgres", "");
            stmt = c.createStatement();
            String sql = "SELECT * from branch";

            System.out.println(sql);
            //stmt.executeUpdate(sql);
            ResultSet result =stmt.executeQuery(sql);

            while (result.next()){
                String branch_id = result.getString(1);
                String street = result.getString(2);
                String city = result.getString(3);
                String postcode = result.getString(4);
                System.out.println(branch_id + " " + street + " " + city + " " + postcode);

            }

            //test GUI
            Insert insertForm = new Insert(c);
            insertForm.pack();
            insertForm.setSize(400,400);
            insertForm.setVisible(true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
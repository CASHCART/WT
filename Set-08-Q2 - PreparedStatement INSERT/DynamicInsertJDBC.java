import java.sql.*;
import java.util.*;

public class DynamicInsertJDBC {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            System.out.println("Enter employee ID, name, department and salary:");
            String i = sc.nextLine(), n = sc.nextLine(), d = sc.nextLine();
            float s = sc.nextFloat();
            String q = "INSERT INTO emp VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, i);
            ps.setString(2, n);
            ps.setString(3, d);
            ps.setFloat(4, s);
            int c = ps.executeUpdate();
            if (c == 1) System.out.println("Record inserted");
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

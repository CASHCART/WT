import java.sql.*;
import java.util.*;

public class ProcedureUsingCallableStatement {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            System.out.println("Enter employee ID, name, department and salary:");
            String i = sc.nextLine(), n = sc.nextLine(), d = sc.nextLine();
            float s = sc.nextFloat();
            String q = "{call insert_emp(?,?,?,?)}";
            CallableStatement cs = con.prepareCall(q);
            cs.setString(1, i);
            cs.setString(2, n);
            cs.setString(3, d);
            cs.setFloat(4, s);
            cs.execute();
            System.out.println("Procedure invoked");
            cs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

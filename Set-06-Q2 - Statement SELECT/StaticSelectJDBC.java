import java.sql.*;

public class StaticSelectJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            String q = "SELECT * FROM emp1";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            while (rs.next())
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t"
                    + rs.getString(3) + "\t" + rs.getString(4));
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

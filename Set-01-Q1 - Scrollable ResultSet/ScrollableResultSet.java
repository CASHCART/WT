import java.sql.*;

public class ScrollableResultSet {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            String q = "SELECT id, name, sal FROM emp";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(q);
            rs.first();
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3));
            rs.last();
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3));
            rs.absolute(-2);
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3));
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

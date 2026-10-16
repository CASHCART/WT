import java.sql.*;

public class ResultSetMetadata {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM emp");
            ResultSetMetaData md = rs.getMetaData();
            int cc = md.getColumnCount();
            System.out.println("Number of columns: " + cc);
            for (int i = 1; i <= cc; i++)
                System.out.print(md.getColumnName(i) + "\t");
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= cc; i++)
                    System.out.print(rs.getString(i) + "\t");
                System.out.println();
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

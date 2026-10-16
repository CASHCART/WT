import java.sql.*;

public class DatabaseMetadata {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            DatabaseMetaData dbm = con.getMetaData();
            System.out.println("DB name: " + dbm.getDatabaseProductName());
            System.out.println("DB version: " + dbm.getDatabaseProductVersion());
            System.out.println("Driver name: " + dbm.getDriverName());
            System.out.println("Driver version: " + dbm.getDriverVersion());
            System.out.println("URL: " + dbm.getURL());
            System.out.println("Username: " + dbm.getUserName());
            System.out.println("Max connections: " + dbm.getMaxConnections());
            System.out.println("Transactions: " + dbm.supportsTransactions());
            String[] types = {"TABLE"};
            ResultSet rs = dbm.getTables(null, dbm.getUserName().toUpperCase(), "%", types);
            while (rs.next())
                System.out.println(rs.getString("TABLE_NAME"));
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

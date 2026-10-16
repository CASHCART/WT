import java.sql.*;

public class UpdatableResultSet {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            String q = "SELECT id, name, dept, sal FROM emp";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(q);
            rs.moveToInsertRow();
            rs.updateString(1, "107");
            rs.updateString(2, "rrr");
            rs.updateString(3, "cse");
            rs.updateFloat(4, 30000);
            rs.insertRow();
            rs.moveToCurrentRow();
            System.out.println("New row inserted");
            rs.absolute(4);
            rs.deleteRow();
            System.out.println("Row deleted");
            rs.absolute(2);
            rs.updateString(2, "fff");
            rs.updateFloat(4, 100000);
            rs.updateRow();
            System.out.println("Record updated");
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

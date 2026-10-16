import java.sql.*;

public class CreateStudentTable {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            String q = "CREATE TABLE Student (roll_number NUMBER(10), name VARCHAR2(50), "
                + "branch VARCHAR2(20), year NUMBER(2), cgpa NUMBER(4,2))";
            Statement st = con.createStatement();
            st.executeUpdate(q);
            System.out.println("Table created");
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

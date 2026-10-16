import java.sql.*;

public class StaticInsertJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            String q1 = "INSERT INTO emp1 VALUES('101','aaa','ds',150000)";
            String q2 = "INSERT INTO emp1 VALUES('102','bbb','cs',100000)";
            String q3 = "INSERT INTO emp1 VALUES('103','ccc','cse',120000)";
            Statement st = con.createStatement();
            int i = st.executeUpdate(q1);
            i = i + st.executeUpdate(q2);
            i = i + st.executeUpdate(q3);
            System.out.println("Records inserted: " + i);
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

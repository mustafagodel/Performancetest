import java.sql.*;

public class MySQLExample {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect =DriverManager.getConnection("jdbc:mysql://localhost:3306/hom2","root","cansuerler");
            String sql = "INSERT INTO home1 (ID) VALUES (1)";
            Statement query=connect.createStatement();
         query.executeUpdate(sql);
            System.out.println("Connect");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

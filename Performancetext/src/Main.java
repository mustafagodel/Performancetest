import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/hom2";
        String user = "root";
        String password = "cansuerler";
        int choose = 0;
        while (choose != 3) {

            Scanner input = new Scanner(System.in);
            System.out.println("Welcome");
            System.out.println("-------------------------");
            System.out.println("1-Write Operatio");
            System.out.println("2-Read Operatio");
            System.out.println("3-Quit");
            choose = input.nextInt();
            conn = DriverManager.getConnection(url, user, password);

            switch (choose) {
                case 1:
                    try {
                        conn = DriverManager.getConnection(url, user, password);

                        System.out.println("Write operation selected");
                        System.out.println("Enter record number(10,100,1000...): ");
                        int row = input.nextInt();
                        System.out.println("Enter column number(Only 1,2,3,4): ");
                        int colum = input.nextInt();
                        long startTime = System.currentTimeMillis();

                        for (int i = 0; i < row; i++) {
                            String sql = "INSERT INTO homework (Numeric_1) VALUES (?)";
                            PreparedStatement statement = conn.prepareStatement(sql);
                            statement.setInt(1, 15);
                            statement.executeUpdate();
                        }

                        long Time1 = System.currentTimeMillis() - startTime;

                        for (int i = 0; i < row; i++) {
                            String sql = "INSERT INTO homework (Numeric_1,Character_1) VALUES (?,?)";
                            PreparedStatement statement = conn.prepareStatement(sql);
                            statement.setInt(1, 15);
                            statement.setString(2, "c");
                            statement.executeUpdate();
                        }
                        long Time2 = System.currentTimeMillis() - (startTime + Time1);
                        for (int i = 0; i < row; i++) {
                            String sql = "INSERT INTO homework (Numeric_1,Character_1,Real_1) VALUES (?,?,?)";
                            PreparedStatement statement = conn.prepareStatement(sql);
                            statement.setInt(1, 15);
                            statement.setString(2, "c");
                            statement.setDouble(3, 2.555);
                            statement.executeUpdate();
                        }
                        long Time3 = System.currentTimeMillis() - (startTime + Time1 + Time2);
                        for (int i = 0; i < row; i++) {
                            String sql = "INSERT INTO homework (Numeric_1,Character_1,Real_1,Alphanumeric) VALUES (?,?,?,?)";
                            PreparedStatement statement = conn.prepareStatement(sql);
                            statement.setInt(1, 15);
                            statement.setString(2, "c");
                            statement.setDouble(3, 2.555);
                            statement.setString(4, "testvalue");
                            statement.executeUpdate();
                        }
                        long Time4 = System.currentTimeMillis() - (startTime + Time1 + Time2 + Time3);
                        conn.close();
                        if (colum == 1) {
                            System.out.println("Time taken for column 1: " + Time1 + " ms");
                        } else if (colum == 2) {
                            System.out.println("Time taken for column 2: " + Time2 + " ms");
                        } else if (colum == 3) {
                            System.out.println("Time taken for column 3: " + Time3 + " ms");
                        } else if (colum == 4) {
                            System.out.println("Time taken for column 4: " + Time4 + " ms");
                        } else {
                            System.out.println("Not Found");
                        }


                    } catch (SQLException e) {
                        System.out.println("Error connecting to database.");
                        e.printStackTrace();
                    }
                    break;
                case 2:

                    Statement stmt = null;
                    ResultSet rs = null;

                    try {
                        conn = DriverManager.getConnection(url, user, password);
                        System.out.println("Read operation selected");
                        System.out.println("Enter record number(10,100,1000...): ");
                        int row = input.nextInt();
                        System.out.println("Enter column number(Only 1,2,3,4): ");
                        int colum = input.nextInt();
                        String sql = "SELECT * FROM homework";
                        PreparedStatement statement = conn.prepareStatement(sql);
                         rs = statement.executeQuery(sql);
                               int count=0;
                        long startTime = System.currentTimeMillis();
                        while (rs.next()&&count<row) {
                            int num = rs.getInt("Numeric_1");
                            count++;
                 }
                        long col1Time = System.currentTimeMillis() - startTime;
                        count = 0;
                        while (rs.next()&&count<row) {
                            int num = rs.getInt("Numeric_1");
                            String Character_1 = rs.getString("Character_1");
                            count++;
                        }
                        long col2Time = System.currentTimeMillis() - (startTime + col1Time);
                        count = 0;
                        while (rs.next()&&count<row) {
                            int num = rs.getInt("Numeric_1");
                            String Character_1 = rs.getString("Character_1");
                            int Real_1 = rs.getInt("Real_1");
                            count++;
                        }
                        long col3Time = System.currentTimeMillis() - (startTime + col1Time + col2Time);

                        count = 0;
                        while (rs.next()&&count<row) {
                            int num = rs.getInt("Numeric_1");
                            String Character_1 = rs.getString("Character_1");
                            int Real_1 = rs.getInt("Real_1");
                            String Alphanumeric = rs.getString("Alphanumeric");
                            count++;
                        }
                        long col4Time = System.currentTimeMillis() - (startTime + col1Time + col2Time + col3Time);
                        conn.close();
                        if (colum == 1) {
                            System.out.println("Time taken for column 1: " + col1Time + " ms");
                        } else if (colum == 2) {
                            System.out.println("Time taken for column 2: " + col2Time + " ms");
                        } else if (colum == 3) {
                            System.out.println("Time taken for column 3: " + col3Time + " ms");
                        } else if (colum == 4) {
                            System.out.println("Time taken for column 4: " + col4Time + " ms");
                        } else {
                            System.out.println("Not Found");
                        }
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("The program is ending");
                    break;
            }

        }
    }
}
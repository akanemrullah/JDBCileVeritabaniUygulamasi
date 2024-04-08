import java.sql.*;

public class Main {
    // Veritabanimizin url, username ve password lerinin tutuldugu string degiskenlerimiz.
    public static final String DB_URL = "jdbc:mysql://localhost/employees";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection connect;
        Statement statement;
        String sql = "SELECT * FROM employees"; // SQL sorgumuzu tuttugumuz String degiskenimiz
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connect.createStatement();
            ResultSet data = statement.executeQuery(sql);

            while(data.next()){ // Resultset sinifindan yarattigimiz data nesnesinin next metodu ile verileri alip print ediyoruz.

                System.out.println("ID: " + data.getInt("id"));
                System.out.println("NAME: " + data.getString("name"));
                System.out.println("POSITION: " + data.getString("position"));
                System.out.println("SALARY: " + data.getInt("salary"));
                System.out.println("\n###########################\n");

            }

            connect.close();

        } catch (SQLException e) { // Olasi hatada calisacak olan blok
            System.out.println(e.getMessage());
        }

    }
}
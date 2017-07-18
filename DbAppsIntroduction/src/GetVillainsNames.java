import java.sql.*;

public class GetVillainsNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        String selectQuery = "SELECT v.name, COUNT(mv.villain_id) AS 'count' " +
                "FROM minions_villains AS mv " +
                "INNER JOIN villains AS v " +
                "ON mv.villain_id = v.villain_id " +
                "GROUP BY v.name " +
                "HAVING `count` > 3 " +
                "ORDER BY `count` DESC;";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(selectQuery);
        ) {
            while (result.next()) {
                System.out.println(String.format("%s %d", result.getString("name"), result.getInt("count")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

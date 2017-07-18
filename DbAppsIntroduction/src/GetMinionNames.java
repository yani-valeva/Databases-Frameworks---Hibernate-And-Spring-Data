import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class GetMinionNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int villainId = Integer.parseInt(reader.readLine());
        String query = String.format("SELECT v.name AS 'v_name', m.name AS 'm_name', m.age AS 'm_age' " +
                "FROM villains AS v " +
                "LEFT JOIN minions_villains AS mv " +
                "ON v.villain_id = mv.villain_id " +
                "LEFT JOIN minions AS m " +
                "ON mv.minion_id = m.minion_id " +
                "WHERE v.villain_id = %d;", villainId);

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                ){
            boolean foundMinion = false;
            boolean foundVillain = false;
            int currentNumber = 1;
            while (result.next()) {
                if (currentNumber == 1) {
                    foundVillain = true;
                    System.out.println(String.format("Villain: %s", result.getString("v_name")));
                }
                if (result.getString("m_name") != null) {
                    foundMinion = true;
                    System.out.println(String.format("%d. %s %d", currentNumber, result.getString("m_name"), result.getInt("m_age")));
                    currentNumber++;
                }
            }

            if (foundVillain && !foundMinion) {
                System.out.println("<no minions>");
            } else if (!foundVillain) {
                System.out.println(String.format("No villain with ID %d exists in the database.", villainId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

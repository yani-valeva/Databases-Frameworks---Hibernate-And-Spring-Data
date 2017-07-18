import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChangeTownNamesCasing {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> townNames = new ArrayList<>();

        String countryName = reader.readLine();
        String selectTownsQuery = "SELECT name " +
                "FROM towns " +
                "WHERE country = ?;";
        String updateTownsQuery = "UPDATE towns " +
                "SET name = upper(name) " +
                "WHERE country = ?;";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        ) {
            PreparedStatement townPreparedStatement = connection.prepareStatement(selectTownsQuery);
            townPreparedStatement.setString(1, countryName);
            ResultSet townResultSet = townPreparedStatement.executeQuery();

            while (townResultSet.next()) {
                townNames.add(townResultSet.getString("name").toUpperCase());
            }

            townPreparedStatement.close();

            PreparedStatement townUpdateStatement = connection.prepareStatement(updateTownsQuery);
            townUpdateStatement.setString(1, countryName);
            townUpdateStatement.executeUpdate();
            townUpdateStatement.close();

            if (townNames.size() > 0) {
                System.out.println(String.format("%d town names were affected.", townNames.size()));
                System.out.println(townNames.toString());
            } else {
                System.out.println("No town names were affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

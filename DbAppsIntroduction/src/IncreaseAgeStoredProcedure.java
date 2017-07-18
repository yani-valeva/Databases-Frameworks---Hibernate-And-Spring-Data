import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class IncreaseAgeStoredProcedure {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int minionId = Integer.parseInt(reader.readLine());
        String procedure = "CALL usp_get_older (?);";
        String selectMinionsQuery = "SELECT * " +
                "FROM minions " +
                "WHERE minion_id = ?;";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        ) {
            CallableStatement callableStatement = connection.prepareCall(procedure);
            callableStatement.setInt(1, minionId);
            callableStatement.execute();
            callableStatement.close();

            PreparedStatement selectStatement = connection.prepareStatement(selectMinionsQuery);
            selectStatement.setInt(1, minionId);
            ResultSet result = selectStatement.executeQuery();

            if (result.next()) {
                System.out.println(String.format("%s %d", result.getString("name"), result.getInt("age")));
            }

            selectStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

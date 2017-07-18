import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;

public class IncreaseMinionsAge {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] idInfo = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String selectMinionsQuery = "SELECT * " +
                "FROM minions " +
                "WHERE minion_id = ?;";
        String updateMonionsQuery = "UPDATE minions " +
                "SET age = age + 1, " +
                "name = ? " +
                "WHERE minion_id = ?;";
        String selectMinionsInfoQuery = "SELECT * " +
                "FROM minions;";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        ) {
            for (int i = 0; i < idInfo.length; i++) {

                int currentId = idInfo[i];
                PreparedStatement selectPreparedStatement = connection.prepareStatement(selectMinionsQuery);
                selectPreparedStatement.setInt(1, currentId);
                ResultSet result = selectPreparedStatement.executeQuery();

                if (result.next()) {
                    String[] currentNameInfo = result.getString("name").split("\\s+");
                    StringBuilder sb = new StringBuilder();

                    for (int j = 0; j < currentNameInfo.length; j++) {
                        if (j == currentNameInfo.length - 1) {
                            sb.append(currentNameInfo[j].substring(0, 1).toUpperCase());
                            sb.append(currentNameInfo[j].substring(1));
                        } else {
                            sb.append(currentNameInfo[j].substring(0, 1).toUpperCase());
                            sb.append(currentNameInfo[j].substring(1));
                            sb.append(" ");
                        }
                    }

                    String currentName = sb.toString();

                    PreparedStatement updatePreparedStatement = connection.prepareStatement(updateMonionsQuery);
                    updatePreparedStatement.setString(1, currentName);
                    updatePreparedStatement.setInt(2, currentId);
                    updatePreparedStatement.executeUpdate();
                    updatePreparedStatement.close();
                }

                selectPreparedStatement.close();
            }

            PreparedStatement selectStatement = connection.prepareStatement(selectMinionsInfoQuery);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(String.format("%s %d", resultSet.getString("name"), resultSet.getInt("age")));
            }

            selectStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

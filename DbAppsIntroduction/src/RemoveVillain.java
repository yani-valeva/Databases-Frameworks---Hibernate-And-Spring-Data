import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class RemoveVillain {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int villainId = Integer.parseInt(reader.readLine());

        String selectVillainQuery = "SELECT * " +
                "FROM villains " +
                "WHERE villain_id = ?;";
        String deleteMinionsVillainsQuery = "DELETE FROM minions_villains " +
                "WHERE villain_id = ?;";
        String deleteVillainsQuery = "DELETE FROM villains " +
                "WHERE villain_id = ?;";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        ) {
            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillainQuery);
            selectVillainStatement.setInt(1, villainId);
            ResultSet villainResultSet = selectVillainStatement.executeQuery();

            if (villainResultSet.next()) {
                String villainName = villainResultSet.getString("name");
                PreparedStatement deleteMinionsVillainsStatement = connection.prepareStatement(deleteMinionsVillainsQuery);
                deleteMinionsVillainsStatement.setInt(1, villainId);
                int minionsCount = deleteMinionsVillainsStatement.executeUpdate();
                deleteMinionsVillainsStatement.close();

                PreparedStatement deleteVillainsStatement = connection.prepareStatement(deleteVillainsQuery);
                deleteVillainsStatement.setInt(1,villainId);
                deleteVillainsStatement.executeUpdate();
                deleteVillainsStatement.close();

                System.out.println(String.format("%s was deleted", villainName));
                System.out.println(String.format("%d minions released", minionsCount));

            } else {
                System.out.println("No such villain was found");
            }

            selectVillainStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

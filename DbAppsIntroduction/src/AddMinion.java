import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class AddMinion {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] minionsInfo = reader.readLine().split("\\s+");
        String minionName = minionsInfo[1];
        int minionAge = Integer.parseInt(minionsInfo[2]);
        String town = minionsInfo[3];

        String[] villainsInfo = reader.readLine().split("\\s+");
        String villainName = villainsInfo[1];

        String selectTownsQuery = "SELECT * " +
                "FROM towns " +
                "WHERE name = ?;";
        String selectVillainsQuery = "SELECT * " +
                "FROM villains " +
                "WHERE name = ?;";
        String selectMinionsQuery = "SELECT * " +
                "FROM minions " +
                "WHERE name = ?;";
        String insertTownsQuery = "INSERT INTO towns(name) " +
                "VALUES (?);";
        String insertVillainsQuery = "INSERT INTO villains(name, evilness_factor) " +
                "VALUES (?, 'evil');";
        String insertMinionsQuery = "INSERT INTO minions(name, age, town_id) " +
                "VALUES (?, ?, ?);";
        String insertMinionsVillainsQuery = "INSERT INTO minions_villains(minion_id, villain_id) " +
                "VALUES (?, ?);";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        ) {

            PreparedStatement townPreparedStatement = connection.prepareStatement(selectTownsQuery);
            townPreparedStatement.setString(1, town);
            ResultSet townResult = townPreparedStatement.executeQuery();

            if (!townResult.next()) {
                PreparedStatement insertTownStatement = connection.prepareStatement(insertTownsQuery);
                insertTownStatement.setString(1, town);
                insertTownStatement.executeUpdate();
                System.out.println(String.format("Town %s was added to the database.", town));
                insertTownStatement.close();
            }

            int townId = 0;
            ResultSet townsUpdate = townPreparedStatement.executeQuery();

            if (townsUpdate.next()) {
                townId = townsUpdate.getInt("town_id");
            }

            townPreparedStatement.close();

            PreparedStatement villainsPreparedStatement = connection.prepareStatement(selectVillainsQuery);
            villainsPreparedStatement.setString(1, villainName);
            ResultSet villainResult = villainsPreparedStatement.executeQuery();

            if (!villainResult.next()) {
                PreparedStatement insertVillainStatement = connection.prepareStatement(insertVillainsQuery);
                insertVillainStatement.setString(1, villainName);
                insertVillainStatement.executeUpdate();
                System.out.println(String.format("Villain %s was added to the database.", villainName));
                insertVillainStatement.close();
            }

            int villainId = 0;
            ResultSet villainsUpdate = villainsPreparedStatement.executeQuery();

            if (villainsUpdate.next()) {
                villainId = villainsUpdate.getInt("villain_id");
            }

            villainsPreparedStatement.close();

            PreparedStatement insertMinionsStatement = connection.prepareStatement(insertMinionsQuery);
            insertMinionsStatement.setString(1, minionName);
            insertMinionsStatement.setInt(2, minionAge);
            insertMinionsStatement.setInt(3, townId);
            insertMinionsStatement.executeUpdate();
            insertMinionsStatement.close();

            PreparedStatement minionsPreparedStatement = connection.prepareStatement(selectMinionsQuery);
            minionsPreparedStatement.setString(1, minionName);
            ResultSet minionsResult = minionsPreparedStatement.executeQuery();
            int minionId = 0;

            if (minionsResult.next()) {
                minionId = minionsResult.getInt("minion_id");
            }

            minionsPreparedStatement.close();

            PreparedStatement insertMinionsVillainsStatement = connection.prepareStatement(insertMinionsVillainsQuery);
            insertMinionsVillainsStatement.setInt(1, minionId);
            insertMinionsVillainsStatement.setInt(2, villainId);
            insertMinionsVillainsStatement.executeUpdate();
            System.out.println(String.format("Successfully added %s to be minion of %s.", minionName, villainName));
            insertMinionsVillainsStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

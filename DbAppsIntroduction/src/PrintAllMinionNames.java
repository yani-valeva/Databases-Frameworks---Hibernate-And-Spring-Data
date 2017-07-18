import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PrintAllMinionNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        List<String> minionNames = new LinkedList<>();
        String selectMinionsQuery = "SELECT name " +
                "FROM minions;";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        ) {
            PreparedStatement selectMinionsStatement = connection.prepareStatement(selectMinionsQuery);
            ResultSet minionsResultSet = selectMinionsStatement.executeQuery();

            while (minionsResultSet.next()) {
                minionNames.add(minionsResultSet.getString("name"));
            }

            selectMinionsStatement.close();

            for (int i = 0; i <= minionNames.size() / 2; i++) {
                if (minionNames.size() % 2 != 0 && i == minionNames.size() / 2) {
                    System.out.println(minionNames.get(i));
                } else if (minionNames.size() % 2 == 0 && i == minionNames.size() / 2) {
                    continue;
                } else {
                    System.out.println(minionNames.get(i));
                    System.out.println(minionNames.get(minionNames.size() - 1 - i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

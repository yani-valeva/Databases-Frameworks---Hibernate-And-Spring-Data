import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialSetup {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        String createQuery = "CREATE DATABASE minions_db;";
        String useQuery = "USE minions_db";

        String createMinionTableQuery = "CREATE TABLE minions( " +
                "minion_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50), " +
                "age INT, " +
                "town_id INT, " +
                "CONSTRAINT fk_minions_towns FOREIGN KEY (town_id) REFERENCES towns(town_id));";

        String createTownTableQuery = "CREATE TABLE towns( " +
                "town_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50), " +
                "country VARCHAR(50));";

        String createVillainsTableQuery = "CREATE TABLE villains( " +
                "villain_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50), " +
                "evilness_factor ENUM ('good', 'bad', 'evil', 'super evil'));";

        String createMinionsVillainsTableQuery = "CREATE TABLE minions_villains( " +
                "minion_id INT, " +
                "villain_id INT, " +
                "CONSTRAINT pk_minions_villains PRIMARY KEY (minion_id, villain_id), " +
                "CONSTRAINT fk_minions_minions_villains FOREIGN KEY (minion_id) REFERENCES minions (minion_id), " +
                "CONSTRAINT fk_villains_minions_villains FOREIGN KEY (villain_id) REFERENCES villains (villain_id));";

        String insertTownsQuery = "INSERT INTO towns(name, country) " +
                "VALUES('Sofia', 'Bulgaria'), ('Plovdiv', 'Bulgaria'), ('Berlin', 'Germany'), ('Vienna', 'Austria'), ('Varna', 'Bulgaria');";


        String insertMinionsQuery = "INSERT INTO minions(name, age, town_id) " +
                "VALUES('Garry', 6, 2), ('Simon', 20, 1), ('Vivu', 50, 5), ('Victor', 70, 4), ('Hary', 63, 3), ('John', 3, 2);";

        String insertVillainsQuery = "INSERT INTO villains(name, evilness_factor) " +
                "VALUES('Lily', 'good'), ('Bob', 'bad'), ('Sara', 'evil'), ('Jimmy', 'super evil'), ('Zoro', 'good');";

        String insertMinionsVillainsQuery = "INSERT INTO minions_villains(minion_id, villain_id) " +
                "VALUES(1, 4), (2, 3), (3, 1), (4, 5), (5, 2), (3, 2), (6, 2), (1, 2), (6, 5), (1, 5), (2, 5), (3, 5);";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(createQuery);
            statement.executeQuery(useQuery);
            statement.executeUpdate(createTownTableQuery);
            statement.executeUpdate(createMinionTableQuery);
            statement.executeUpdate(createVillainsTableQuery);
            statement.executeUpdate(createMinionsVillainsTableQuery);

            statement.executeUpdate(insertTownsQuery);
            statement.executeUpdate(insertMinionsQuery);
            statement.executeUpdate(insertVillainsQuery);
            statement.executeUpdate(insertMinionsVillainsQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
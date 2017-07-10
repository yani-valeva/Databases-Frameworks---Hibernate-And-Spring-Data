package birthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        List<Birthable> featuresB = new ArrayList<>();
        List<Identifiable> featuresI = new ArrayList<>();

        while (!input[0].equals("End")) {
            switch (input[0]) {
                case "Citizen":
                    String name = input[1];
                    int age = Integer.parseInt(input[2]);
                    String id = input[3];
                    String birthdate = input[4];
                    Citizen citizen = new Citizen(id, name, age, birthdate);
                     citizen = new Citizen(id, name, age, birthdate);
                    featuresB.add(citizen);
                    featuresI.add(citizen);
                    break;
                case "Pet":
                    String petName = input[1];
                    String petBirthdate = input[2];
                    Birthable pet = new Pet(petName, petBirthdate);
                    featuresB.add(pet);
                    break;
                case "Robot":
                    String model = input[1];
                    String robotId = input[2];
                    Identifiable robot = new Robot(robotId, model);
                    featuresI.add(robot);
                    break;
            }

            input = reader.readLine().split("\\s+");
        }

        String checkYear = reader.readLine();

        for (Birthable birthable : featuresB) {
            if (birthable.getBirthdate().endsWith(checkYear)) {
                System.out.println(birthable.getBirthdate());
            }
        }
    }
}

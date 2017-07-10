package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        List<Identifiable> features = new ArrayList<>();

        while (!input[0].equals("End")) {
            if (input.length == 2) {
                String model = input[0];
                String id = input[1];
                Identifiable robot = new Robot(id, model);
                features.add(robot);
            } else if (input.length == 3) {
                String name = input[0];
                int age = Integer.parseInt(input[1]);
                String id = input[2];
                Identifiable citizen = new Citizen(id, name, age);
                features.add(citizen);
            }

            input = reader.readLine().split("\\s+");
        }

        String checkNumber = reader.readLine();

        for (Identifiable feature : features) {
            if (feature.getId().endsWith(checkNumber)) {
                System.out.println(feature.getId());
            }
        }
    }
}
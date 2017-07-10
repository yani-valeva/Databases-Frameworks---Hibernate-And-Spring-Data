package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        while (!input.equals("Beast!")) {
            String[] animalInfo = reader.readLine().split("\\s+");
            String name = animalInfo[0];
            if (animalInfo[0].equals("") || animalInfo[0] == null) {
                System.out.println("Invalid input!");
                return;
            }

            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];

            try {
                switch (input) {
                    case "Cat":
                        Animal cat = new Cat(name, age, gender);
                        System.out.println(cat.toString());
                        System.out.println(cat.produceSound());
                        break;
                    case "Dog":
                        Animal dog = new Dog(name, age, gender);
                        System.out.println(dog.toString());
                        System.out.println(dog.produceSound());
                        break;
                    case "Frog":
                        Animal frog = new Frog(name, age, gender);
                        System.out.println(frog.toString());
                        System.out.println(frog.produceSound());
                        break;
                    case "Kitten":
                        Animal kitten = new Kitten(name, age, gender);
                        System.out.println(kitten.toString());
                        System.out.println(kitten.produceSound());
                        break;
                    case "Tomcat":
                        Animal tomcat = new Tomcat(name, age, gender);
                        System.out.println(tomcat.toString());
                        System.out.println(tomcat.produceSound());
                        break;
                    default:
                        System.out.println("Invalid input!");
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

            input = reader.readLine();
        }
    }
}

package groupByGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> students = new ArrayList<>();

        String[] studentsInfo = reader.readLine().split("\\s+");

        while (!"END".equals(studentsInfo[0])) {
            String name = studentsInfo[0] + " " + studentsInfo[1];
            int group = Integer.parseInt(studentsInfo[2]);
            Person person = new Person(name, group);
            students.add(person);
            studentsInfo = reader.readLine().split("\\s+");
        }

        students.stream()
                .collect(Collectors.groupingBy(Person::getGroup, Collectors.mapping(Person::getName, Collectors.toList())))
                .entrySet().stream()
               .sorted((a, b) -> Integer.compare(a.getKey(), b.getKey()))
               .forEach(s -> System.out.println(s.getKey() + " - " + s.getValue().toString().replaceAll("\\[|]", "")));
    }
}

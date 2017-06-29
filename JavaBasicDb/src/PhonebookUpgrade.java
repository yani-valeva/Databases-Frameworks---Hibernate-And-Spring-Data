import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhonebookUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] phonebookInfo = reader.readLine().split("\\s+");
        Map<String, String> phonebook = new LinkedHashMap<>();

        while (!phonebookInfo[0].equals("END")) {
            String command = phonebookInfo[0];
            String name = phonebookInfo.length > 1 ? phonebookInfo[1] : "";
            String phone = command.equals("A") ? phonebookInfo[2] : "";

            if (command.equals("A")) {
                phonebook.put(name, phone);
            } else if (command.equals("S")){
                if (phonebook.containsKey(name)) {
                    System.out.println(String.format("%s -> %s", name, phonebook.get(name)));
                } else {
                    System.out.println(String.format("Contact %s does not exist.", name));
                }
            }  else if (command.equals("ListAll")) {
                phonebook.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                        .forEach(a -> System.out.println(String.format("%s -> %s", a.getKey(), a.getValue())));
            }

            phonebookInfo = reader.readLine().split("\\s+");
        }
    }
}

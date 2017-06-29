import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CensorEmailAddress {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String email = reader.readLine();
        String text = reader.readLine();

        int lastUsernameIndex = email.indexOf("@");
        String username = email.substring(0, lastUsernameIndex);
        String domain = email.substring(lastUsernameIndex + 1);
        String replacement = drawStars(username) + "@" + domain;
        text = text.replace(email, replacement);

        System.out.println(text);
    }

    public static String drawStars (String username) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < username.length(); i++) {
            sb.append("*");
        }

        return sb.toString();
    }
}

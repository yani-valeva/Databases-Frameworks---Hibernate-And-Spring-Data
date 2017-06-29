import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class URLParser {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] urlInfo = reader.readLine().split("://");

        String protocol = urlInfo.length > 1 ? urlInfo[0] : "";
        String serverAndResourse = urlInfo.length > 1 ? urlInfo[1] : urlInfo[0];
        int index = serverAndResourse.indexOf("/");
        String server = index > 0 ? serverAndResourse.substring(0, index) : serverAndResourse;
        String resourse = index > 0 ? serverAndResourse.substring(index + 1) : "";

        System.out.println(String.format("[protocol] = \"%s\"%n[server] = \"%s\"%n[resource] = \"%s\"", protocol.trim(), server.trim(), resourse.trim()));
    }
}

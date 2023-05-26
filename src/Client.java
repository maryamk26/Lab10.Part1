import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_ADDRESS = "LOCALHOST";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String username = getUsernameFromUser();
            out.println(username);

            String response = in.readLine();
            System.out.println("THE RESPONSE OF THE SERVER : " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getUsernameFromUser() throws IOException {
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("PUT THE USERNAME : ");
        return userIn.readLine();
    }
}
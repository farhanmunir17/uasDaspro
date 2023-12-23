
package tiket_pesawat;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static Map<String, User> users = new HashMap<>();

    public static void registerUser(String name, String email, String username, String password) {
        users.put(username, new User(name, email, username, password));
        System.out.println("Registrasi Berhasil. Silahkan login.");
    }

    public static User loginUser(String username, String password) {
        User user = users.get(username);

        if (user != null && user.password.equals(password)) {
            return user;
        }

        return null;
    }
}


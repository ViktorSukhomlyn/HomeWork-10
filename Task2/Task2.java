import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main(String[] args) throws IOException {
            List<User> users = new ArrayList<User>();
            String filePath = "file.txt";
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String data;
                data=reader.readLine();
                while ((data = reader.readLine()) != null) {
                    String[] words = data.split(" ");
                    User tempUser = new User(words[0], Integer.valueOf(words[1]));
                    users.add(tempUser);
                }
                System.out.println("Зчитано данні з файлу: "+filePath);

                Gson gson = new Gson();
                filePath = "user.json";
                try (FileWriter writer = new FileWriter(filePath)) {
                    gson.toJson(users, writer);
                    System.out.println("Записано данні у файл: "+filePath);
                }
                catch (IOException e) {
                    System.err.println("Помилка запису в файл: " + e.getMessage());
                }
                }
            catch (IOException e) {
                System.err.println("Помилка читання з файлу: " + e.getMessage());
            }

        }


}
class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
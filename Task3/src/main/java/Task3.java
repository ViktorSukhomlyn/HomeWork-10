import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        List<ResultWord> myWords = new ArrayList<ResultWord>();
        Set<String> uniqueWords = new HashSet<>();

        String filePath = "./src/main/resources/file.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String data;
            while ((data = reader.readLine()) != null) {
                String[] words = data.split("\\s+");
                for (String word : words) {
                    if (uniqueWords.add(word)) {
                        myWords.add(new ResultWord(word, 1));
                    } else {
                        for (ResultWord element : myWords) {
                            if ( element.getWord().equals(word)) {
                                element.setCount(element.getCount()+1);
                            }
                        }
                    }
                }
            }
            Collections.sort(myWords);
            for (ResultWord element : myWords) {
                System.out.println(element);
            }
        }
        catch(IOException e){
                System.err.println("Помилка читання з файлу: " + e.getMessage());
            }
    }
}
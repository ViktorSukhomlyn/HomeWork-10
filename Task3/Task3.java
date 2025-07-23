import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        List<resultWord> myWords = new ArrayList<resultWord>();
        Set<String> uniqueWords = new HashSet<>();

        String filePath = "file.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String data;
            while ((data = reader.readLine()) != null) {
                String[] words = data.split("\\s+");
                for (String word : words) {
                    if (uniqueWords.add(word)) {
                        myWords.add(new resultWord(word, 1));
                    } else {
                        for (resultWord element : myWords) {
                            if ( element.getWord().equals(word)) {
                                element.setCount(element.getCount()+1);
                            }
                        }
                    }
                }
            }
            Collections.sort(myWords);
            for (resultWord element : myWords) {
                System.out.println(element);
            }

        }
        catch(IOException e){
                System.err.println("Помилка читання з файлу: " + e.getMessage());
            }
    }
}

class resultWord implements Comparable <resultWord> {

    private String word;
    private int count;

    public resultWord(String word, int count) {
        this.word = word;
        this.count = count;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return word + " "+count;
    }

    @Override
    public int compareTo(resultWord other) {
        return Integer.compare(this.count, other.count);
    }
}
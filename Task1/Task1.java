import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public void ReadFile (){
        String myString;
        String myPattern="\\(\\d{3}\\)\\s\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}";

        Pattern regexp = Pattern.compile(myPattern);
            try {
            Scanner scanner = new Scanner(new File("file.txt"));

            while (scanner.hasNextLine()) {
                myString=scanner.nextLine();
                Matcher match = regexp.matcher(myString);
                while(match.find()) {
                    System.out.println(myString);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

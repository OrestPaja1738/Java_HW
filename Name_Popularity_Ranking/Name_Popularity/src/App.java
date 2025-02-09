import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * The exercise can be solved without hashmaps. User gives input for gender and name. According to gender
 * the file is iterated over and using a variable there will be a conditional statement inside the loop
 * in order to check if the given (key) == the string variable extracted from the file.
 * I chose hashMaps because they are efficent in storing this type of data and for making it feasible to sort according to values
 */

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String,Integer> maleData = new HashMap<>();
        HashMap<String,Integer> femaleData = new HashMap<>();

        //adding data into hash maps from respective sources
        try {
            BufferedReader readerM = new BufferedReader(new FileReader("C:\\Users\\orest\\Documents\\Java Dev\\Homework2\\Name_Popularity_Ranking\\Name_Popularity\\src\\MostFrequentMaleNames.txt"));
            BufferedReader readerF = new BufferedReader(new FileReader("C:\\Users\\orest\\Documents\\Java Dev\\Homework2\\Name_Popularity_Ranking\\Name_Popularity\\src\\MostFrequentFemaleNames.txt"));

            //getting data for Male names
            String line1;
            while ((line1 = readerM.readLine()) != null) { 
                String[] parts = line1.split(" ");
                String nameM = parts[0];
                int occurrenceM = Integer.parseInt(parts[1]);

                maleData.put(nameM, occurrenceM);
            }
            //getting data for Female names
            String line2;
            while ((line2 = readerF.readLine()) != null) { 
                String[] parts = line2.split(" ");
                String nameF = parts[0];
                int occurrenceF = Integer.parseInt(parts[1]);

                femaleData.put(nameF, occurrenceF);
            }

            //sorting each hashMap
            List<Map.Entry<String, Integer>> sortedEntriesM = maleData.entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .collect(Collectors.toList());
            
            List<Map.Entry<String, Integer>> sortedEntriesF = femaleData.entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .collect(Collectors.toList());

            //User input for searching 
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Enter the gender");
            String gender = scanner.next();
            switch (gender) {
                case "Male":
                    System.out.println("Enter the name you want to search");
                    String maleName = scanner.next();
                    int position = 0;
                    boolean found = false;
                    for (Map.Entry<String, Integer> entry : sortedEntriesM) {
                        position++;
                        if (entry.getKey().equals(maleName)) {
                            System.out.println(maleName + " is ranked #" + position + " with  " + entry.getValue() + " occurrences");
                            found = true;
                            break;
                        }
                    }
            
                    if (!found) {
                        System.out.println("Person not found.");
                    }
                    break;
                case "Female":
                    System.out.println("Enter the name you want to search");
                    String femaleName = scanner.next();
                    int position2 = 0;
                    boolean found2 = false;
                    for (Map.Entry<String, Integer> entry : sortedEntriesF) {
                    position2++;
                    if (entry.getKey().equals(femaleName)) {
                        System.out.println(femaleName + " is ranked #" + position2 + " with  " + entry.getValue() + " occurrences");
                        found2 = true;
                        break;
                    }
                    }
        
                    if (!found2) {
                        System.out.println("Person not found.");
                    }
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

            //merging hash maps
            HashMap<String, Integer> mergedData = new HashMap<>(maleData);
            femaleData.forEach((key, value) -> mergedData.merge(key, value, Integer::sum));
            List<Map.Entry<String, Integer>> sortedMergedEntries = mergedData.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toList());
            
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\orest\\Documents\\Java Dev\\Homework2\\Name_Popularity_Ranking\\Name_Popularity\\src\\Top200Names.txt"));
                //Writing into the file the top 200 names
                int limit = Math.min(200, sortedMergedEntries.size());
                for (int i = 0; i < limit; i++) {
                    Map.Entry<String, Integer> entry = sortedMergedEntries.get(i);
                    writer.write((i + 1) + ". " + entry.getKey() + " - " + entry.getValue());
                    writer.newLine(); // Move to the next line
                }
                System.out.println("Top 200 names have been successfully written to the file.");

                writer.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }

            readerM.close();
            readerF.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

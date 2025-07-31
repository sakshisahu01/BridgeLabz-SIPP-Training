import java.io.*;
import java.util.*;

class Word_Counter 
{
    public static void main(String[] args) 
    {
        String inputFile = "input.txt";  // Source file

        BufferedReader reader = null;
        Map<String, Integer> wordCount = new HashMap<>();

        try 
        {
            reader = new BufferedReader(new FileReader(inputFile));
            String line;

            while ((line = reader.readLine()) != null) 
            {
                // Remove punctuation and split into words
                String[] words = line.toLowerCase().replaceAll("[^a-z0-9 ]", "").split("\\s+");

                for (String word : words) 
                {
                    if (!word.isEmpty()) 
                    {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort the map by values (frequency)
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
            sortedList.sort((a, b) -> b.getValue() - a.getValue());

            System.out.println("🔝 Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedList.size()); i++) 
            {
                Map.Entry<String, Integer> entry = sortedList.get(i);
                System.out.println("   " + entry.getKey() + " → " + entry.getValue() + " times");
            }

        } 
        catch (IOException e) 
        {
            System.out.println("⚠️ I/O error: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (reader != null) reader.close();
            } 
            catch (IOException e) 
            {
                System.out.println("⚠️ Error closing reader: " + e.getMessage());
            }
        }
    }
}

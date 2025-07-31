import java.io.*;

class Error_Log_Reader 
{
    public static void main(String[] args) 
    {
        String inputFile = "input.txt";  // Large file to scan

        BufferedReader reader = null;

        try 
        {
            reader = new BufferedReader(new FileReader(inputFile));
            String line;

            while ((line = reader.readLine()) != null) 
            {
                // Case-insensitive check for "error"
                if (line.toLowerCase().contains("error")) 
                {
                    System.out.println(line);
                }
            }
        } 
        catch (IOException e) 
        {
            System.out.println("⚠️ I/O error occurred: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (reader != null) reader.close();
            } 
            catch (IOException e) 
            {
                System.out.println("⚠️ Error closing file: " + e.getMessage());
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class WordCount {

//---------------------------------------------------------------------------------------

    public void CountWords() {

        // This method opens the text files, counts the words in it, and displays it on
        // console.

        try {
            File f1 = new File("passage.txt"); // Creation of File Descriptor for input file
            String[] words = null; // Intialize the word Array
            int wc = 0; // Intialize word count to zero
            FileReader fr = new FileReader(f1); // Creation of File Reader object
            BufferedReader br = new BufferedReader(fr); // Creation of BufferedReader object
            String s;

            while ((s = br.readLine()) != null) // Reading Content from the file
            {
                words = s.split(" "); // Split the word using space
                wc = wc + words.length; // increase the word count for each word
            }
            fr.close();
            System.out.println("\nNumber of words in the file: " + (wc - 2) + "\n"); // Print the word count
        } catch (Exception e) {
            System.out.println("Something did not work:(");
        }
    }

}
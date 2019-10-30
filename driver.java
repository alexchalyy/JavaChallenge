import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class JavaCodingChallenge {

//---------------------------------------------------------------------------------------
    public static void main(String args[]) throws IOException

    /*
     * 
     * This Java program reads a text file and does the following:
     * 
     * 1. Give a total word count.
     * 
     * 2. Identify the top 10 words used and display them in sorted order.
     * 
     * 3. Pull the last sentence on the file that contains the most used word.
     * 
     * Your output can be written directly to the console window or a log.
     * 
     * Written by Alex Chalyy on 10/29/2019.
     */

    {
        WordCount wc = new WordCount();
        WordFrequency wf = new WordFrequency(); 

        wc.CountWords(); // Give a total word count.
        wf.CalculateFrequency(); // Gives 10 most frequently used words from the given text file.
    }
}
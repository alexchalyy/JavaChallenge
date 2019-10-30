import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordFrequency {

    private static String[] w = null;
    private static int[] r = null;
    private static String MostUsed = null;

    public void CalculateFrequency() {

        // This method calculates and displays 10 most frequently used words from a
        // given text file and displays them in sorted order from the most frequently
        // used.
        //
        // This method also displays the sentence with the last occurance of the the most frequently used word.

        try {
            int n = 10;
            w = new String[n];
            r = new int[n];
            FileReader fr = new FileReader("passage.txt");
            BufferedReader br = new BufferedReader(fr);
            String text = "";
            String sz = null;

            while ((sz = br.readLine()) != null) {
                text = text.concat(sz);
            }
            String[] words = text.split(" ");
            String[] uniqueLabels;
            int count = 0;
            uniqueLabels = getUniqLabels(words);
            for (int j = 0; j < n; j++) {
                r[j] = 0;
            }
            for (String l : uniqueLabels) {
                if ("".equals(l) || null == l) {
                    break;
                }
                for (String s : words) {
                    if (l.equals(s)) {
                        count++;
                    }
                }

                for (int i = 0; i < n; i++) {
                    if (count > r[i]) {
                        r[i] = count;
                        w[i] = l;
                        break;
                    }
                }
                count = 0;
            }
            System.out.println("These are the top 10 most used words in the text file with their appropriate counts.\n");
            display(n);
            DisplaySentence(words);
        } catch (Exception e) {
            System.err.println("ERR " + e.getMessage());
        }
    }

    // ---------------------------------------------------------------------------------

    public static void DisplaySentence(String[] words) {

    //  This method displays the last sentence with the most frequently used word.

        String t = "";

        for (int i = 0; i < words.length; i++) {
            t += words[i] + " ";
        }
        String a[]=t.split("\\.|\\?|\\!");
        for (int c = a.length - 2; c >= 0; c--) {
            if (a[c].contains(MostUsed))    {
                System.out.println("\nThis is the last sentence in the text with the most frequently used word: \n");
                System.out.println(a[c]);
                break;
            }
        }
    }

    // --------------------------------------------------------------------------------

    public static void display(int n) {

    //  This method displays n most frequently used words, and also calculates the most frequently used word.

        for (int k = 0; k < n; k++) {
            if (k == 0) {
                MostUsed = w[k];
            }
            System.out.println("Label :: " + w[k] + "\tCount :: " + r[k]);
        }
    }

    // --------------------------------------------------------------------------------

    private static String[] getUniqLabels(String[] keys)

    // Return string array of unique words in text file.

    {
        String[] uniqueKeys = new String[keys.length];

        uniqueKeys[0] = keys[0];
        int uniqueKeyIndex = 1;
        boolean keyAlreadyExists = false;

        for (int i = 1; i < keys.length; i++) {
            for (int j = 0; j <= uniqueKeyIndex; j++) {
                if (keys[i].equals(uniqueKeys[j])) {
                    keyAlreadyExists = true;
                }
            }

            if (!keyAlreadyExists) {
                uniqueKeys[uniqueKeyIndex] = keys[i];
                uniqueKeyIndex++;
            }
            keyAlreadyExists = false;
        }
        return uniqueKeys;
    }
}
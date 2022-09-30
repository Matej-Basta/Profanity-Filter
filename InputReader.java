import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    
    private List<String> swearWords;
    private List<String> rest;
    

    public InputReader() {

        swearWords = new ArrayList<>();
        rest = new ArrayList<>();
        
        readInput();

    }

    /* 
     * Reading the input from the user and dividing it
     * into swear words and rest of the tweet.
     */
    public void readInput() {
        Scanner scanner = new Scanner(System.in);
        //putting each swear word into a swearWords list
        createListOfSwearWords(scanner.nextLine());
        //adding all lines into a rest list
        while (scanner.hasNextLine()) {
            rest.add(scanner.nextLine());
        }
        scanner.close();
    }

    /* 
     * Takes every word in a line and places it into a list
     * @param tweet First line of a tweet, that contains the swear words
     */
    public void createListOfSwearWords(String tweet) {
        String[] arrayOfSwearWords = tweet.split(" ");
        for(String word : arrayOfSwearWords) {
            swearWords.add(word.toLowerCase());
        }
    }

    public List<String> getSwearWords() {
        return swearWords;
    }

    public List<String> getRest() {
        return rest;
    }
}

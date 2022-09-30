import java.util.List;

public class ProfanityFilter {
    
    private String filteredTweet;
    private String[] characters;
    private InputReader inputReader;

    public ProfanityFilter() {
        filteredTweet = "";
        characters = new String[]{"*", "&", "#", "$", "%"};
        inputReader = new InputReader();
        filteringTweet();
    }

    public void filteringTweet() {
        
        List<String> tweet = inputReader.getRest();
        List<String> swearWords = inputReader.getSwearWords();
        
        //looping through every line in a tweet
        for (int i = 0; i < tweet.size(); i++) {

            String line = tweet.get(i);
            String[] arrayOfWords = getArrayOfWords(line);

            //looping through every word in a line
            for (int j = 0; j < arrayOfWords.length; j++) {

                //looping through every swear word
                for (int k = 0; k < swearWords.size(); k++) {
                    
                    if (arrayOfWords[j].toLowerCase().replaceAll("[,.?!]", "").equals(swearWords.get(k))) {
                        arrayOfWords[j] = censorSwearWord(arrayOfWords[j]);
                    }
                }
            }
            
            String newLine = String.join(" ", arrayOfWords);
            filteredTweet += newLine + "\n";

        }
    }

    /* 
     * Taking a word and replacing every character (except .,?!) with a symbol
     * @param word The word that is supposed to be replaced.
     * @return String Word, whose letters were replaced by symbols.
     */
    private String censorSwearWord(String word) {
        String[] letters = word.split("");
        for (int l = 0; l < letters.length; l++) {
            if (!letters[l].equals(".") && !letters[l].equals(",") && !letters[l].equals("?") && !letters[l].equals("!")) {
                letters[l] = characters[l % 5];
            }
        }
        String censoredWord = String.join("", letters);
        return censoredWord;
    }

    /* 
     * Takes every word in a line and places it into a list
     * @param string an individual line of a tweet
     */
    private String[] getArrayOfWords(String string) {
        String[] arrayOfWords = string.split(" ");
        return arrayOfWords;
    }

    public String getResult() {
        return filteredTweet;
    }

}

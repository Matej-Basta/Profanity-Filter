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
        
        for (int i = 0; i < tweet.size(); i++) {

            String line = tweet.get(i);
            String[] arrayOfWords = getArrayOfWords(line);

            for (int j = 0; j < arrayOfWords.length; j++) {

                for (int k = 0; k < swearWords.size(); k++) {
                    
                    if (arrayOfWords[j].toLowerCase().replaceAll("[,.?!]", "").equals(swearWords.get(k))) {
                        String[] individualWord = arrayOfWords[j].split("");
                        for (int l = 0; l < individualWord.length; l++) {
                            if (!individualWord[l].equals(".") && !individualWord[l].equals(",") && !individualWord[l].equals("?") && !individualWord[l].equals("!")) {
                                individualWord[l] = characters[l % 5];
                            }     
                        }
                        String changedWord = String.join("", individualWord);
                        arrayOfWords[j] = changedWord;
                    }
                }
            }
            
            String newLine = String.join(" ", arrayOfWords);
            filteredTweet += newLine + "\n";

        }
    }

    private String[] getArrayOfWords(String string) {
        String[] arrayOfWords = string.split(" ");
        return arrayOfWords;
    }

    public String getResult() {
        return filteredTweet;
    }

}

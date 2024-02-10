package Words_frequency_cnt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TextReader {

    public HashMap<String, Integer> DICTIONARY;
    public int WORDS_CNT;

    public int getWordsCnt() {
        return this.WORDS_CNT;
    }

    public void plusWordsCnt() {
        this.WORDS_CNT += 1;
    }

    public TextReader(){
        this.DICTIONARY = new HashMap<>();
        this.WORDS_CNT = 0;
    }

    public void read_file(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename));) {

            String line = reader.readLine();
            while (line != null) {
                int len = line.length();
                String word = "";
                for (int i = 0; i < len; i++) {
                    if (Character.isLetterOrDigit(line.charAt(i))) {
                        word = word + line.charAt(i);
                    } else {
                        if (!(word == "")) {
                            if (DICTIONARY.containsKey(word)) {
                                DICTIONARY.put(word, DICTIONARY.get(word) + 1);
                            } else {
                                DICTIONARY.put(word, 1);
                            }
                            plusWordsCnt();
                        }
                        word = "";
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Integer> return_dictionary() {
        return this.DICTIONARY;

    }
}

package Words_frequency_cnt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Text_Reader {

    public static HashMap<String, Integer> DICTIONARY = new HashMap<>();
    public static int WORDS_CNT = 0;

    public static int get_words_cnt() {
        return WORDS_CNT;
    }

    public static void plus_words_cnt() {
        WORDS_CNT += 1;
    }

    public static void read_file(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
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
                            plus_words_cnt();
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

    public static HashMap<String, Integer> return_dictionary() {
        return DICTIONARY;

    }
}

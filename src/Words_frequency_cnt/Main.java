package Words_frequency_cnt;

import java.io.IOException;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        TextReader reader = new TextReader();
        CSVWriter writer = new CSVWriter();
        reader.read_file(args[0]);
        HashMap<String, Integer> dictionary = reader.return_dictionary();
        dictionary = writer.sort_dictionary(dictionary);
        int words_cnt = reader.getWordsCnt();
        writer.write_to_csv(dictionary, words_cnt, args[1]);
    }
}



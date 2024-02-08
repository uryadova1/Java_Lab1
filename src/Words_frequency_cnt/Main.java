package Words_frequency_cnt;

import java.io.IOException;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        Text_Reader reader = new Text_Reader();
        CSV_Writer writer = new CSV_Writer();
        reader.read_file(args[0]);
        HashMap<String, Integer> dictionary = reader.return_dictionary();
        dictionary = writer.sort_dictionary(dictionary);
        int words_cnt = reader.get_words_cnt();
        writer.write_to_csv(dictionary, words_cnt, args[1]);
    }
}



package Words_frequency_cnt;

import java.io.IOException;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        TextReader reader = new TextReader();
        CSVWriter writer = new CSVWriter();
        reader.readFile(args[0]);
        HashMap<String, Integer> dictionary = reader.returnDictionary();
        dictionary = writer.SortDictionary(dictionary);
        int words_cnt = reader.getWordsCnt();
        writer.writeToCsv(dictionary, words_cnt, args[1]);
    }
}



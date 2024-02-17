package Words_frequency_cnt;

import java.util.*;
import java.io.*;

public class CSVWriter {

    public CSVWriter(){}
    public LinkedHashMap<String, Integer> SortDictionary(HashMap<String, Integer> dictionary) {
        ArrayList<Integer> list = new ArrayList<>();

        /*LinkedHashMap — это специальный вид HashMap,
        который сохраняет порядок добавления элементов.
        Это достигается за счет поддержки двусвязного списка
        элементов. Поэтому, при выводе элементов на экран,
        порядок их следования будет соответствовать порядку добавления.*/

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            list.add(entry.getValue());
        }
        list.sort(Collections.reverseOrder());
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        return sortedMap;
    }

    public void writeToCsv(HashMap<String, Integer> dictionary, int words_cnt, String filename) throws IOException {

        try (FileWriter csv_file = new FileWriter(filename, false)) {

            List<String> keys = new ArrayList<>(dictionary.keySet());
            for (String key : keys) {
                int value = dictionary.get(key);
                double num = ((double) value / words_cnt) * 100;
                String text = key + ";" + value + ";" + String.format("%f", num);
                csv_file.write(text);
                csv_file.append("\n");
                csv_file.flush();
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}

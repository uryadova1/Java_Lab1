package Words_frequency_cnt;

import java.util.*;
import java.io.*;

public class CSV_Writer {
    public static LinkedHashMap<String, Integer> sort_dictionary(HashMap<String, Integer> dictionary) {
        ArrayList<Integer> list = new ArrayList<>();

        /*Только что созданный объект linkedHashMap,
        помимо свойств унаследованных от HashMap
        (такие как table, loadFactor, threshold, size, entrySet и т.п.),
        так же содержит два доп. свойства:
        header — «голова» двусвязного списка.При инициализации указывает сам на себя;
        accessOrder — указывает каким образом будет осуществляться доступ к
        элементам при использовании итератора. При значении true — по порядку
        последнего доступа (об этом в конце статьи). При значении false доступ
        осуществляется в том порядке, в каком элементы были вставлены.*/

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, Collections.reverseOrder());
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        return sortedMap;
    }

    public static void write_to_csv(HashMap<String, Integer> dictionary, int words_cnt, String filename) throws IOException {

        try {
            FileWriter csv_file = new FileWriter(filename, false);
            List<String> keys = new ArrayList<String>(dictionary.keySet());
            for (int i = 0; i < keys.size(); i++) {
                String key = keys.get(i);
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

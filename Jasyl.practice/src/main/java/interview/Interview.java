package interview;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Description:
 * Author: lingyou
 * date: 2019-05-30 07:44
 */
public class Interview {

    //private static String file_path = "/Users/jason/6927.log";
    private static HashMap<String, Integer> result = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {


        //countWord("/Users/jason/1.txt");


    }

    //private static void countWord(String filePath) throws FileNotFoundException {
    //    File file = new File(filePath);
    //    String cuerrentLine = null;
    //    String[] currentWords = null;
    //    if (!file.exists()) {
    //        throw new FileNotFoundException("文件不存在");
    //
    //    }
    //    BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
    //    try {
    //        while ((cuerrentLine =br.readLine()) != null ) {
    //
    //            currentWords = cuerrentLine.split("[^a-zA-Z]");
    //
    //            for (int i = 0; i < currentWords.length; i++) {
    //
    //                if (currentWords[i].equals("")) {
    //                    continue;
    //
    //                }
    //                if (result.get(currentWords[i].toLowerCase()) == null) {
    //                    result.put(currentWords[i].toLowerCase(), 1);
    //
    //                } else {
    //                    //System.out.println(current_words[i] + " : " + result.get(current_words[i]));
    //                    result.put(currentWords[i].toLowerCase(), result.get(currentWords[i].toLowerCase()) + 1);
    //                }
    //
    //            }
    //
    //        }
    //        br.close();
    //
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //
    //
    //    for (Map.Entry<String, Integer> entry : result.entrySet()) {
    //
    //        System.out.println(entry.getKey() + ":" + entry.getValue());
    //
    //    }
    //}
}

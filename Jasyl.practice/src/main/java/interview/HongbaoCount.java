package interview;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 *
 * Author: lingyou
 * date: 2019-05-31 20:32
 */
public class HongbaoCount implements Runnable {

    private static String hongbaoPath = "/Users/jason/hongbao/";

    private static String accountPath = "/Users/jason/account/";

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(50, this);

    private static ExecutorService hongbaoExecutor = Executors.newFixedThreadPool(10);

    private static ExecutorService accountExecutor = Executors.newFixedThreadPool(10);


    /**
     * 每个红包文件id的中money的集合
     */
    private Vector<HashMap<String, BigDecimal>> hongbaoVector = new Vector<>();

    public static void main(String[] args) {

        HongbaoCount hongbaoCount = new HongbaoCount();
        hongbaoCount.calcHongbaoMoney();

    }


    /**
     * 计算50个红包的对应id的中金额
     * 放入到hongbaoVector集合中
     */
    public void calcHongbaoMoney() {
        for (int i = 1; i <= 50; i++) {
            String hongbaoFilePath = hongbaoPath + i + ".txt";
            hongbaoExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        countHongbaoMoney(hongbaoFilePath);
                        cyclicBarrier.await();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        hongbaoExecutor.shutdown();

    }


    /**
     * 计算每个红包文件的下id的总money
     *
     * @param filePath
     * @throws FileNotFoundException
     */
    private void countHongbaoMoney(String filePath) throws FileNotFoundException {
        //id:money
        HashMap<String, BigDecimal> result = new HashMap<>();

        File file = new File(filePath);
        String currentLine;

        BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
        try {
            while ((currentLine = br.readLine()) != null) {
                String[] currentWords = currentLine.split(" ");
                if (result.get(currentWords[0]) == null) {
                    result.put(currentWords[0], new BigDecimal(currentWords[1]));

                } else {
                    BigDecimal amount = result.get(currentWords[0]).add(new BigDecimal(currentWords[1]));
                    result.put(currentWords[0], amount);
                }

            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        hongbaoVector.add(result);

    }


    /**
     * 计算50个红包中id对应money的总值
     */
    @Override
    public void run() {

        HashMap<String, BigDecimal> resultMap = new HashMap<>();

        for (HashMap<String, BigDecimal> map : hongbaoVector) {

            for (Map.Entry<String, BigDecimal> entry : map.entrySet()) {
                String key = entry.getKey();
                BigDecimal value = entry.getValue();

                if (resultMap.get(key) == null) {
                    resultMap.put(key, value);
                } else {
                    resultMap.put(key, resultMap.get(key).add(value));
                }
            }
        }

        try {
            calc(resultMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 打开100个账户文件。获取id和账户金额， 然后与resultMap中的id对应的中金额相加，汇总成账户id和金额
     *
     * @param resultMap
     * @throws IOException
     */
    public void calc(HashMap<String, BigDecimal> resultMap) throws IOException {

        List<HashMap<String, BigDecimal>> result = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {

            int index = i;
            accountExecutor.execute(new Runnable() {
                @Override
                public void run() {

                    HashMap<String, BigDecimal> accountMap = new HashMap<>();

                    File file = new File(accountPath + index + ".txt");
                    String currentLine;
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
                        while ((currentLine = br.readLine()) != null) {
                            String[] currentWords = currentLine.split(" ");
                            String accountId = currentWords[0];
                            BigDecimal accountAmount = new BigDecimal(currentWords[1]);

                            BigDecimal hongbaoAmount = resultMap.get(accountId);
                            accountAmount = accountAmount.add(hongbaoAmount);

                            accountMap.put(accountId, accountAmount);
                            result.add(accountMap);
                        }
                        br.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });


        }

        writeResultToFile(result);

    }


    public void writeResultToFile(List<HashMap<String, BigDecimal>> result) throws IOException {

        int i = 1;
        for (HashMap<String, BigDecimal> hashMap : result) {

            FileWriter fw = new FileWriter(accountPath + i + ".txt");
            for (Map.Entry<String, BigDecimal> entry : hashMap.entrySet()) {
                String line = entry.getKey() + "" + entry.getValue().toString();

                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(line + "\r\n");

            }
            i++;

        }
    }
}

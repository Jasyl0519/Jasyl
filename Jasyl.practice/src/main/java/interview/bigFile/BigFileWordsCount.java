package interview.bigFile;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * Author: lingyou
 * date: 2019-05-30 22:00
 */
public class BigFileWordsCount implements Runnable {


    private static String filePath = "/Users/jason/data/1.txt";

    private CyclicBarrier c = new CyclicBarrier(10, this);

    private static ExecutorService executor = Executors.newFixedThreadPool(10);


    private Vector<HashMap<String, Integer>> vector = new Vector<>();

    private static final long startTime = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {
        //createBigFile();
        //splitFile(filePath, 10);
        //System.out.println("分隔文件耗费时间： " + (System.currentTimeMillis() - startTime) + " ms");

        BigFileWordsCount bigFile = new BigFileWordsCount();
        bigFile.count();




    }

    public void count() {
        for (int i = 1; i <= 10; i++) {
            String filePath1 = filePath + i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        countWord(filePath1);
                        c.await();
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

        executor.shutdown();

    }

    public static void createBigFile() throws IOException {
        File file = new File("/Users/jason/data/1.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String str = "ni hao, today is friday. how are you. Thread-0 #10 prio=5 os_prio=31 tid=0x00007ff70d8d7800 " + "nid=0x4f03 waiting for monitor the 你去死吧，神经病。entry [0x000070000f7e0000] C2 CompilerThread0 #5 daemon " + "prio=9 os_prio=31 tid=0x00007ff70e010800 nid=0x4303 waiting on condition [0x0000000000000000] Java stack information for the threads listed above:\n" + "===================================================\n" + "\"Thread-1\":\n" + "\tat lock.deadlock.DeadLockDemo.lambda$deadLock$1(DeadLockDemo.java:39)\n" + "\t- waiting to lock <0x0000000795780f00> (a java.lang.String)\n" + "\t- locked <0x0000000795780f30> (a java.lang.String)\n" + "\tat lock.deadlock.DeadLockDemo$$Lambda$2/1751075886.run(Unknown Source)\n" + "\tat java.lang.Thread.run(Thread.java:745)\n" + "\"Thread-0\":\n" + "\tat lock.deadlock.DeadLockDemo.lambda$deadLock$0(DeadLockDemo.java:29)\n" + "\t- waiting to lock <0x0000000795780f30> (a java.lang.String)\n" + "\t- locked <0x0000000795780f00> (a java.lang.String)\n" + "\tat lock.deadlock.DeadLockDemo$$Lambda$1/401625763.run(Unknown Source)\n" + "\tat java.lang.Thread.run(Thread.java:745)\n" + "\n" + "Found 1 deadlock.";

        for (int i = 0; i < 1000000; i++) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();

    }

    public static void splitFile(String filePath, int fileCount) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        FileChannel inputChannel = fis.getChannel();
        final long fileSize = inputChannel.size();
        long average = fileSize / fileCount;//平均值
        long bufferSize = 200; //缓存块大小，自行调整
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) bufferSize); // 申请一个缓存区
        long startPosition = 0; //子文件开始位置
        long endPosition = average < bufferSize ? 0 : average - bufferSize;//子文件结束位置
        for (int i = 0; i < fileCount; i++) {
            if (i + 1 != fileCount) {
                int read = inputChannel.read(byteBuffer, endPosition);// 读取数据
                readW:
                while (read != -1) {
                    byteBuffer.flip();//切换读模式
                    byte[] array = byteBuffer.array();
                    for (int j = 0; j < array.length; j++) {
                        byte b = array[j];
                        if (b == 10 || b == 13) { //判断\n\r
                            endPosition += j;
                            break readW;
                        }
                    }
                    endPosition += bufferSize;
                    byteBuffer.clear(); //重置缓存块指针
                    read = inputChannel.read(byteBuffer, endPosition);
                }
            } else {
                endPosition = fileSize; //最后一个文件直接指向文件末尾
            }

            FileOutputStream fos = new FileOutputStream(filePath + (i + 1));
            FileChannel outputChannel = fos.getChannel();
            inputChannel.transferTo(startPosition, endPosition - startPosition, outputChannel);//通道传输文件数据
            outputChannel.close();
            fos.close();
            startPosition = endPosition + 1;
            endPosition += average;
        }
        inputChannel.close();
        fis.close();

    }


    @Override
    public void run() {

        // 使用TreeMap保证结果有序（按首字母排序）
        TreeMap<String, Integer> tMap = new TreeMap<String, Integer>();

        for (HashMap<String, Integer> map : vector) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

                if (tMap.get(key) == null) {
                    tMap.put(key, value);
                } else {
                    tMap.put(key, tMap.get(key) + value);
                }
            }
        }


        List<Map.Entry<String, Integer>> result = new ArrayList<Map.Entry<String, Integer>>(tMap.entrySet());

        Collections.sort(result, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });


        for (Map.Entry<String, Integer> entry : result) {
            System.out.println(entry.getKey() + ":" + entry.getValue());

        }

        long endTime = System.currentTimeMillis();
        System.out.println("耗费时间： " + (endTime - startTime) + " ms");

    }


    private void countWord(String filePath) throws FileNotFoundException {
        HashMap<String, Integer> result = new HashMap<>();

        File file = new File(filePath);
        String cuerrentLine = null;
        String[] currentWords = null;
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在");

        }
        BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
        try {
            while ((cuerrentLine = br.readLine()) != null) {

                currentWords = cuerrentLine.split("[^a-zA-Z]");

                for (int i = 0; i < currentWords.length; i++) {

                    if (currentWords[i].equals("")) {
                        continue;

                    }
                    if (result.get(currentWords[i].toLowerCase()) == null) {
                        result.put(currentWords[i].toLowerCase(), 1);

                    } else {
                        result.put(currentWords[i].toLowerCase(), result.get(currentWords[i].toLowerCase()) + 1);
                    }

                }

            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        vector.add(result);

    }
}

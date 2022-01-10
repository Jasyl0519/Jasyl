package concurrent;

public class SyncDemo {

    public static void main(String[] args) {
        SyncDemo syncDemo = new SyncDemo();
        syncDemo.test();
    }

    public void test() {
        StringBuffer sb = new StringBuffer();
        sb.append("hello").append("java");
        System.out.println(sb.toString());
    }
}

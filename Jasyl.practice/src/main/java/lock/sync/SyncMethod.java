package lock.sync;

/**
 * Description:
 * Author: lingyou
 * date: 2018-11-18 下午6:37
 */
public class SyncMethod {

    public int i;

    public synchronized void syncTask(){
        i++;
    }
}
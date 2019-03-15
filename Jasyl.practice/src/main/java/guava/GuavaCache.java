package guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2019-01-24 下午7:42
 */
public class GuavaCache {

    public static void main(String[] args) throws ExecutionException {

        CacheLoader<String, String> cacheLoader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                Thread.sleep(1000); //休眠1s，模拟加载数据
                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }
        };

        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().maximumSize(3).build(cacheLoader);

        loadingCache.get("key1");
        loadingCache.get("key2");
        loadingCache.get("key3");
        loadingCache.get("key4");
        loadingCache.get("key5");
        loadingCache.get("key1");
    }
}

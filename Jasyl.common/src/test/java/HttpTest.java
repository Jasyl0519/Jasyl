import HttpTool.HttpUrlUtil;
import HttpTool.ParamGenerator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jason on 16/4/13.
 */

@Slf4j
public class HttpTest {


    @Test
    public void test() {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", "jason");
        map.put("name1", "jason");
        map.put("name2", "你好");
        String param = ParamGenerator.wrapParam(map);
        log.info("hi:{}", param);

        try {
            String decodeStr = URLDecoder.decode(param, "utf-8");
            log.info("hi:{}", decodeStr);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String url = "http://10.0.0.17:8080/legend/pub/shop/service/category";


        String result = HttpUrlUtil.sendGet(url, "");

        try {
            ObjectMapper mapper = new ObjectMapper();
            //Map<String, Object> resultMap = mapper.readValue(result, Map.class);//String转化为map

            Map<String, Object> resultMap = new Gson().fromJson(result, new TypeToken<Map<String, Object>>(){}
                    .getType());

            log.info(mapper.writeValueAsString(resultMap.get("data")));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

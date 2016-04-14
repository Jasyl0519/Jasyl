import HttpTool.HttpClientUtil;
import HttpTool.ParamGenerator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import security.Base64Coder;

import java.io.IOException;
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

        map.put("userGlobalId", "669713");
        /*map.put("name1", "jason");
        map.put("name2", "你好");*/


        String param = ParamGenerator.wrapParam(map);
        log.info("hi:{}", param);

        try {


            log.info("hi:{}", Base64Coder.encode(param));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //String url = "http://10.0.0.17:8080/legend/pub/shop/service/category";
        String url = "http://10.0.0.17:8080/legend/pub/member/info_list";


        String result = HttpClientUtil.sendGet(url, map);

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


    @Test
    public void test1() throws Exception {

        String a = "123中";
        byte[] pArray = a.getBytes("UTF-8");

        System.out.println(pArray);
        System.out.println(pArray.length);
        System.out.println(10.67%4);


    }

}

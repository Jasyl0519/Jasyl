import jsonUtil.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import security.SHACoder;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by jason on 16/4/13.
 */

@Slf4j
public class HttpTest {


    /*@Test
    public void test.test() {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userGlobalId", "669713");
        *//*map.put("name1", "jason");
        map.put("name2", "你好");*//*


        String param = ParamGenerator.wrapParam(map);
        log.info("hi:{}", param);

        try {


            log.info("hi:{}", Base64Coder.encode(param));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //String url = "http://10.0.0.17:8080/legend/pub/shop/service/category";
        String url = "http://10.0.0.17:8080/legend/pub/member/info_list";


        String result = httpTool.HttpClientUtil.sendGet(url, map);

        try {
            ObjectMapper mapper = new ObjectMapper();
            //Map<String, Object> resultMap = mapper.readValue(result, Map.class);//String转化为map

            Map<String, Object> resultMap = new Gson().fromJson(result, new TypeToken<Map<String, Object>>(){}
                    .getType());

            log.info(mapper.writeValueAsString(resultMap.get("data")));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/


    @Test
    public void test1() throws Exception {

        String a = "123中国";

        byte[] pArray = a.getBytes("UTF-8");


        System.out.println(SHACoder.encodeSHAHex(a, "SHA").equals(SHACoder.encodeHex(a)));

        System.out.println(SHACoder.encodeSHAHex(a));
        System.out.println(SHACoder.encodeHex(a));


    }

    @Test
    public void test2() throws Exception {

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        ListIterator<String> li = list.listIterator();

        while(li.hasNext()) {
            String str = li.next();
            System.out.println(str);

            li.set("5");
            System.out.println(JSONUtil.object2Json(li));

        }

        /*for (ListIterator<String> li = list.listIterator(); li.hasNext();) {

            li.next();
            li.set("5");



        }*/

        System.out.println(list);

    }


}

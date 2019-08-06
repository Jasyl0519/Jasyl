package json;

import com.alibaba.fastjson.JSON;

/**
 * Description:
 * Author: lingyou
 * date: 2019-04-28 23:11
 */
public class JsonObject {

    private String name;
    private String idcard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public static void main(String[] args) {

        JsonObject object = new JsonObject();
        object.setName("jason");
        object.setIdcard("123456");

        String str = JSON.toJSONString(object);
        System.out.println(str);

        Integer a = 1;
        Integer b = 2;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        

        Integer c = 3;
        Long g = 3L;

        System.out.println(g.equals(c));
        System.out.println(c.equals(g));

    }
}

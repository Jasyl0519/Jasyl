package jsonUtil;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 16/4/13.
 *
 * json 工具类
 */

@Slf4j
public class JSONUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Object2JSON的转化
     *
     * @param obj
     * @return
     */
    public static String object2Json(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (IOException e) {
            log.error("parse Object to String error", e);
        }

        return null;
    }

    /**
     * jsonArray转化成list，泛型不确定
     */
    public static <T> List<T> jsonStr2List(String jsonStr, Class<?> clazz) {
        List<T> list = new ArrayList();
        try {
            // 指定容器结构和类型（这里是ArrayList和clazz）
            TypeFactory t = TypeFactory.defaultInstance();
            list = mapper.readValue(jsonStr,
                    t.constructCollectionType(ArrayList.class, clazz));
        } catch (IOException e) {
            log.error("反序列化序列化attributes，从Json到List报错", e);
        }
        return list;
    }

    public static <T> T readValue(String o, Class<T> clazz) {
        try {
            return mapper.readValue(o, clazz);
        } catch (IOException e) {
            log.error("反序列化到对象错误", e);
        }
        return null;
    }

    public static <T> T readJson(String jsonStr, Class<?> collectionClass,
                                 Class<?>... elementClasses) {
        ObjectMapper mapper = new ObjectMapper();

        JavaType javaType =
                mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);

        try {
            return mapper.readValue(jsonStr, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }
}

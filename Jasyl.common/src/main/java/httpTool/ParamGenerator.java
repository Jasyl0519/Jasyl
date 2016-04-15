package httpTool;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jason on 16/4/13.
 *
 * GET方法 参数拼接
 */

@Slf4j
public class ParamGenerator {


    public static String wrapParam(Map<String, Object> paramMap) {

        String result = "";
        if (CollectionUtils.isEmpty(paramMap)) {
            return result;
        }

        try {
            List<String> paramList = new ArrayList<String>();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                paramList.add(String.format("%s=%s", entry.getKey(), URLEncoder.encode(String.valueOf(entry.getValue()), "utf-8")));
            }
            result = StringUtils.join(paramList.toArray(), "&");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;

    }
}

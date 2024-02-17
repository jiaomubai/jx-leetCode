package bank.zhongguanghe;

import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.client.RestClient;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.result.ApiResult;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.utils.FileUtils;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.utils.ParamUtils;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.utils.UUIDUtil;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.utils.UrlUtil;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.utils.ValidatorUtil;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.vo.CgnRequestHeader;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.vo.CgnRequestWrapper;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.vo.CgnResponseWrapper;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;



/**
 * @author jiaoxian
 * @name bank.zhongguanghe
 * @date 2023/8/3 9:03
 * @description TODO
 */
public class RestClientYonyou {

    private static RestTemplate restTemplate = new RestTemplate();

    public RestClientYonyou() {
    }

    public ApiResult postCgnMapForRest(String url, CgnRequestHeader cgnRequestHeader, Map<String, Object> map) {
        return this.wrapperHeaderAndMapForJsonResult(url, cgnRequestHeader, map, HttpMethod.POST);
    }

    private ApiResult wrapperHeaderAndMapForJsonResult(String url, CgnRequestHeader cgnRequestHeader, Map<String, Object> map, HttpMethod httpMethod) {
        if (StringUtils.isEmpty(url)) {
            return ApiResult.failMessage("url不能为空");
        } else {
            String validate = ValidatorUtil.validate(cgnRequestHeader);
            if (validate != null) {
                return ApiResult.failMessage(validate);
            } else {
                cgnRequestHeader.setRequestId(UUIDUtil.getUUID());
                int retryCount = 0;
                HttpHeaders httpHeaders = setHttpHeader(cgnRequestHeader);
                if (httpHeaders == null) {
                    return ApiResult.failMessage("cgnHead为空");
                } else {
                    HttpEntity<String> httpEntity = new HttpEntity((Object)null, httpHeaders);
                    while(true) {
//                        try {
                            ApiResult apiResult = new ApiResult();
                            if (map == null) {
                                apiResult = restTemplate.exchange(url, httpMethod, httpEntity, ApiResult.class, new Object[0]).getBody();
                            } else {
                                apiResult = restTemplate.exchange(UrlUtil.expandURL(url, map.keySet()), httpMethod, httpEntity, ApiResult.class, map).getBody();
                            }

                            if (apiResult == null) {
                                return ApiResult.failMessage("restTemplate.exchange() 返回结果为空");
                            }
                            return apiResult;
//                        } catch (Exception e) {
//                            if (retryCount >= 0) {
//                                System.out.println(e);
//                                return ApiResult.failMessage("连接服务端失败");
//                            }
//
//                            ++retryCount;
//                        }
                    }
                }
            }
        }
    }
    private HttpHeaders setHttpHeader(Object cgnRequestHeader) {
        if (cgnRequestHeader == null) {
            return null;
        } else {
            HttpHeaders httpHeaders = new HttpHeaders();
            Class clazz = cgnRequestHeader.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for(int i = 0; i < fields.length; ++i) {
                try {
                    Field field = fields[i];
                    field.setAccessible(true);
                    String name = field.getName();
                    Object value = field.get(cgnRequestHeader);
                    if (value != null) {
                        httpHeaders.set(field.getName(), value.toString());
                    }
                } catch (IllegalAccessException var9) {
                    var9.printStackTrace();
                }
            }

            return httpHeaders;
        }
    }
}


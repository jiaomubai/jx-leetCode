package bank.zhongguanghe;

import com.alibaba.fastjson.JSON;

/**
 * @author jiaoxian
 * @name bank.zhongguanghe
 * @date 2023/8/4 17:21
 * @description TODO
 */
public class RequestHeader {

    private String tenantId;

    private String tenantCode;

    private String tenantName;

    private String userId;

    private String appId;

    private String appCode;

    private String appName;

    private String appKey;

    private String appSecret;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public static void main(String[] args) {
        String requestData = "{\"tenantId\":\"1\",\"userId\":\"1\",\"appId\":\"itms\",\"appKey\":\"a000a5a704834fd6bcee35ee83371eb4e\",\"appSecret\":\"4398bafe013a4761888557e61c7b24e7\",\"tenantCode\":\"\",\"tenantName\":\"\",\"appCode\":\"\",\"appName\":\"\"}";
        RequestHeader requestHeader = JSON.parseObject(requestData, RequestHeader.class);

    }

}

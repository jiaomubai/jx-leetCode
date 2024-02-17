package bank.zlbp.dto;

import com.alipay.mychain.gov.sdk.base.GenericResult;

import java.util.List;
import java.util.Map;

/**
 * @author jiaoxian
 * @name bank.zlbp.dto
 * @date 2023/12/18 13:42
 * @description TODO
 */
public class DecrytpResultDTO extends GenericResult {

    /**
     *
     */
    private static final long serialVersionUID = 4969504039290397275L;

    private byte[] fileContentByte;

    private List<Map<String, Object>> fileInfoList;

    public List<Map<String, Object>> getFileInfoList() {
        return fileInfoList;
    }

    public void setFileInfoList(List<Map<String, Object>> fileInfoList) {
        this.fileInfoList = fileInfoList;
    }



    public byte[] getFileContentByte() {
        return fileContentByte;
    }

    public void setFileContentByte(byte[] fileContentByte) {
        this.fileContentByte = fileContentByte;
    }

}
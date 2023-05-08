package findWords;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiaoxian
 * @name findWords
 * @date 2023/2/23 17:22
 * @description leetCode-500: 键盘行
 */
public class FindWords {

//    static String str = "{\"header\":{\"signData\":\"\",\"charset\":\"UTF-8\",\"requestId\":\"20230306110135137240721\",\"responseTime\":\"20230306110136\",\"appId\":\"247733027057001\",\"errorCode\":\"0000000000\",\"callbackUrl\":\"\",\"accessToken\":\"\",\"responseId\":\"20230306110136403247733027057001706\",\"errorMsg\":\"\"},\"body\":{\"receiptDtos\":[{\"msg\":\"操作成功\",\"code\":\"000000\",\"billInfo\":[{\"transName\":\"\",\"transSequenceno\":\"1407727\",\"accountName\":\"张家口市宣化宜家陶瓷卫浴超市\",\"billType\":\"\",\"taxInfo\":{\"taxInfo\":[{\"transAmount\":\"30.00\",\"upperTransAmount\":\"叁拾元整\",\"feeService\":\"账户管理费\"}]},\"payerAccount\":\"*qjdes*31AFD1BBCCADF1C73696650B53867B810A709158E660130675EED6BA73C8F0E1*qjdes*\",\"totalAmount\":\"30.00\",\"auxilarySequenceno\":\"\",\"feeOrganization\":\"牌楼西支行\",\"transDate\":\"20230207\",\"printCount\":\"1\",\"payerName\":\"张家口市宣化宜家陶瓷卫浴超市\",\"totalUpperAmount\":\"叁拾元整\",\"currency\":\"156\",\"oper\":\"\",\"transCode\":\"\",\"billNo\":\"01420041136230000002\",\"account\":\"174012019108019\",\"feeTime\":\"2020年第一季度\",\"createDate\":\"20200411\"},{\"transName\":\"\",\"transSequenceno\":\"1407727\",\"accountName\":\"河北铸辉水泥专用设备制造有限公司\",\"billType\":\"\",\"taxInfo\":{\"taxInfo\":[{\"transAmount\":\"60.00\",\"upperTransAmount\":\"陆拾元整\",\"feeService\":\"账户管理费\"}]},\"payerAccount\":\"*qjdes*31AFD1BBCCADF1C73696650B53867B810A709158E660130675EED6BA73C8F0E1*qjdes*\",\"totalAmount\":\"60.00\",\"auxilarySequenceno\":\"\",\"feeOrganization\":\"南关支行\",\"transDate\":\"20230207\",\"printCount\":\"0\",\"payerName\":\"河北铸辉水泥专用设备制造有限公司\",\"totalUpperAmount\":\"陆拾元整\",\"currency\":\"156\",\"oper\":\"\",\"transCode\":\"\",\"billNo\":\"01420041138380000003\",\"account\":\"154047061800015\",\"feeTime\":\"2020年第一季度\",\"createDate\":\"20200411\"},{\"transName\":\"\",\"transSequenceno\":\"1407727\",\"accountName\":\"张家口市友维科技有限公司\",\"billType\":\"\",\"taxInfo\":{\"taxInfo\":[{\"transAmount\":\"30.00\",\"upperTransAmount\":\"叁拾元整\",\"feeService\":\"账户管理费\"}]},\"payerAccount\":\"*qjdes*31AFD1BBCCADF1C73696650B53867B810A709158E660130675EED6BA73C8F0E1*qjdes*\",\"totalAmount\":\"30.00\",\"auxilarySequenceno\":\"\",\"feeOrganization\":\"解放街支行\",\"transDate\":\"20230207\",\"printCount\":\"0\",\"payerName\":\"张家口市友维科技有限公司\",\"totalUpperAmount\":\"叁拾元整\",\"currency\":\"156\",\"oper\":\"\",\"transCode\":\"\",\"billNo\":\"01420041152440000001\",\"account\":\"024015005808019\",\"feeTime\":\"2020年第一季度\",\"createDate\":\"20200411\"},{\"transName\":\"\",\"transSequenceno\":\"1407727\",\"accountName\":\"河北沃思商贸有限公司\",\"billType\":\"\",\"taxInfo\":{\"taxInfo\":[{\"transAmount\":\"3.00\",\"upperTransAmount\":\"叁元整\",\"feeService\":\"账户管理费\"}]},\"payerAccount\":\"*qjdes*31AFD1BBCCADF1C73696650B53867B810A709158E660130675EED6BA73C8F0E1*qjdes*\",\"totalAmount\":\"3.00\",\"auxilarySequenceno\":\"\",\"feeOrganization\":\"金马社区支行\",\"transDate\":\"20230207\",\"printCount\":\"0\",\"payerName\":\"河北沃思商贸有限公司\",\"totalUpperAmount\":\"叁元整\",\"currency\":\"156\",\"oper\":\"\",\"transCode\":\"\",\"billNo\":\"01420041196330000004\",\"account\":\"414039794300015\",\"feeTime\":\"2020年第一季度\",\"createDate\":\"20200411\"},{\"transName\":\"\",\"transSequenceno\":\"GCTS-202209162951998006\",\"accountName\":\"\",\"billType\":\"\",\"taxInfo\":{\"taxInfo\":[{\"transAmount\":\"-100.00\",\"upperTransAmount\":\"负壹佰元整\",\"feeService\":\"单位资信证明、询证函手续费\"}]},\"payerAccount\":\"*qjdes*31AFD1BBCCADF1C73696650B53867B810A709158E660130675EED6BA73C8F0E1*qjdes*\",\"totalAmount\":\"-100.00\",\"auxilarySequenceno\":\"GCTS-202209162951998006\",\"feeOrganization\":\"围场支行\",\"transDate\":\"20230207\",\"printCount\":\"0\",\"payerName\":\"围场满族蒙古族自治县围场镇腾安汽车维修服务中心\",\"totalUpperAmount\":\"负壹佰元整\",\"currency\":\"156\",\"oper\":\"6496\",\"transCode\":\"\",\"billNo\":\"01422091710860000004\",\"account\":\"\",\"feeTime\":\"\",\"createDate\":\"20220917\"},{\"transName\":\"\",\"transSequenceno\":\"GCTS-202209162924864005\",\"accountName\":\"\",\"billType\":\"\",\"taxInfo\":{\"taxInfo\":[{\"transAmount\":\"100.00\",\"upperTransAmount\":\"壹佰元整\",\"feeService\":\"单位资信证明、询证函手续费\"}]},\"payerAccount\":\"*qjdes*31AFD1BBCCADF1C73696650B53867B810A709158E660130675EED6BA73C8F0E1*qjdes*\",\"totalAmount\":\"100.00\",\"auxilarySequenceno\":\"GCTS-202209162924864005\",\"feeOrganization\":\"总行营业部\",\"transDate\":\"20230207\",\"printCount\":\"0\",\"payerName\":\"张家口旅投科汇供应链有限公司\",\"totalUpperAmount\":\"壹佰元整\",\"currency\":\"156\",\"oper\":\"2035\",\"transCode\":\"\",\"billNo\":\"01422091772350000006\",\"account\":\"\",\"feeTime\":\"\",\"createDate\":\"20220917\"},{\"transName\":\"\",\"transSequenceno\":\"GCTS-202209162951237006\",\"accountName\":\"\",\"billType\":\"\",\"taxInfo\":{\"taxInfo\":[{\"transAmount\":\"-100.00\",\"upperTransAmount\":\"负壹佰元整\",\"feeService\":\"单位资信证明、询证函手续费\"}]},\"payerAccount\":\"*qjdes*31AFD1BBCCADF1C73696650B53867B810A709158E660130675EED6BA73C8F0E1*qjdes*\",\"totalAmount\":\"-100.00\",\"auxilarySequenceno\":\"GCTS-202209162951237006\",\"feeOrganization\":\"围场支行\",\"transDate\":\"20230207\",\"printCount\":\"0\",\"payerName\":\"围场满族蒙古族自治县围场镇腾安汽车维修服务中心\",\"totalUpperAmount\":\"负壹佰元整\",\"currency\":\"156\",\"oper\":\"6496\",\"transCode\":\"\",\"billNo\":\"01422091786400000005\",\"account\":\"\",\"feeTime\":\"\",\"createDate\":\"20220917\"}],\"bilCla\":\"14\"},{\"msg\":\"操作成功\",\"code\":\"000000\",\"billInfo\":[{\"bilNo\":\"00922091731960000002\",\"traTlr\":\"6575\",\"depPsnAcctNo\":\"1200530431560002553\",\"txnSrlNo\":\"22091601756605\",\"pyUpBrNm\":\"鸡泽支行\",\"pyUpPsnNm\":\"玉汝园8-1-1002陈赛通\",\"prtCnt\":\"0\",\"depPsnNm\":\"鸡泽县住房和城乡建设局\",\"depAmt\":\"15319.20\"},{\"bilNo\":\"00922091753410000003\",\"traTlr\":\"6788\",\"depPsnAcctNo\":\"1200510121560000548\",\"txnSrlNo\":\"22091602144070\",\"pyUpBrNm\":\"唐山分行营业部\",\"pyUpPsnNm\":\"南湖金地\",\"prtCnt\":\"0\",\"depPsnNm\":\"唐山百货大楼集团八方购物广场有限责任公司南湖金地购物分公司\",\"depAmt\":\"200.00\"},{\"bilNo\":\"00922091762680000001\",\"traTlr\":\"5789\",\"depPsnAcctNo\":\"174010041702015\",\"txnSrlNo\":\"22091602233811\",\"pyUpBrNm\":\"牌楼西支行\",\"pyUpPsnNm\":\"胡桂兰\",\"prtCnt\":\"1\",\"depPsnNm\":\"张家口市宣化区吉龙商业有限责任公司\",\"depAmt\":\"90000.00\"}],\"bilCla\":\"9\"}],\"respMsg\":\"成功\",\"respCode\":\"0000000000\"}}";



    public static void main1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("D:\\a.txt"));
        String str = br.readLine();

        Map<String, Object> map = JSON.parseObject(str, Map.class);
        Map<String, Object>  body = (Map<String, Object>) map.get("body");
        List<Map<String, Object>> receiptDtos = (List<Map<String, Object>>) body.get("receiptDtos");

        List<Map<String, Object>> rspList = new ArrayList<Map<String, Object>>();
        Map<String, String> billNoTypeMap = new HashMap<>();
        for(int i = 0; i < receiptDtos.size(); i++){
            if ("000000".equals(receiptDtos.get(i).get("code"))) {
                String billType = (String) receiptDtos.get(i).get("bilCla");
                List<Map<String, Object>> billInfo = (List<Map<String, Object>>) receiptDtos.get(i).get("billInfo");
                for(int j = 0; j < billInfo.size(); j++) {
                    rspList.addAll(billInfo);
                    String billNo = (String) billInfo.get(j).get("bilNo");
                    billNoTypeMap.put(billNo, billType);
                }
            }
        }
//        ctx.billNoTypeMap = billNoTypeMap;
        String queryExtendStr = "31";
        int queryExtend = Integer.valueOf(queryExtendStr) + 10;
        System.out.println();
    }

    public String[] findWords(String[] words) {
        int length = words.length;
        int index = 0;
        String[] resultTemp = new String[length];
        if (length > 0) {
            String first = "qwertyuiop";
            String second = "asdfghjkl";
            String third = "zxcvbnm";
            out:
            for (String s : words) {
                String word = s.toLowerCase();
                String firstWord = word.substring(0, 1);
                if (first.contains(firstWord)) {
                    for (int j = 1; j < word.length(); j++) {
                        String current = word.substring(j, j + 1);
                        if (!first.contains(current)) {
                            continue out;
                        }
                    }
                    resultTemp[index++] = s;
                    continue;
                }
                if (second.contains(firstWord)) {
                    for (int j = 1; j < word.length(); j++) {
                        String current = word.substring(j, j + 1);
                        if (!second.contains(current)) {
                            continue out;
                        }
                    }
                    resultTemp[index++] = s;
                    continue;
                }
                if (third.contains(firstWord)) {
                    for (int j = 1; j < word.length(); j++) {
                        String current = word.substring(j, j + 1);
                        if (!third.contains(current)) {
                            continue out;
                        }
                    }
                    resultTemp[index++] = s;
                }
            }
        }
        String[] result = new String[index];
        System.arraycopy(resultTemp, 0, result, 0, index);
        return result;
    }

    public static void main(String[] args) throws Exception {
////        String[] words = {"qwert", "sdf", "zxCV", "wsdcv"};
////        FindWords findWords = new FindWords();
////        System.out.println(Arrays.toString(findWords.findWords(words)));

        // 000000000900OK 5673000000567500
        // 000000000900OK 5673000000567500

        Integer fileLength = 5673;
        String str2 = "00OK " + fileLength.toString();
        System.out.println(str2);

        String tempStr1 = "0000000000" + str2.length();
        System.out.println(tempStr1);
        String str1 = tempStr1.substring(tempStr1.length() - 10);
        System.out.println(str1);

        int totalFileLength = 5673 + 2;
        String tempStr3 = "0000000000" + String.valueOf(totalFileLength);
        String str3 = tempStr3.substring(tempStr3.length() - 10) + "00";
        System.out.println(str3);

        String head = str1 + str2 + str3;
        System.out.println(head);

//        Integer maxByteSize = 1024;
//        Integer fileLength = 5673;
//        String fileName = "xxx.x";
//
//
//        // 计算需要下载的次数
//        int totalTimes = fileLength / maxByteSize + (fileLength % maxByteSize == 0 ? 0 : 1);
//
//        // 如果是一次
//        if (totalTimes == 1) {
//            String downLoadCommandBody = "00get " + fileName + " 0 " + fileLength;
//            int downLoadCommandBodyLength = downLoadCommandBody.length();
//            String downLoadCommandHead = "0000000000" + downLoadCommandBodyLength;
//            String downLoadCommandHeadNew = downLoadCommandHead.substring(downLoadCommandHead.length() - 10);
//            System.out.println(downLoadCommandHeadNew);
//            String downLoadCommand = downLoadCommandHeadNew + downLoadCommandBody;
//            System.out.println(downLoadCommand);
//            // 发送命令
//
//            // 接收数据
//
//
//        } else {
//            // 如果需要多次下载
//            for (int i = 1; i <= totalTimes; i++) {
//                // 第 i 次下载, [0, 1024] [1025, 1024] ...... [偏移量, 大小]
//                int startPos = (i - 1) * maxByteSize + (i == 1 ? 0 : 1);
//                int currentLength = (i == totalTimes ? (fileLength - ((i - 1) * maxByteSize)): maxByteSize);
//                // System.out.println("第 " + i + " 次下载: [" + startPos + ", " + currentLength + "]");
//                String downLoadCommandBody = "00get " + fileName + " " + startPos + " " + currentLength;
//                int downLoadCommandBodyLength = downLoadCommandBody.length();
//                String downLoadCommandHead = "0000000000" + downLoadCommandBodyLength;
//                String downLoadCommandHeadNew = downLoadCommandHead.substring(downLoadCommandHead.length() - 10);
////                System.out.println(downLoadCommandHeadNew);
//                String downLoadCommand = downLoadCommandHeadNew + downLoadCommandBody;
//                System.out.println(downLoadCommand);
//                // 发送命令
//
//                // 接收数据
//
//            }
//        }


        // 如果是多次




    }



    }



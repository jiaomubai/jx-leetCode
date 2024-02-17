//package reorderSpaces;
//
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @ClassName: ReorderSpaces
// * @Description: leetCode-1592: �������е��ʼ�Ŀո�
// * @Author: jiaoxian
// * @Date: 2022/9/7 9:47
// **/
//@Slf4j
//public class ReorderSpaces {
//
//    public String reorderSpaces(String text) {
//        // 1.����ո������, ͬʱ�����ʴ���� List ��
//        int spaceCount = 0;
//        char[] charArray = text.toCharArray();
//        List<String> wordList = new ArrayList<>();
//        StringBuffer stringBuffer = new StringBuffer("");
//        for (int i = 0; i < charArray.length; i++) {
//            if (charArray[i] == ' ') {
//                spaceCount++;
//            } else {
//                stringBuffer.append(charArray[i]);
//                if (i != charArray.length - 1 && charArray[i + 1] == ' ') {
//                    wordList.add(stringBuffer.toString());
//                    stringBuffer = new StringBuffer("");
//                }
//            }
//        }
//        if (!"".equals(stringBuffer.toString())) {
//            wordList.add(stringBuffer.toString());
//        }
//        // 2. ����ƽ���ո��ʣ��ո�
//        int space = 0;
//        if (wordList.size() > 1) {
//            space = spaceCount / (wordList.size() - 1);
//        }
//        int leftSpace = spaceCount - space * (wordList.size() - 1);
//        log.info("�ո�: {}", spaceCount);
//        log.info("����: {}", wordList.size());
//        log.info("ƽ���ո�: {}", space);
//        log.info("ʣ��ո�: {}", leftSpace);
//        // 3. ƴ�ӷ��ؽ��
//        StringBuffer resultBuffer = new StringBuffer("");
//        for (int i = 0; i < wordList.size(); i++) {
//            resultBuffer.append(wordList.get(i));
//            if (i != wordList.size() - 1) {
//                for (int j = 0; j < space; j++) {
//                    resultBuffer.append(" ");
//                }
//            }
//        }
//        if (leftSpace != 0) {
//            for (int i = 0; i < leftSpace; i++) {
//                resultBuffer.append(" ");
//            }
//        }
//        return resultBuffer.toString();
//    }
//
//    public static void main(String[] args) {
//        ReorderSpaces reorderSpaces = new ReorderSpaces();
//        String text = "a     ";
//        String result = reorderSpaces.reorderSpaces(text);
//        log.info("result: {}", result);
//    }
//
//}

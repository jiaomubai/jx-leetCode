//package restoreString;
//
//import util.ArraysUtil;
//
///**
// * @ClassName: RestoreString
// * @Description: leetCode-1528: ÖØÐÂÅÅÁÐ×Ö·û´®
// * @Author: jiaoxian
// * @Date: 2022/9/6 18:08
// **/
//public class RestoreString {
//
//    public String restoreString(String s, int[] indices) {
//        if (s.length() != indices.length) {
//            return "";
//        }
//        Character[] charArray = new Character[indices.length];
//        for (int i = 0; i < indices.length; i++) {
//            charArray[indices[i]] = s.charAt(i);
//        }
////        for (int i = 0; i <charArray.length; i++) {
////            result.append(charArray[i]);
////        }
////        return result.toString();
//        return ArraysUtil.objectArrayToString(charArray);
//    }
//
//    public static void main(String[] args) {
//        RestoreString restoreString = new RestoreString();
//        String s = "codeLeet";
//        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
//        String result = restoreString.restoreString(s, indices);
//        System.out.println(result);
//    }
//
//}

package numUniqueEmails;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: NumUniqueEmails
 * @Author: jiaoxian
 * @Date: 2022/6/4 18:42
 * @Description: leetCode-929: 独特的电子邮件地址
 */
public class NumUniqueEmails {

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmailsSet = new HashSet<>();
        // 以 "@" 分隔字符串为本地名和域名两部分, 只处理本地名即可
        for (String email : emails) {
            int j = email.lastIndexOf('@');
            String localName = email.substring(0, j);
            String domainName = email.substring(j);
            if (localName.contains("+")) {
                localName = localName.substring(0, localName.indexOf('+'));
            }
            localName = localName.replace(".", "");
            uniqueEmailsSet.add(localName + domainName);
        }
        return uniqueEmailsSet.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        int result = new NumUniqueEmails().numUniqueEmails(emails);
        System.out.println(result);
    }

}

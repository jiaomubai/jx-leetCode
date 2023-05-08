package countCharacters;

/**
 * @author jiaoxian
 * @name countCharacters
 * @date 2023/5/8 17:16
 * @description leetCode-1160: 拼写单词
 */
public class CountCharacters {

    public int countCharacters(String[] words, String chars) {
        int count = 0;
        out:for (String word : words) {
            char[] wordArr = word.toCharArray();
            String charsNew = chars;
            in:for (int i = 0; i < wordArr.length; i++) {
                String tempChar = String.valueOf(wordArr[i]);
                if (!charsNew.contains(tempChar)) {
                    continue out;
                } else {
                    charsNew = charsNew.replaceFirst(tempChar, "");
                    System.out.println(charsNew);
                }
            }
            count += wordArr.length;
        }
        return count;
    }

    public static void main(String[] args) {
        CountCharacters countCharacters = new CountCharacters();
//        String[] words = {"hello", "world", "leetcode"};
//        String chars = "welldonehoneyr";
        String[] words = {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin","ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb","ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl","boygirdlggnh","xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx","nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop","hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx","juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr","lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","oxgaskztzroxuntiwlfyufddl","tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp","qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv","sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz","yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue","hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv","cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo","teyygdmmyadppuopvqdodaczob","qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs","qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
        String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        System.out.println(countCharacters.countCharacters(words, chars));


    }


}

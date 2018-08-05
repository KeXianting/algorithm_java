package leetcode;

import java.util.HashSet;

/**
 * Created by kentorvalds on 2018/6/13.
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

 For convenience, the full table for the 26 letters of the English alphabet is given below:

 [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

 Return the number of different transformations among all words we have.

 Example:
 Input: words = ["gin", "zen", "gig", "msg"]
 Output: 2
 Explanation:
 The transformation of each word is:
 "gin" -> "--...-."
 "zen" -> "--...-."
 "gig" -> "--...--."
 "msg" -> "--...--."

 There are 2 different transformations, "--...-." and "--...--.".
 */
public class MorseCode {

    public static void main(String[] args){
        String[] words = {"rwjje","aittjje","auyyn","lqtktn","lmjwn"};
        System.out.println(uniqueMorseRepresentations(words));
    }
    public static int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        if(words.length <= 0 || words == null){
            return 0;
        }
        if(words.length == 1 && words[0].length() == 1){
            return 1;
        }
        int len = words.length;
        //int count = 0;
        HashSet<String> sh = new HashSet<String>();//没有重复元素的集合
        for(int i = 0; i < len; i ++){
            String str = words[i];
            char[] chs = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < chs.length; j ++){
                int temp = (int)chs[j] - (int)'a';
                sb.append(morse[temp]);
            }
            String tempMorse = sb.toString();
            System.out.println("tt: " + tempMorse);
            sh.add(tempMorse);
        }

        return sh.size();

    }
}

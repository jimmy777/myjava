package libs;

import java.util.Scanner;

public class PigLatinTranslator {

    // 静态方法 translate，切分句子为单词。
    public static String translate(String sentence){
        String result = "";

        sentence = sentence.toLowerCase();
        Scanner scan = new Scanner(sentence);
        while (scan.hasNext()){
            result += translateWord(scan.next());
            result += " ";
        }
        return result;
    }

    // 处理单词 word 方法。
    private static String translateWord(String word){
        String result = "";

        // 调用处理（元音）方法。
        if (beginsWithVowel(word))
            result = word + "yay";
        else {
            // 调用处理（辅音）方法。
            if (beginsWithBlend(word))
                result = word.substring(2) + word.substring(0, 2) + "ay";
            else
                result = word.substring(1) + word.charAt(0) + "ay";
        }

        return result;
    }

    // （元音）处理方法。
    private static boolean beginsWithVowel(String word){
        String vowels = "aeiou";

        char letter = word.charAt(0);

        return (vowels.indexOf(letter) != -1);
    }

    // （辅音）处理方法。
    private static boolean beginsWithBlend(String word){
        return ( word.startsWith("bl") || word.startsWith("sc") ||
                 word.startsWith("br") || word.startsWith("sh")
                );
    }
}

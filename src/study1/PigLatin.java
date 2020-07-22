package study1;

import libs.PigLatinTranslator;

import java.util.Scanner;

public class PigLatin {

    // 例子：7.7.1A PigLatin
    // 功能： 分解几个方法来处理句子中的单词。
    public static void main(String[] args) {
        String sentence, result, another;

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("Enter a sentence (no punctuation):");
            sentence = scan.nextLine();

            // 调用 PigLatinTranslator 类的静态方法 translate 来处理句子。
            System.out.println();
            result = PigLatinTranslator.translate(sentence);

            System.out.println("That sentence in Pig Latin is:");
            System.out.println(result);

            System.out.println();
            System.out.println("Translate another sentence (y/n) ?");
            another = scan.nextLine();

        }  while (another.equalsIgnoreCase("y"));
    }
}

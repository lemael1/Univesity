
import java.util.ArrayList;
import java.util.Scanner;

public class NewLetterandCharacterCount {

    public static void main(String[] args) {
        String content = InputContent("Enter your content");
        System.out.println(content);
        System.out.println("");
        DoWord(content);
        System.out.println("");
        DoCharacter(content);


    }

    private static String InputContent(String msg) {
    System.out.println(msg);
    Scanner sc = new Scanner(System.in);
    String input;
    String input1 ="";
    do {
        input = sc.nextLine();
        if (input.trim().isEmpty()) {
            System.out.println("Please enter your content");
            continue;
        }
//        if (!input.matches("[a-zA-Z\\s]+")) {
//            System.out.println("Invalid input. Please enter letters and spaces only.");
//            continue;
//        } 
        else {
            break;
        }
    } while (true);
    for(char ch:input.toCharArray()){
        if(Character.isAlphabetic(ch)||Character.isSpaceChar(ch)){
            input1+=ch;
        }
    }
    return input1;
}

    private static void Display(String x) {
        for (int i = 0; i < x.length(); i++) {

        }
    }

    private static void DoWord(String content) {
        String content1 = content.trim().toLowerCase();
        
        String[] words = content1.split("\\s+");
        int n = FindDistinctWordCount(words);
        String[] DistinctWord = addValuetoArray(words, n);
        int[] wordsCount = new int[n];
        for (int i = 0; i < DistinctWord.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (DistinctWord[i].equals(words[j])) {
                    wordsCount[i]++;
                }
            }

        }
        System.out.print("{");
        for (int i = 0; i < DistinctWord.length; i++) {
            System.out.print(DistinctWord[i] + "=" + wordsCount[i]);
            if (i < DistinctWord.length - 1) {
                System.out.print(", ");
            }

        }
        System.out.print("}");

    }

    private static int FindDistinctWordCount(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (words[i].equals(words[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                count++;

            }
        }
        return count;

    }

    private static String[] addValuetoArray(String[] words, int n) {
        String[] x = new String[n];
        int k = 0;
        for (int i = 0; i < words.length; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (words[i].equals(words[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                x[k] = words[i];
                k++;

            }
        }
        return x;

    }

    private static void DoCharacter(String content) {
        String content1 = content.toLowerCase().replaceAll(" ","");
        char []Chars= content1.toCharArray();
        int n=FindDistinctCharCout(Chars);
        char [] DistinctChar =addValueChartoArray(Chars, n);
        int[] charsCount = new int[n];
        for (int i = 0; i < DistinctChar.length; i++) {
            for (int j = 0; j < Chars.length; j++) {
                if (DistinctChar[i]==(Chars[j])) {
                    charsCount[i]++;
                }
            }

        }
        System.out.print("{");
        for (int i = 0; i < DistinctChar.length; i++) {
            System.out.print(DistinctChar[i] + "=" + charsCount[i]);
            if (i < DistinctChar.length - 1) {
                System.out.print(", ");
            }

        }
        System.out.print("}");
    }

    private static int FindDistinctCharCout(char[] Chars) {
       int count = 0;
        for (int i = 0; i < Chars.length; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (Chars[i]==(Chars[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                count++;

            }
        }
        return count;
    }

    private static char[] addValueChartoArray(char[] Chars, int n) {
        char[] x = new char[n];
        int k = 0;
        for (int i = 0; i < Chars.length; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (Chars[i]==(Chars[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                x[k] = Chars[i];
                k++;

            }
        }
        return x;
        
    }

}

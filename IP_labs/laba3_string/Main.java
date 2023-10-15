import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = in.nextLine();
        String[] words = str.split(" ");
        StringBuilder reverseWord;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                reverseWord = new StringBuilder(words[j]).reverse();
                if (words[i].equals(reverseWord.toString())){
                    System.out.println(words[i] + " - " + reverseWord.reverse());
                }
            }
        }
        in.close();

    }

}

// abc ba cba Ba ab Hello world olleH

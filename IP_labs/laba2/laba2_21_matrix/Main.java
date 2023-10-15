import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static Boolean is_a_permutation(int[][] Matrix, int[] Example, int k)
    {
        Boolean bool = true;
        Integer[] line = new Integer[10];
        for(int i = 0; i < 10; i++)
        {
            line[i] = Matrix[k][i];
        }
        Arrays.sort(line);
        for(int i = 0; i < 10; i++)
        {
            if(line[i] != Example[i])
            {
                bool = false;
            }
        }
        return bool;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("matrix.txt"));
        int n, m = 10, count = 0, temp;

        Pattern pattern = Pattern.compile("-?\\d+");
        Pattern pattern_n = Pattern.compile("\\d");

        String line_n = scanner.nextLine();
        Matcher matcher_n = pattern_n.matcher(line_n);
        n = Integer.parseInt(line_n);

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);

            for (int j = 0; j < m; j++) {
                if (matcher.find()) {
                    matrix[i][j] = Integer.parseInt(matcher.group());
                }
            }
        }

        scanner.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int[] Example = new int[10];
        for(int i = 0; i < 10; i++)
        {
            Example[9 - i] = -i - 1;
        }
        for(int i = 0; i < n; i++)
        {
            if(is_a_permutation(matrix, Example, i)) ///// M
            {
                count++;
            }
        }
        System.out.println(count);
    }
}

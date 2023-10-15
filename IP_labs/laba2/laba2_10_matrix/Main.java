import java.util.Scanner;
import java.io.*;

public class Main {
    public static int counts_the_distance(int[][] Matrix, int m, int k)
    {
        int res = 0;
        for(int i = 0; i < m; i++)
        {
            res += Matrix[k][i] * Matrix[0][i];
        }
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("matrix.txt"));
        int n, m, res = 0, temp;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[][] Matrix = new int[n][m];
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < m; ++j)
            {
                Matrix[i][j] = scanner.nextInt();
            }
        }
        temp = counts_the_distance(Matrix, m, 1);
        for(int i = 2; i < n; ++i)
        {
            temp = Math.max(temp, (counts_the_distance(Matrix, m, i)));
        }
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < m; ++j)
            {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(temp);
    }
}



// 10
// надо: 1) прочитать с файла матрицу 1.1 n и m прочитать
//                                    1.2 построчно прочитать матрицу
//       2) получается двумерный статический массив
//       3) считаю расстояние 1 со всеми остальными строками и как только находится что-то большее, номер строки обновляется


// 21
// размерность матрицы n на 10


// 32
//

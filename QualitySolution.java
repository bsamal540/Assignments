import java.util.Arrays;
import java.util.Scanner;

public class QualitySolution {
    public static void main(String[] args) {

       // int[][] arr1 = {{1,2,5},{2,1,7},{3,1,9}};

        Scanner scanner = new Scanner(System.in);

        int[][] arr1 = new int[3][3];


        for (int i = 0; i < arr1.length; i++) {

            System.out.print("Enter the elements of array " + (i+1) + ": ");
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = scanner.nextInt();
            }
        }


        System.out.println("the result is:  " +Arrays.toString(ResultFind.bestCoordinate(arr1, 2)));

    }}
      class ResultFind {
            public static int[] bestCoordinate(int[][] towers, int radius) {
                int minX = 51, maxX = 0, minY = 51, maxY = 0, max = 0;
                int[] result = new int[2];
                for(int[] t : towers) {
                    minX = Math.min(minX, t[0]);
                    maxX = Math.max(maxX, t[0]);
                    minY = Math.min(minY, t[1]);
                    maxY = Math.max(maxY, t[1]);
                }
                for(int i = minX; i <= maxX; i++) {
                    for(int j = minY; j <= maxY; j++) {
                        int sum = 0;
                        for(int[] t : towers) {
                            int d = (t[0] - i) *(t[0] - i) + (t[1] - j) *(t[1] - j);
                            if(d <= radius * radius) {
                                sum += t[2] /(1+ Math.sqrt(d));
                            }
                        }
                        if(sum > max) {
                            max = sum;
                            result = new int[]{i,j};
                        }
                    }
                }
                return result;
            }
        }







import java.util.Arrays;

public class OnlyNum {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        if (target <= matrix[m][n] && target >= matrix[0][0]) {
            int i = m;
            int j = n;
            while (i > -1 && j > -1) {
                if (target < matrix[i][j]) {
                    i--;
                    j--;
                } else if (target == matrix[i][j])
                    return true;
                else
                    break;
            }
            while (j + 1 < n + 1) {
                for (int k = 0; k < i + 1; k++) {
                    if (target == matrix[k][j + 1])
                        return true;
                }
                j++;
            }
            while (i + 1 < m + 1) {
                for (int k = 0; k < j + 1; k++) {
                    if (target == matrix[i + 1][k])
                        return true;
                }i++;
            }
        }
        return false;


    }
}


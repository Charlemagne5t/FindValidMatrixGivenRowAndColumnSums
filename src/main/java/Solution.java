import java.util.Arrays;

public class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;

        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(res[i], - 1);
        }
        int k = 0;
        while(k < m * n){
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            boolean isRow = true;
            for(int i = 0; i < m; i++){
                if(rowSum[i] < min){
                    min = rowSum[i];
                    minIndex = i;
                }
            }
            for(int i = 0; i < n; i++){
                if(colSum[i] < min){
                    min = colSum[i];
                    minIndex = i;
                    isRow = false;
                }
            }
            if(minIndex == -1) {
                break;
            }
            if(isRow){
                for(int i = 0; i < n; i++){
                    if(res[minIndex][i] == -1 && colSum[i] != Integer.MAX_VALUE){
                        res[minIndex][i] = min;
                        rowSum[minIndex] = Integer.MAX_VALUE;
                        colSum[i] -= min;
                        if(colSum[i] == 0) {
                            colSum[i] = Integer.MAX_VALUE;
                        }
                        break;
                    }
                }
            }else {
                for(int i = 0; i < m; i++){
                    if(res[i][minIndex] == -1 && rowSum[i] != Integer.MAX_VALUE){
                        res[i][minIndex] = min;
                        colSum[minIndex] = Integer.MAX_VALUE;
                        rowSum[i] -= min;
                        if(rowSum[i] == 0) {
                            rowSum[i] = Integer.MAX_VALUE;
                        }
                        break;
                    }
                }
            }

            k++;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(res[i][j] == -1) {
                    res[i][j] = 0;
                }
            }
        }

        return res;

    }


}

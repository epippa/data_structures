public class SortedArrays {

    public static int firstPosXSorted(int[] A, int x) {
        int min = 0, max = A.length-1;
        while (min != max){
            int average = (min + max) / 2;
            if (A[average] >= x) max = average;
            else min = average + 1;
        }
        if (A[min] == x){
            while ((min > 0) && (A[min] == A[min-1])){
                min = min-1;
            }
            return min;
        }
        else return -1;
    }

    public static int lastPosXSorted(int[] A, int x) {
        int min = 0, max = A.length-1;
        while (min != max){
            int average = (min + max) / 2;
            if (A[average] >= x) max = average;
            else min = average + 1;
        }
        if (A[min] == x){
            while ((min < A.length-1) && (A[min] == A[min+1])){
                min = min+1;
            }
            return min;
        }
        else return -1;
    }

    public static int mostFrequentElementSorted(int[] A) {
        int temp = 0, pos = A[0];
        for (int a = 0; a < A.length-1; a++){
            int count = 0;
            for (int i = a; A[a] == A[i] && i < A.length-1; i++){
                count++;
            }
            if (count >= temp) {
                temp = count;
                pos = A[a];
            }
        }
        return pos;
    }
}
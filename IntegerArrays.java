public class IntegerArrays {

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j]; 
        A[j] = temp;
    }

    public static boolean sorted(int[] A) {
        int j = 0;
        boolean temp = true;
        if (A.length <= 1) return true;
        for (int i = 0; i < A.length - 1; i++ ){
            j = i+1;
            if  (A[i] > A[j]) return (temp = false);
        }   
        return temp;
    }

    public static int maxPos(int[] A, int l, int r) {
        int v = l;
        for (int temp = l; temp < r; temp++){
            if (A[v] < A[temp+1]){ 
                v = temp+ 1;
            }    
        }   
        return v;
    }

    public static int[] reversedCopy(int[] A) {
        int[] reversedCopy = new int[A.length];
        int temp = reversedCopy.length - 1 ;
        for (int i = 0; i < A.length; i++){
            reversedCopy[temp] = A[i];
            --temp;
        }
        return reversedCopy;
    }

    public static void reverse(int[] A) {
        int j = A.length - 1;
        for (int i = 0; i < (A.length)/2; i++){
            swap(A, i, j);
            j--;
        }
    }

    public static int localMax(int[] A) {
        return localMax(A, 0, A.length-1);
    }
    public static int localMax(int[] A, int min, int max){
        int j = 0, med = (min + max)/2;
        if (A.length-1 == 0) return 0;
        if (A[0] > A[1]) return j = 0;
        if (A[A.length-1] > A[A.length-2]) return A.length-1;
        if ((A[med] > A[med+1]) && (A[med] > A[med-1])) return med;
        if (A[med] >= A[med+1]) return localMax(A, min, med);
        else return localMax(A, med+1, max);
    }

    public static void selectionSortMax(int[] A) {
        int max, width = A.length-1;
        while(sorted(A) == false) {
            max = maxPos(A, 0, width);
            swap(A, max, width);
            --width;
        }
    }

    public static int mostFrequentElement(int[] A) {
        selectionSortMax(A);
        return SortedArrays.mostFrequentElementSorted(A);
    }
}

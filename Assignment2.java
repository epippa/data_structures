public class Assignment2 {

    public static boolean isPalindrome(String s) {
        if (s.length() < 1) return true;
        return checkPalindrome(s, 0, s.length()-1);
    }
    public static boolean checkPalindrome(String s, int min, int max){
        char right = s.charAt(min);
        char left = s.charAt(max);
        if (min >= max) return true;
        if (right == left) return checkPalindrome(s, min+1, max-1);
    return false;
    }

    public static int maxAscentLength(int[] A) {
        if (A.length < 1) return 0;
        int bigger = 1;
        for (int k = 0; k < A.length-1; k++){
            int temp = 1;
            for (int j = k; (j < A.length-1) && (A[j] <= A[j+1]); j++){
                temp += 1;
                k = j+1;
            }
            if (temp >= bigger) bigger = temp;
        }
        return bigger;
    }

    public static int maxMissedGain(int[] A) {
        int gain = 0, temp = 0;
        for (int i = 0; i < A.length; i++){
            for (int j = i+1; j < A.length; j++){
                temp = A[j] - A[i];
                if (temp >= gain) gain = temp;
            }
        }
        return gain;
    }

}
public class newEgg {

        public static void main(String[] args) {

            System.out.println(superEggDrop1(2,6));
        }

    private static int superEggDrop1(int K, int N) {
            if (K==1||N==0||N==1)
                return N;
            int min=N;
        for (int i = 1; i <=N ; i++) {
            int mint=Math.max(superEggDrop1(K-1,i-1),superEggDrop1(K,N-i));
            min=Math.min(min,mint+1);
        }
        return min;
    }
}

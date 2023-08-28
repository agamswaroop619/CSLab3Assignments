import java.util.Random;

public class _2104212_Lab03 {
    private String[] randomStringsArray;

    public _2104212_Lab03() {
        // Generate an array of N random strings

        int N = (int) (Math.random() * 100);
        randomStringsArray = generateRandomStringsArray(N);
    }

    private String[] generateRandomStringsArray(int N) {
        Random random = new Random();
        String[] array = new String[N];

        for (int i = 0; i < N; i++) {
            int length = random.nextInt(5) + 6; // Random length between 6 and 10
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                char randomChar = (char) (random.nextInt(26) + 'a'); // Random lowercase letter
                sb.append(randomChar);
            }
            array[i] = sb.toString();
        }

        return array;
    }

    public long method1(String[] array, int TIMES) {
        StringBuilder S1 = new StringBuilder();
        long startTime = System.nanoTime();

        for (int i = 0; i < TIMES; i++) {
            String randomString = array[new Random().nextInt(array.length)];
            S1.append(randomString);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public long method2(String[] array, int TIMES) {
        StringBuffer S2 = new StringBuffer();
        long startTime = System.nanoTime();

        for (int i = 0; i < TIMES; i++) {
            String randomString = array[new Random().nextInt(array.length)];
            S2.append(randomString);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        _2104212_Lab03 lab = new _2104212_Lab03();

        int TIMES = 1000000; // Change TIMES to the desired number of repetitions
        long timeMethod1 = lab.method1(lab.randomStringsArray, TIMES);
        long timeMethod2 = lab.method2(lab.randomStringsArray, TIMES);

        System.out.println("Time taken by method1: " + timeMethod1 + " nanoseconds");
        System.out.println("Time taken by method2: " + timeMethod2 + " nanoseconds");
    }
}

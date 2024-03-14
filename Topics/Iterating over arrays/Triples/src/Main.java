import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] numbers = new int[n];
        int size = numbers.length;
        while (n > 0) {
            numbers[size - n] = s.nextInt();
            n--;
        }
        int triples = 0;
        for (int i = 2; i < size; i++) {
            if (numbers[i - 1] - numbers[i - 2] == 1
                    && numbers[i] - numbers[i - 1] == 1) {
                triples++;
            }
        }
        System.out.println(triples);
    }
}
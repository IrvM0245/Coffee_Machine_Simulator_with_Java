import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] numbers = new int[n];
        int maxProduct = 0;
        while (n > 0) {
            numbers[numbers.length - n] = scan.nextInt();
            n--;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (i + 1 != numbers.length) {
                int product = numbers[i] * numbers[i + 1];
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }
        System.out.println(maxProduct);
    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = scanner.nextInt();
        }
        int value = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (elements[i] > value) {
                sum += elements[i];
            }
        }
        System.out.println(sum);
    }
}
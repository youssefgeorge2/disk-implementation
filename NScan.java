package os;
import java.util.Scanner;

public class NScan {
    public static void main(String[] args) {
        int n, head, total = 0;
        int[] queue, distance;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of requests: ");
        n = input.nextInt();
        queue = new int[n + 1];
        distance = new int[n + 1];
        System.out.println("Enter the queue of disk positions to be read: ");
        for (int i = 1; i <= n; i++) {
            queue[i] = input.nextInt();
        }
        System.out.println("Enter the initial head position: ");
        head = input.nextInt();
        queue[0] = head;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(queue[i] - queue[i + 1]);
            distance[i] = diff;
            total += diff;
        }
        System.out.println("Enter the size of the disk: ");
        int size = input.nextInt();
        System.out.println("Enter the direction of head movement (0 for left, 1 for right): ");
        int direction = input.nextInt();
        int i = 0;
        if (direction == 0) {
            while (queue[i] > 0) {
                i++;
            }
            for (int j = i; j >= 0; j--) {
                System.out.print(queue[j] + " ");
            }
            for (int j = i + 1; j <= n; j++) {
                System.out.print(queue[j] + " ");
            }
        } else {
            while (queue[i] < size) {
                i++;
            }
            for (int j = i; j <= n; j++) {
                System.out.print(queue[j] + " ");
            }
            for (int j = i - 1; j >= 0; j--) {
                System.out.print(queue[j] + " ");
            }
        }
        System.out.println("\nTotal head movement: " + total);
    }
}

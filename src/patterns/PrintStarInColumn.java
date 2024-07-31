package patterns;

public class PrintStarInColumn {
    public static void main(String[] args) {
        int[] values = {3, 5, 1, 4, 2}; // Example array
        printStars(values);
    }

    public static void printStars(int[] values) {
        int max = 0;
        for (int value : values) {
            max = Math.max(max, value);
        }

        for (int i = 1; i <= max; i++) {
            for (int value : values) {
                System.out.print(value >= i ? "* " : "  ");
            }
            System.out.println();
        }
    }
}

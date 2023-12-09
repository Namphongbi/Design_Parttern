import java.util.Arrays;

public class Cau_2 {
}
interface SortStrategy {
    void sort(int[] numbers);
}

class BubbleSort implements SortStrategy {
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
    }
}

class SelectionSort implements SortStrategy {
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (numbers[j] < numbers[min_idx])
                    min_idx = j;
            int temp = numbers[min_idx];
            numbers[min_idx] = numbers[i];
            numbers[i] = temp;
        }
    }
}

class Sorter {
    private SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] numbers) {
        strategy.sort(numbers);
    }
        public static void main(String[] args) {
            int[] numbers = {5, 3, 8, 1};
            Sorter sorter = new Sorter(new BubbleSort());
            sorter.sort(numbers);
            System.out.println(Arrays.toString(numbers));

            sorter.setStrategy(new SelectionSort());
            sorter.sort(numbers);
            System.out.println(Arrays.toString(numbers));
        }
}


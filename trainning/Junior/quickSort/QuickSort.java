public class QuickSort {
    public static void main(String[] args) {
        int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        System.out.println("Vetor antes da ordenação: ");
        imprimeArray(array);

        sort(array, 0, array.length - 1);

        System.out.println("Vetor depois da ordenação: ");
        imprimeArray(array);

    }

    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = halfArray(array, low, high);
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    public static int halfArray(int[] array, int low, int high) {
        int pivotIndex = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivotIndex) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void imprimeArray(int[] array) {
        for (int element : array) {
            System.out.print("[" + element + "] ");
        }
        System.out.println();

    }
}

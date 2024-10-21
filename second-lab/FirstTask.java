import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class FirstTask {
	private final int ARRAY_SIZE = 20;
	private final int MAX_VALUE = 50;
	
	private int[] array;
	private Scanner scanner;
	private Sortable sortable;

	public static void main(String[] args) {
		FirstTask task = new FirstTask();
		task.createArray();
		task.chooseSortingAlgorithm();
		task.showSortedArray();
	}

	private void createArray() {
		array = new int[ARRAY_SIZE];
		Random rand = new Random(); 

		for(int i = 0; i < ARRAY_SIZE; ++i){
			array[i] = rand.nextInt(MAX_VALUE + 1);	
		}
	}

	private void chooseSortingAlgorithm(){
		scanner = new Scanner(System.in);
		System.out.println("Please, choose sorting algo, enter selection for selection sort or bubble for bubble sort:");
		String sortAlgo = scanner.nextLine();
		scanner.close();
		
		switch(sortAlgo){
			case "selection":
				sortable = new SelectionSort(this.array);
				break;

			case "bubble":
				sortable = new BubbleSort(this.array);
				break;

			default:
				System.out.println("Wrong input!");
				System.exit(1);
		}
	}

	private void showSortedArray() {
		System.out.println("The array before sorting is shown below:");
		System.out.print(Arrays.toString(array));
		System.out.println();
		sortable.sort();

		for(int i = 0; i < ARRAY_SIZE; ++i){
			System.out.println(this.array[i]);
		}
	}

}

interface Sortable {
	void sort();
}

class SelectionSort implements Sortable {
	private int size;
	private int[] array;

	SelectionSort(int[] array) {
		this.array = array;
		this.size = array.length;
	}

	public void sort() {
		for(int i = 0; i < this.size; ++i){
			int minIndex = i;
			for(int j = i + 1; j < this.size; ++j){
				if(this.array[j] < this.array[minIndex]) minIndex = j;
			}

			int tmp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = tmp;
		}
	}

}

class BubbleSort implements Sortable {
	private int size;
	private int[] array;

	BubbleSort(int[] array) {
		this.array = array;
		this.size = array.length;
	}

	public void sort() {
		boolean swapped;
		for(int i = 0; i < this.size - 1; ++i){
			swapped = false;
			for(int j = 0; j < this.size - 1 - i; ++j) {
				if(this.array[j] > this.array[j + 1]) {
					int tmp = this.array[j + 1];
					array[j + 1] = array[j];
					array[j] = tmp;
					swapped = true;
				}
			}

			if (!swapped) break;
		}
	}

}



import java.util.Random;

public class FirstTask {
	static final int ARRAY_SIZE = 1000;
	
	private static int[] createRandomArr(){
		int numbers[] = new int[ARRAY_SIZE];
		Random rand = new Random();

		for(int i = 0; i < ARRAY_SIZE; ++i){
			numbers[i] = rand.nextInt();   
		}

		return numbers;
	
	}

	private static void selectionSort(int[] arr){
		for(int i = 0; i < ARRAY_SIZE; ++i){
			int minIndex = i;
			for(int j = i + 1; j < ARRAY_SIZE; ++j){
				if(arr[j] < arr[minIndex]) minIndex = j;
			}

			int tmp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = tmp;
		}
	}

	public static void main(String[] args) {
		int numbs[] = createRandomArr();

		selectionSort(numbs);

		System.out.println("Sorted array:\n");
		for(int i : numbs){
			System.out.println(i);
		}
	}

}	

class BasicAlgorithm{
	public static void main(String[] args){
		int[] numbers = {1,3,2,7,5};
		selectionSort(numbers);
		for(int i = 0; i<numbers.length; i++){
			System.out.println(numbers[i]);
		}
	}
	public static void selectionSort(int[] x){
		int targetIndex;
		for (int index = 0; index <= x.length - 1; index++){
			targetIndex = index;
			for (int j= index+1; j< x.length; j++) {
				if (x[j] < x[targetIndex]){
					targetIndex = j;
				}
			}
                        swap(x, targetIndex, index);
		}
	}

	public static void swap(int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}

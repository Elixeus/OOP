public class selectionSort{
    private int[] array;
    private boolean defaultFlag = false; // provide default value to the inSort method
    public selectionSort(int[] array){
        this.array = array;
    }
    public void seSort(boolean reverse){
    // use a boolean variable reverse to control whether to reverse sort or not
        int minIndex;
        for(int i=0; i<this.array.length-1; i++){
            minIndex = i;
            for(int j=i+1; j<this.array.length; j++){
                if(!reverse){    // use the boolean here
                    if(this.array[j]<this.array[minIndex]) {
                        minIndex = j;
                    }
                }
                else {
                    if(this.array[j]>this.array[minIndex]){
                        minIndex = j;
                    }
                }
            }
            int temp = this.array[i];
            this.array[i] = this.array[minIndex];
            this.array[minIndex] = temp;

        }
    }
    public void seSort(){
        // overload the inSort() method, setting the 'default' sort type to asc
        seSort(defaultFlag);
    }
    
    public void seSortReverse(){
        int minIndex;
        for(int i=0; i<this.array.length-1; i++){
            minIndex = i;
            for(int j=i+1;j<this.array.length; j++){
                if(this.array[j] > this.array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = this.array[i];
            this.array[i] = this.array[minIndex];
            this.array[minIndex] = temp;
        }
    }
    // public static void swap(int[] array, int index1, int index2){
    //     int temp = array[index1];
    //     array[index1] = array[index2];
    //     array[index2] = temp;
    // }
    public static void main(String[] args){
        int[] numbers = {8, 3, 7, 10, 9, 10, 20, 1};
        selectionSort x = new selectionSort(numbers);
        for (int item: numbers) {
            System.out.print(item+", ");
        }
        System.out.print("\n");
        boolean reverse = false;
        x.seSort();   // default sort
        for (int i:x.array){
            System.out.print(i+", ");
        }
        System.out.print("\n");
        reverse = true;
        x.seSort(true); // reverse sort
        for (int i: x.array){
            System.out.print(i+", ");
        }
        System.out.print("\n");
        reverse = false;
        x.seSort(false);
        for (int i: x.array){
            System.out.print(i+", ");
        }
        
    }
}

public class selectionSort{
    private int[] array;
    private boolean defaultFlag = false; // provide default value to the inSort method
    public selectionSort(int[] array){
        this.array = array;  // constructor
    }
    public void seSort(boolean reverse){
    // use a boolean variable named reverse to control whether to reverse sort or not
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
            // swap the values
            int temp = this.array[i];
            this.array[i] = this.array[minIndex];
            this.array[minIndex] = temp;

        }
    }
    public void seSort(){
        // overload the inSort() method, setting the 'default' sort order to asc
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
            // swap the values
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
        // create the object
        selectionSort x = new selectionSort(numbers);
        // print out the original object/ array
        for (int item: numbers) {
            System.out.print(item+", ");
        }
        System.out.print("\n");
        boolean reverse = false;
        // call the seSort() method on the object
        x.seSort();   // default sort
        for (int i:x.array){
            System.out.print(i+", ");
        }
        System.out.print("\n");
        reverse = true;
        // call the seSort() with a reverse value
        x.seSort(true);
        for (int i: x.array){
            System.out.print(i+", ");
        }
        System.out.print("\n");
        reverse = false;
        // test method overloading
        x.seSort(false);
        for (int i: x.array){
            System.out.print(i+", ");
        }
        
    }
}

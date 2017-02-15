public class binarySearch{
    public static void main(String[] args){
        int[] test = {1,2,3,4,5};
        int index = biSearch(3, test);
        System.out.println("The index of 3 is: " + index);
    }
    public static int biSearch(int foo, int[] array){
        // look for foo in array
        // the array must be sorted
        int low = 0;
        int high = array.length - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (foo == array[mid]){
                return mid;
            }
            if (foo <= array[mid]){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

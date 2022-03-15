import java.util.concurrent.Flow.Subscriber;

class Sorts {
    public static void main(String[] args) {
        System.out.println("Hey world; What's up?");
        int[] test1 = {1,5,9,4,4,3,6,7};
        System.out.println("Bubble");
        ShowArray(test1);
        int[] result1 = Bubble(test1);
        ShowArray(test1);
        ShowArray(result1);
        System.out.println("Radix");
        int[] test2 = {1,5,9,4,4,3,6,7};
        ShowArray(test2);
        int[] result2 = Radix(test2);
        ShowArray(test2);
        ShowArray(result2);
        System.out.println("Quick");
        int[] test3 = {1,5,9,4,4,3,6,7};
        ShowArray(test3);
        int[] result3 = Quick(test3);
        ShowArray(test3);
        ShowArray(result3);
    }
    // Bubble Sort -------------------------------------------------------------------
    public static int[] Bubble(int[] arr){
        int temp = 0;
        for (int i=arr.length-1;i>1;i--){
            // End of the array is our first goal, for our biggest number
            for (int j=0; j<i; j++){
                //switch big numbers with their neighbour.
                // big number 'bubbles up' to the end of the array
                if (arr[j] > arr[j+1]){
                   temp = arr[j];
                   arr[j]= arr[j+1];
                   arr[j+1] = temp; 
                }
            }
        }
        return arr;
    } 
    // Radix Sort --------------------------------------------------------------
    public static int[] Radix(int[] arr){
        int [] count = {0,0,0,0,0,0,0,0,0,0};
        for (int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        for (int i=1; i<count.length;i++){
            count[i] += count[i-1];
        }
        int [] fixedArr = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            count[arr[i]]--;
            fixedArr[count[arr[i]]] = arr[i];
        }
        return fixedArr;
    }
    // Quick Sort -----------------------------------------------------
    public static int[] Quick(int[] arr){
        SubQuick(arr, 0, arr.length-1);
        return arr;
    }
    public static void SubQuick(int[] arr, int min, int max){
        if (min < max){
            // Send our current selection to SubSort
            int pivotPoint = SubSort(arr, min, max);
            // Check Left
            SubQuick(arr, min, pivotPoint - 1);
            // Check Right
            SubQuick(arr, pivotPoint+1, max);
        }
    }
    public static int SubSort(int[] arr, int min, int max){
        int pivot = arr[max];
        // movingPoint increases as we find more numbers less than our pivot.
        /*
        Our moving point is going to be pointing at the first value higher than our pivot chronologically
        in the list so that we know where to put our pivot at the end. 
        */
        int movingPoint = min;
        // moveVal is updated whenever our movingPoint changes. 
        int moveVal = arr[movingPoint];
        for (int i = min; i< max; i++){
            if (arr[i] <= pivot){
                if (i!=movingPoint){
                    int temp = moveVal;
                    arr[movingPoint] = arr[i];
                    arr[i] = temp;
                }
                movingPoint++; 
                moveVal = arr[movingPoint];
            }
        }
        // Swap 
        if(max!=movingPoint){
            arr[movingPoint] = arr[max];
            arr[max] = moveVal;
        }
        return movingPoint;

    }
    // Int array display
    public static void ShowArray(int [] arr){
        for (int i = 0; i<arr.length; i++){
            if(i!=0){
                System.out.print(",");
            }
            System.out.print(arr[i]);
        }
        System.out.println("");
    }
}
import java.util.Random;

class Sorts {
    public static void main(String[] args) {
        int[] test1 = SingleDigit();
        System.out.println("-Bubble-");
        ShowArray(test1);
        int[] result1 = Bubble(test1);
        ShowArray(result1);
        // -----
        System.out.println("--Count--");
        int[] test2 = SingleDigit();
        ShowArray(test2);
        int[] result2 = Count(test2);
        ShowArray(result2);
        // -----
        System.out.println("---Quick---");
        int[] test3 = SingleDigit();
        ShowArray(test3);
        int[] result3 = Quick(test3);
        ShowArray(result3);
        // -----
        System.out.println("----Radix----");
        int[] test4 = MultiDigit();
        ShowArray(test4);
        int[] result4 = Radix(test4);
        ShowArray(result4);
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
    // Counting Sort --------------------------------------------------------------
    public static int[] Count(int[] arr){
        int [] count = {0,0,0,0,0,0,0,0,0,0};
        int[] fixedArr = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            fixedArr[i] = arr[i];
            count[arr[i]]++;
        }
        for (int i=1; i<count.length;i++){
            count[i] += count[i-1];
        }
        for (int i=arr.length-1;i>=0;i--){
            count[fixedArr[i]]--;
            arr[count[fixedArr[i]]] = fixedArr[i];
        }
        return arr;
    }
    // Radix Sort -----------------------------------------------------------
    public static int[] Radix(int[] arr){
        int digits = 1;
        for (int i=0; i<arr.length; i++){
            int digiCount = 1;
            int temp = arr[i] / 10;
            while(temp!=0){
                digiCount++;
                temp = temp / 10;
            }
            if (digiCount>digits){
                digits = digiCount;
            }
        }
        int mod = 1;
        for (int d=0; d<digits; d++){
            int[] tempArr = new int[arr.length];
            int[] fixedArr = new int[arr.length];
            int low = mod;
            mod = mod * 10;
            int[] count = {0,0,0,0,0,0,0,0,0,0};
            for (int i=0; i<arr.length;i++){
                fixedArr[i] = arr[i];
                tempArr[i] = (arr[i]%mod) / low;
                count[tempArr[i]]++;
            }
            for (int j=1; j<count.length;j++){
                count[j] += count[j-1];
            }
            for (int i=arr.length-1;i>=0;i--){
                count[tempArr[i]]--;
                arr[count[tempArr[i]]] = fixedArr[i];
            }
        }
        return arr;
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

    public static int[] SingleDigit(){
        Random r = new Random();
        int len = r.nextInt(14) + 1;
        int[] newArr = new int[len];
        for (int i=0;i<len;i++){
            newArr[i] = r.nextInt(9);
        }
        return newArr;
    }

    public static int[] MultiDigit(){
        Random r = new Random();
        int len = r.nextInt(24) + 1;
        int[] newArr = new int[len];
        for (int i=0;i<len;i++){
            newArr[i] = r.nextInt(9999);
        }
        return newArr;
    }
}
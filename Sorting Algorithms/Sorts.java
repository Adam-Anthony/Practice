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

    public static int[] Bubble(int[] arr){
        int temp = 0;
        for (int i=arr.length-1;i>1;i--){
            for (int j=0; j<i; j++){
                if (arr[j] > arr[j+1]){
                   temp = arr[j];
                   arr[j]= arr[j+1];
                   arr[j+1] = temp; 
                }
            }
        }
        return arr;
    } 
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
    // Quick Sort methods
    public static int[] Quick(int[] arr){
        SubQuick(arr, 0, arr.length-1);
        return arr;
    }
    public static void SubQuick(int[] arr, int min, int max){
        if (min < max){
            int pivotPoint = SubSort(arr, min, max);
            SubQuick(arr, min, pivotPoint - 1);
            SubQuick(arr, pivotPoint+1, max);
        }
        
    }
    public static int SubSort(int[] arr, int min, int max){
        int pivot = arr[max];
        int movingPoint = min;
        int moveVal = arr[movingPoint];
        for (int i = min; i< max; i++){
            if (arr[i] <= pivot){
                int temp = moveVal;
                arr[movingPoint] = arr[i];
                arr[i] = temp;
                movingPoint++; 
                moveVal = arr[movingPoint];
            }
        }
        arr[movingPoint] = arr[max];
        arr[max] = moveVal;
        
        return movingPoint;

    }
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
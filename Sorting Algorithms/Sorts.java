class Sorts {
    public static void main(String[] args) {
        System.out.println("Hey world; What's up?");
        int[] test = {1,5,9,4,4,3,6,7};
        ShowArray(test);
        Bubble(test);
        ShowArray(test);
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
        return arr;
    }
    public static int[] Quick(int[] arr){
        return arr;
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
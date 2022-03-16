import Sorts;
class TestGround{
    public static void main(String[] args){
        Sorts so = new Sorts();
        int[] a = so.SingleDigit();
        int[] b = so.MultiDigit();
        so.ShowArray(a);
        so.ShowArray(b);
        System.out.println("------");
        // Bubble Sort
        /*
        int[] bubbleA = so.Bubble(a);
        int[] bubbleB = so.Bubble(b);
        so.ShowArray(bubbleA);
        so.ShowArray(bubbleB); 
        */
        // Quick Sort
        /*
        int[] qucikA = so.Bubble(a);
        int[] quickB = so.Bubble(b);
        so.ShowArray(quickA);
        so.ShowArray(quickB);
        */
        // Counting Sort
        /*
        int[] countA = so.Count(a);
        so.ShowArray(countA);
        */
        // Radix Sort
        
        int[] radixA = so.Radix(a);
        int[] radixB = so.Radix(b);
        so.ShowArray(radixA);
        so.ShowArray(radixB);
        
    }
}
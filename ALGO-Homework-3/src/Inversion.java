import java.util.Scanner;
import java.util.LinkedList;

public class Inversion {
    Scanner keyboard = new Scanner(System.in);
    Double[] nums = {6.0, 5.0, 4.0, 3.0, 2.0, 1.0};

    public void start() {
        System.out.println("Welcome to Algorithm Stuff.");
        System.out.println("Select a method to use. (E for easy O(n^2) algorithm, F for faster O(n log(n)) algorithm)");
        String input = keyboard.nextLine();

        switch (input) {
            case "e":
            case "E":
                System.out.println(easyinversioncount(nums));
                break;

            case "f":
            case "F":
                System.out.println("Yea IMGD 4000 is kicking my butt, so this doesn't exist.");
                //System.out.println(fastinversioncount(nums));
                break;

            default:
                System.out.println("Invalid Entry");
                start();
                break;
        }
    }

    public LinkedList<LinkedList<Double>> easyinversioncount(Double[] arrayOfNums) {
        LinkedList<LinkedList<Double>> result = new LinkedList<>();

        for (int i = 0; i < arrayOfNums.length - 1; i++) {
            for (int j = i + 1; j < arrayOfNums.length && i < j; j++) {
                // if value of this index is less than value of previous index
                if (arrayOfNums[j] < arrayOfNums[i]) {
                    LinkedList<Double> temp = new LinkedList<>();
                    temp.add(arrayOfNums[i]);
                    temp.add(arrayOfNums[j]);
                    result.add(temp);
                }
            }
        }

        return result;
    }

//    public LinkedList<LinkedList<Double>> fastinversioncount(Double[] arrayOfNums) {
//        LinkedList<LinkedList<Double>> result = new LinkedList<>();
//        Double[] workArray = {};
//        TopDownMergeSort(nums, workArray, nums.length);
//
//        return result;
//    }
//
//    //---------------------------------------------------------------------------------------------
//    // Array A[] has the items to sort; array B[] is a work array.
//    void TopDownMergeSort(Double[] A, Double[] B, int n) {
//        CopyArray(A, n, B);           // one time copy of A[] to B[]
//        TopDownSplitMerge(B, 0, n, A);   // sort data from B[] into A[]
//    }
//
//    // Split A[] into 2 runs, sort both runs into B[], merge both runs from B[] to A[]
//// iBegin is inclusive; iEnd is exclusive (A[iEnd] is not in the set).
//    void TopDownSplitMerge(Double[] B, int iBegin, int iEnd, Double[] A) {
//        if (iEnd - iBegin <= 1)                     // if run size == 1
//            return;                                 //   consider it sorted
//        // split the run longer than 1 item into halves
//        int iMiddle = (iEnd + iBegin) / 2;              // iMiddle = mid point
//        // recursively sort both runs from array A[] into B[]
//        TopDownSplitMerge(A, iBegin, iMiddle, B);  // sort the left  run
//        TopDownSplitMerge(A, iMiddle, iEnd, B);  // sort the right run
//        // merge the resulting runs from array B[] into A[]
//        TopDownMerge(B, iBegin, iMiddle, iEnd, A);
//    }
//
//    //  Left source half is A[ iBegin:iMiddle-1].
//// Right source half is A[iMiddle:iEnd-1   ].
//// Result is            B[ iBegin:iEnd-1   ].
//    void TopDownMerge(Double[] A, int iBegin, int iMiddle, int iEnd, Double[] B) {
//        int i = iBegin;
//        int j = iMiddle;
//
//        // While there are elements in the left or right runs...
//        for (int k = iBegin; k < iEnd; k++) {
//            // If left run head exists and is <= existing right run head.
//            if (i < iMiddle && (j >= iEnd || A[i] <= A[j])) {
//                B[k] = A[i];
//                i = i + 1;
//            } else {
//                B[k] = A[j];
//                j = j + 1;
//            }
//        }
//    }
//
//    void CopyArray(Double[] A, int iEnd, Double[] B) {
//        for (int k = 0; k < iEnd; k++)
//            B[k] = A[k];
//    }
}

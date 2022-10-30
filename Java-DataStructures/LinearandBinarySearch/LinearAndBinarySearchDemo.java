import java.util.Scanner;

public class LinearAndBinarySearchDemo {
   private static int linearSearch(int[] numbers, int key, int[] comparisons) {
      // Added parameter to hold total number of comparisons.
      comparisons[0] = 0;

      for (int i = 0; i < numbers.length; i++) {
         comparisons[0]++;
         if (numbers[i] == key) {
            return i;
         }
      }
      return -1; // not found
   }
   
   private static int binarySearch(int[] numbers, int key, int[] comparisons) {
      // Added parameter to hold total number of comparisons.
      comparisons[0] = 0;

      // Variables to hold the low, middle and high indices
      // of the area being searched. Starts with entire range.
      int low = 0;
      int mid = numbers.length / 2;
      int high = numbers.length - 1;
   
      // Loop until "low" passes "high"
      while (high >= low) {
         // Calculate the middle index
         mid = (high + low) / 2;

         // Cut the range to either the left or right half,
         // unless numbers[mid] is the key
         comparisons[0]++;
         if (numbers[mid] < key) {
            low = mid + 1;
         }
         else if (numbers[mid] > key) {
            high = mid - 1;
         }
         else {
            return mid;
         }
      }
   
      return -1; // not found
   }

   // Main program to test both search methods
   public static void main(String[] args) {
      int[] numbers = { 2, 4, 7, 10, 11, 32, 45, 87 };
      System.out.print("NUMBERS: ");
      for (int i = 0; i < numbers.length; i++) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();
      
      Scanner scnr = new Scanner(System.in);
      System.out.print("Enter an integer value: ");
      int key = scnr.nextInt();
      System.out.println();
      
      int[] comparisons = new int[1];
      int keyIndex = linearSearch(numbers, key, comparisons);
      if (keyIndex == -1) {
         System.out.printf(
            "Linear search: %d was not found with %d comparisons.\n",
            key, comparisons[0]);
      }
      else {
         System.out.printf(
            "Linear search: Found %d at index %d with %d comparisons.\n",
            key, keyIndex, comparisons[0]);
      }
      
      keyIndex = binarySearch(numbers, key, comparisons);
      if (keyIndex == -1) {
         System.out.printf(
            "Binary search: %d was not found with %d comparisons.\n",
            key, comparisons[0]);
      }
      else {
         System.out.printf(
            "Binary search: Found %d at index %d with %d comparisons.\n",
            key, keyIndex, comparisons[0]);
      }
   }
}

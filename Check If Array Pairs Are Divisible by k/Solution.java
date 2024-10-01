public class PairSumDivisibleByK {

    public static boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        
        // If the length of the array is odd, we can't form pairs
        if (n % 2 != 0) {
            return false;
        }

        // Create a frequency array to store counts of remainders
        int[] remainderCount = new int[k];
        
        // Fill the frequency array with the counts of remainders
        for (int num : arr) {
            // Calculate remainder, ensure it's positive
            int remainder = ((num % k) + k) % k;
            remainderCount[remainder]++;
        }

        // Check for valid pairs
        for (int i = 0; i <= k / 2; i++) {
            if (i == 0) {
                // Special case: elements with remainder 0 must pair with each other
                if (remainderCount[i] % 2 != 0) {
                    return false;
                }
            } else {
                // Elements with remainder 'i' must pair with elements with remainder 'k - i'
                if (remainderCount[i] != remainderCount[k - i]) {
                    return false;
                }
            }
        }

        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr1 = {9, 7, 5, 3};
        int k1 = 6;
        System.out.println(canArrange(arr1, k1)); // Output: true

        int[] arr2 = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k2 = 5;
        System.out.println(canArrange(arr2, k2)); // Output: true

        int[] arr3 = {1, 2, 3, 4, 5, 6};
        int k3 = 7;
        System.out.println(canArrange(arr3, k3)); // Output: true

        int[] arr4 = {1, 2, 3, 4, 5, 6};
        int k4 = 10;
        System.out.println(canArrange(arr4, k4)); // Output: false
    }
}

package Assignment1;

public class BinarySearch {
    //---------- Part 1A: Iterative version of binary search -------------------//

    //We use the Comparable class to make the implementations generic for all types of arrays e.g. Integers, Strings.
    public static <V extends Comparable<? super V>> boolean containsIterative(V[] array, V value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) { //the loop continues until low <= high, because after this limit, the same values will be checked again
            int mid = (low + high) / 2;
            int comparison = value.compareTo(array[mid]);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    //---------- TASK 2: Recursive version of binary search -------------------//
    public static <V extends Comparable<? super V>> boolean containsRecursive(V[] array, V value) {
        int low = 0;
        int high = array.length - 1;
        return helpRecursive(array, value, low, high);
    }

    //The original function does not keep track of the indices in its method signature
    //But the original method signature cannot be changed for abstraction reasons
    //So we create a helper function which can keep track of these indices and call this helper function from the original method
    public static <V extends Comparable<? super V>> boolean helpRecursive(V[] array, V value, int low, int high) {
        if (low > high) { //The terminating condition in the loop is the base case for the recursion
            return false;
        }
        else {
            int mid = (low + high) / 2;
            int comparison = value.compareTo(array[mid]);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                return helpRecursive(array, value, low, mid - 1);
            } else {
                return helpRecursive(array, value, mid + 1, high);
            }
        }
    }

    //---------- TASK 3: Binary search returning the first index --------------//
    public static <V extends Comparable<? super V>> int firstIndexOf(V[] array, V value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = value.compareTo(array[mid]);

            if (comparison == 0) {
                //Check previous element to see if the first index should be different
                //We only check the previous element because the array is sorted. The repeated value would immediately
                //precede or succeed the current value. The succeeding value can't be the first occurrence, so is not important here.
                if (mid > 0 && value.compareTo(array[mid - 1]) == 0) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        //Test 1: Empty array
        Integer[] emptyArray = {};
        assert containsIterative(emptyArray, 1) == false;
        assert containsRecursive(emptyArray, 1) == false;
        assert firstIndexOf(emptyArray, 1) == -1;

        //Test 2: Element does not exist (Integer array)
        Integer[] intArrWithoutVal = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assert containsIterative(intArrWithoutVal, 12) == false;
        assert containsRecursive(intArrWithoutVal, 12) == false;
        assert firstIndexOf(intArrWithoutVal, 12) == -1;

        //Test 3: Element does not exist (String array)
        String[] strArrWithoutVal = {"apple", "ball", "elephant", "flower", "goat", "house", "ice cream"};
        assert containsIterative(strArrWithoutVal, "dog") == false;
        assert containsRecursive(strArrWithoutVal, "dog") == false;
        assert firstIndexOf(strArrWithoutVal, "dog") == -1;

        //Test 4: Element exists - Large integer array with unique values
        Integer[] uniqueIntArr = new Integer[1000]; //{1, 2, 3 .... 1000}
        for (int i = 0; i < uniqueIntArr.length; i++) {
            uniqueIntArr[i] = i + 1;
        }

        assert containsIterative(uniqueIntArr, 983) == true;
        assert containsRecursive(uniqueIntArr, 983) == true;
        assert firstIndexOf(uniqueIntArr, 983) == 982;

        //Test 5: Element exists - Large integer array with duplicate values
        Integer[] dupIntArr = new Integer[1000]; // { [50 copies of 1], [450 copies of 999]}
        for (int i = 0; i < dupIntArr.length; i++) {
            if (i < 50) {
                dupIntArr[i] = 1;
            }
            else {
                dupIntArr[i] = 999;
            }
        }

        assert containsIterative(dupIntArr, 1) == true;
        assert containsRecursive(dupIntArr, 1) == true;
        assert firstIndexOf(dupIntArr, 1) == 0;
    }
}
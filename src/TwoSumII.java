
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{};
        }
        //return array
        int[] result = new int[2];
        //two pointers, start from leftmost and rightmost indices
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            //discard left element
            if (numbers[left] + numbers[right] < target) {
                left++;
            //discard right element
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
        }
        // not found
        return null;
    }
}

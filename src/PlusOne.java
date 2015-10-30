
public class PlusOne {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        if (digits == null || digits.length == 0) {
            return null;
        }
        
        LinkedList<Integer> list = new LinkedList<>();
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = (digits[i] + plus) % 10;
            list.add(0, num);
            plus = (digits[i] + plus) / 10;
        }
        if (plus != 0) {
            list.add(0, plus);
        }
        //convert list to int[] type
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

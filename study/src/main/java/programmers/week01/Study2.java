package programmers.week01;

public class Study2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.solution(new int[] {1,2,7,6,4}));
    }
}

class Solution2 {
    public int solution(int[] nums) {
        int result = 0;

        int sum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    for (int x = 2; x <= Math.sqrt(sum); x++) {
                        if (sum % x == 0) {
                            break;
                        } else if (x == (int)Math.sqrt(sum)) {

                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
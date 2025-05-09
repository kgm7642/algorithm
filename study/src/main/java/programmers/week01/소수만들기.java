package programmers.week01;

public class 소수만들기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,7,6,4}));
    }

    public static int solution(int[] nums) {
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
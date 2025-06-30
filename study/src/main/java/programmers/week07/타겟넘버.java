package programmers.week07;

public class 타겟넘버 {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        Solution_타겟넘버 solution = new Solution_타겟넘버();
        System.out.println(solution.solution(numbers, target));
    }
}

//class Solution_타겟넘버 {
//    public int solution(int[] numbers, int target) {
//        //✅ DFS 탐색을 통해 합이 target이 되는 경우의 수를 구한다.
//        return dfs(numbers, 0, target, 0);
//    }
//
//    int dfs(int[] numbers, int index, int target, int cur) {
//        if (index == numbers.length) {
//            return (cur == target) ? 1 : 0;
//        }
//
//        int sum = 0;
//        sum += dfs(numbers, index + 1, target, cur + numbers[index]);
//        sum += dfs(numbers, index + 1, target, cur - numbers[index]);
//
//        return sum;
//    }
//}

class Solution_타겟넘버 {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target, 0);
    }

    int dfs(int[] numbers, int index, int target, int cur) {
        if(index == numbers.length) {
            return (cur == target) ? 1:0;
        }
        int sum = 0;
        sum += dfs(numbers, index+1, target, cur+numbers[index]);
        sum += dfs(numbers, index+1, target, cur-numbers[index]);
        return sum;
    }
}
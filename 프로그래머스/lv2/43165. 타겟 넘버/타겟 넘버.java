class Solution {
    int cnt;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, target, 0, 0);
        return cnt;
    }
    public void dfs(int[] numbers, int target, int depth, int num){
        if(depth == numbers.length){
            if(num == target) cnt++;
            return;
        }
        dfs(numbers, target, depth+1, num + numbers[depth]);
        dfs(numbers, target, depth+1, num - numbers[depth]);   
    }
}
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++){
            int price = prices[i];
            int time = 0;
            for(int j=i+1; j<prices.length; j++){
                if(prices[j] < price){
                    time = j - i;
                    break;
                }else{
                    time++;
                }
            }
            answer[i] = time;
        }
        return answer;
    }
}
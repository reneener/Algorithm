class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        if(a != b && a != c && b != c)
            return a+b+c;
        else if((a == b && a != c) || (a == c && a != b) || (b == c && a != b))
            return (a+b+c) * (int)(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
        else
            return (a+b+c) * (int)(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)) * (int)(Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
    }
}
public class MakePrimeNumber{
    public static void main(String[] args){
    }
}


class Solution{
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;
        boolean isPrime = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    sum = nums[i] + nums[j] + nums[k];
                    isPrime = isPrime(sum);
                    if(isPrime) answer++;
                }
            }
        }
        return answer;
    }

    public boolean isPrime(int num){
        for (int t = 2; t <= (int)Math.sqrt(num); t++){
            if(num%t == 0) return false;
        }
        return true;
    }
}

package 코딩테스트;
import java.util.*;
import java.util.stream.IntStream;
public class 코딩테스트2일차 {
	
	class Solution {
	    public int[] solution(int[] numbers, int num1, int num2) {
	    	//numbers배열을 num1부터 num2까지 인덱스 자르기
	        return Arrays.copyOfRange(numbers, num1, num2 + 1);
	    }
	}
	//배열값 2배로 만들기 본인방식과 다름
	public int[] solution1(int[] numbers) {
        return Arrays.stream(numbers).map(i -> i * 2).toArray();
    }
    /*
    삼각형 완성조건 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 한다.
    */
    public int solution2(int[] sides) {
        int answer = 2;
        Arrays.sort(sides);
        if(sides[2]<(sides[0]+sides[1])){
            answer = 1;
        }
        return answer;
    }
    /*
    my_string에서 letter제거한 문자열 return
    */
    public String solution3(String my_string, String letter) {
        String answer = my_string.replace(letter,"");
        return answer;
    }
    /*
    아메리카노 한잔 5500 살수있는 갯수 남는 돈
    */
    public int[] solution4(int money) {
        int[] answer = new int[2];
        answer[0] = money/5500;
        answer[1] = money%5500;
        return answer;
    }
    public int[] solution5(int n) {
    	//홀수만 배열에 넣기  본인방식과 다름
        return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();
    }
    //배열의 유사도
    public int solution6(String[] s1, String[] s2) {
        int answer = 0;
            String one = "";
            String two = "";
        for(int i = 0;i<s1.length;i++){
            one = s1[i];
            for(int j=0;j<s2.length;j++){
                two = s2[j];
                if(one.equals(two)){
                    answer++;
                }
            }
        }
        return answer;
    }
    //제곱수 판별하기 본인 방식과 다름
    public int solution7(int n) {
        if (n % Math.sqrt(n) == 0) {
            return 1;
        } else {
            return 2;
        }
    }
    //자릿수 더하기
    public int solution8(int n) {
        int answer = 0;
        int sum = 0;
        while(n>0){
            sum = sum + (n%10);
            n = n/10;
            
        }
        answer = sum + n;
        
        return answer;
    }
    //본인은 곱하기로 풀었으나 나누기로 풀어야 시간이 적게 걸림
    public int solution9(int n) {
        int answer = 0;
        for (int loop = 1; loop <= n; loop++) {
           if (n % loop == 0) 
              answer++;
        }
        return answer;
    }
}

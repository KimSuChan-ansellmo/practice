package 코딩테스트;

import java.util.*;

public class 코딩테스트4일차 {
    //문자열 소문자로 만들고 정렬하기
    public String solution1(String my_string) {
        String answer = "";
        my_string = my_string.toLowerCase();
        char[] tmp = my_string.toCharArray();
        //char[] charArr = my_string.toLowerCase().toCharArray(); 한번에 가능함
        Arrays.sort(tmp);
        answer = new String(tmp);
        return answer;
    }
    
    //최대값 만들기2 반복문 초기 조건때문에 답이 안나왔었다.
    public int solution2(int[] numbers) {
        int answer = numbers[0]*numbers[1];
        int max = 0;
        for(int i = 0;i<numbers.length-1;i++){
            for(int j = i+1;j<numbers.length;j++){
                max = numbers[i]*numbers[j];
                if(max>answer){
                    answer = max;
                }    
            }  
        }
        return answer;
    }
    
    //369게임
    public int solution3(int order) {
        int answer = 0;
        String tmp = Integer.toString(order);
        int[] or = new int[tmp.length()];
        for(int i = 0;i<tmp.length();i++){
            or[i] = tmp.charAt(i)-'0';
        }
        for(int i =0; i<or.length;i++){
            if(or[i] !=0){
                if(or[i] % 3 == 0 || or[i]%6 == 0 || or[i]%9 ==0 )answer++;
            }
        }
         return answer;
    }
//    다른사람 풀이
//    public int solution(int order) {
//        return (int) Arrays.stream(String.valueOf(order).split("")).map(Integer::parseInt).filter(i -> i == 3 || i == 6 || i == 9).count();
//    }
    
    //합성수 찾기 다른사람풀이
    public int solution4(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) cnt++;
            }
            if (cnt >= 3) answer++;
        }

        return answer;
    }
    //중복된 문자 제거
    //indexOf( )는 중복된 문자의 첫 인덱스만 반환한다.
    public String solution5(String my_string) {
        String answer = "";
        char[] tmp = my_string.toCharArray();
        for(int i = 0; i<my_string.length();i++){
            if(my_string.indexOf(tmp[i]) == i){
                answer += tmp[i];
            }
        }
        return answer;
    }
    
    //모스부호 맵에 넣든 배열에 넣든 일단 다 넣고 비교해서 만듦.
    public String solution6(String letter) {
        String answer = "";
        String[] result = letter.split(" ");
        for(int i = 0 ; i<result.length;i++){
            if(result[i].equals(".-"))answer+='a';
            if(result[i].equals("-..."))answer+='b';
            if(result[i].equals("-.-."))answer+='c';
            if(result[i].equals("-.."))answer+='d';
            if(result[i].equals("."))answer+='e';
            if(result[i].equals("..-."))answer+='f';
            if(result[i].equals("--."))answer+='g';
            if(result[i].equals("...."))answer+='h';
            if(result[i].equals(".."))answer+='i';
            if(result[i].equals(".---"))answer+='j';
            if(result[i].equals("-.-"))answer+='k';
            if(result[i].equals(".-.."))answer+='l';
            if(result[i].equals("--"))answer+='m';
            if(result[i].equals("-."))answer+='n';
            if(result[i].equals("---"))answer+='o';
            if(result[i].equals(".--."))answer+='p';
            if(result[i].equals("--.-"))answer+='q';
            if(result[i].equals(".-."))answer+='r';
            if(result[i].equals("..."))answer+='s';
            if(result[i].equals("-"))answer+='t';
            if(result[i].equals("..-"))answer+='u';
            if(result[i].equals("...-"))answer+='v';
            if(result[i].equals(".--"))answer+='w';
            if(result[i].equals("-..-"))answer+='x';
            if(result[i].equals("-.--"))answer+='y';
            if(result[i].equals("--.."))answer+='z';
        }
        return answer;
    }
    
    //num_list를 n의 길이로 잘라서 2차원 배열로 만들기 다른사람 풀이
    public int[][] solution7(int[] num_list, int n) {
        int[][] answer = {};

        int length = num_list.length;

        answer = new int[length/n][n];

        for(int i=0; i<length; i++){  // for문 한번만 사용
            answer[i/n][i%n]=num_list[i];   // 나누기와 나머지.... 어렵다!
        }

        return answer;
    }
    
    //i에서 j까지 k가 몇번 나오는가? 답은 나오지만 속도가 오래걸림
    public int solution8(int i, int j, int k) {
        int answer = 0;
        //i부터 j까지 숫자를 스트링으로 나열
        String step1 = "";
        for(int x = i;x<=j;x++){
            step1 += Integer.toString(x);
        }
        //스트링을 한 글자씩 나누기
        String[] step2 = step1.split("");
        String step3 = Integer.toString(k);
        //step2에서 step3가 몇번이나 나오는가?
        for(int x = 0;x<step2.length ;x++){
            if(step2[x].equals(step3))answer++;
        }
        return answer;
    }
//    어쨰서 이런 답이 나오는지 모르겠다.
//    public int solution8(int i, int j, int k) {
//        int answer = 0;
//
//        for (int num = i; num <= j; num++){
//            int tmp = num;
//            while (tmp != 0){
//                if (tmp % 10 == k)
//                    answer++;
//                tmp /= 10;
//            }
//        }
//        return answer;
//    }
    //A로 B만들기 아스키코드숫자로 총 합이 같으면 1 아니면 0
    public int solution9(String before, String after) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < before.length(); i++) {
            sum1 += before.charAt(i);
            sum2 += after.charAt(i);
        }
        return (sum1 == sum2)? 1 : 0;
    }
//    이게 훨씬 나은것 같다.
//    public int solution9(String before, String after) {
//        char[] a = before.toCharArray();
//        char[] b = after.toCharArray();
//        Arrays.sort(a);
//        Arrays.sort(b);
//
//        return new String(a).equals(new String(b)) ? 1 :0;
//    }
    
    //팩토리얼 재귀함수를 써야 한다니. 입문 맞아?
    public int solution10(int n) {
        int answer = 0;
            for(int i = 1; i<=10;i++){
                if(fac(i) <= n){
                    answer = i;
                }
            }
        return answer;
    }
    int fac(int n){
            if(n<=1){
                return 1;
            }else{
                return n*fac(n-1);
            }
    }
//    다른사람 풀이
//    public int solution10(int n) {
//        int fac = 1;
//        int i = 0;
//
//        while(true){
//            if(fac <= n){
//                fac *= i + 1;
//                i++;
//            }else break;
//        }
//
//        return i-1;
//    }
    //가까운수
    public int solution11(int[] array, int n) {
        int answer = 0;
        //배열 정렬
        Arrays.sort(array);
        for(int i = 1 ; i < array.length ; i++){
        	//0부터 하나씩 절대값 비교해서 0을 가장 작은 값으로 치환
            if(Math.abs(n-array[0]) > Math.abs(n-array[i])){
                array[0] = array[i];
            }
        }
        answer = array[0];
        return answer;
    }
    //진료 순서 정하기 밑의 for문을 생각해내는 공부를 해야할 것
    public int[] solution12(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] step1 = new int[emergency.length];
        for(int i = 0;i<emergency.length;i++){
            step1[i] = emergency[i];
        }
        Arrays.sort(step1);
        
        for(int i = 0; i<=emergency.length-1;i++){
            for(int j =0;j<=emergency.length-1;j++){
                if(step1[i] == emergency[j]){
                    answer[j] = emergency.length-i;
                }
            }
        }
        
        return answer;
    }
    
    //7의 갯수
    public int solution13(int[] array) {
        int answer = 0;
        //숫자배열을 스트링으로 숫자만 가져오는 코드
        String step1 = Arrays.toString(array).replaceAll("[^0-9]","");
        for(int i = 0; i<step1.length();i++){
            if(step1.charAt(i) == '7'){
                answer++;
            }
        }
        return answer;
    }
    //이진수 더하기 Long의 코드로 이진수 계산이 가능한가봄!
    public String solution14(String bin1, String bin2) {
        String answer = "";
        long newValue = Long.parseLong(bin1, 2) + Long.parseLong(bin2, 2);
        //return Integer.toString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2),2);
        return Long.toBinaryString(newValue);
    }
}

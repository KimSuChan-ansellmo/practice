package 코딩테스트;

import java.util.*;

public class 코딩테스트3일차 {
	//옷가게 할인받기
    public int solution1(int price) {
        int answer = price;
        if(price>=500000){
            price *= 0.8;
        }else if(price>=300000){
            price *= 0.9;
        }else if(100000<=price){
            price*=0.95;
        }
        return price;
    }
    //문자열 안에 문자열
    public int solution2(String str1, String str2) {
        int answer = 2;
        if(str1.contains(str2)){
            answer = 1;   
        }
        return answer;
    }
    //중앙값 구하기
    public int solution3(int[] array) {
        int answer = 0;
        int len = array.length/2;
        Arrays.sort(array);
        answer = array[len];
        return answer;
    }
    //모음 지우기 본인 방식과 다름
    public String solution4(String my_string) {
        String answer = "";

        answer = my_string.replaceAll("[aeiou]", "");

        return answer;
    }
    //숨어있는 숫자의 덧셈 1 정규식으로 문자는 지웠으나 단순 자리수 더하기로는 int값을 초과함. String.valueOf 사용하는 다른사람의 코드
    public int solution5(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[a-z,A-Z]","");
        for(int i=0; i<my_string.length(); i++) {
                answer += Integer.parseInt(String.valueOf(my_string.charAt(i)));
            } 
        return answer;
    }
    //직각 삼각형 만들기 본인 방식과 다름 repeat메소드 사용하는 방식
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            System.out.println("*".repeat(i));
        }
    }
    //1시간만에 2배만큼 증식 처음 n마리를 t시간만큼 경과했을 때
    public int solution7(int n, int t) {
        int answer = n;
        for(int i = 1;i<=t;i++){
            answer *= 2;
        }
        return answer;
    }
     //n의 배수 고르기 IntStream과 Stream공부해야함
    public int[] solution8(int n, int[] numlist) {
        return Arrays.stream(numlist).filter(value ->value % n == 0).toArray();
    }
    
    public int[] solution9(String my_string) {
        
        my_string = my_string.replaceAll("[^0-9]","");
        int[] answer = new int[my_string.length()];
        for(int i = 0;i<my_string.length();i++){
            answer[i] = my_string.charAt(i)-'0';
        }
        Arrays.sort(answer);
        return answer;
    }
//    이거 어떻게 생각함...? 다른사람 풀이
//    public int[] solution9(String myString) {
//        return Arrays.stream(myString.replaceAll("[A-Z|a-z]", "").split("")).sorted().mapToInt(Integer::parseInt).toArray();
//    }
    
    //0이 2를 이김 2가 5를 이김 5가 0을 이김 0>2>5>0
    public String solution10(String rsp) {
        String answer = "";
        //tmp = rsp.toCharArray(); 사용해서 switch case 사용하는 방법이 있음.
        char[] tmp = new char[rsp.length()];
        
        for(int i = 0; i<rsp.length();i++){
            tmp[i] = rsp.charAt(i);
        }
        char[] result = new char[tmp.length];
        for(int i =0;i<tmp.length;i++){
            if(tmp[i]=='0'){
                result[i] = '5';
            }else if(tmp[i]=='2'){
                result[i] = '0';
            }else if(tmp[i]=='5'){
                result[i] = '2';
            }
        }   
        answer = new String(result);
        return answer;
    }
    //다른사람 풀이 아스키코드 알아야함...
    public String solution11(String my_string) {
        String answer = "";
        char[] arry = my_string.toCharArray();
		// a ~ z 97 ~122
		// A ~ Z 65~90
		String temp ="";
		//char 배열로 만들어서 하나씩 꺼내고 (asci 코드 사용) 대소문자 변환하기.
		for(int i = 0; i<arry.length; i++) {
			if( arry[i] >= 97 && arry[i] <= 122 ) {
				temp = arry[i] + "";
				answer += temp.toUpperCase();
			} else if( arry[i] >=65 && arry[i] <= 90){
				temp = arry[i] + "";
				answer += temp.toLowerCase();
			}
		}
        return answer;
    }
    
    //장군개미 5 병정개비 3 일개미 1 최소한의 병력
    public int solution12(int hp) {
        int answer = 0;
        int general = 0;
        int soilder = 0;
        general = hp/5;
        hp = hp%5;
        soilder = hp/3;
        hp = hp%3;
        answer = general + soilder + hp;
        return answer;
    }
    public int[] solution13(int[] array) {
        int[] answer = new int[2];
        int[] tmp = new int[array.length];
        for(int i = 0; i<array.length;i++){
            tmp[i] = array[i];
        }
        Arrays.sort(tmp);
        
        int max = tmp[tmp.length-1];
        answer[0] = max;
        for(int i = 0;i<array.length;i++){
            if(array[i] == max){
                answer[1] = i;
            }
        }
        return answer;
    }
    
//    더 간단한 방법 괜히 배열 또 만들 필요가 없었음
//    public int[] solution13(int[] array) {
//        int[] answer = new int[2];
//        for(int i=0; i<array.length; i++){
//            if(answer[0] < array[i]){
//                answer[0] = array[i];
//                answer[1] = i;
//            }
//        }
//        return answer;
//    }
    
    //상자에 최대한 많은 주사위를 넣고 싶음. box는 가로 세로 높이, 주사위 길이는 n 최대 개수를 return
    public int solution14(int[] box, int n) {
        int answer = 0;
        int garo = box[0]/n;
        int sero = box[1]/n;
        int height = box[2]/n;
        answer = garo*sero*height;
        return answer;
    }
    //약수구하기
    public int[] solution15(int n) {
        int[] arry = new int[10000];
        int index =0;
       
        for(int i = 1; i<=n; i++) {
			if(n%i ==0) {
				arry[index] = i;
				index++;
			}
		}
		int[] answer = new int [index];
		for(int i = 0; i<index; i++) {
			if(arry[i] != 0) {
				answer[i] = arry[i];

			}
		}
        return answer;
    }
//    이 방법을 사용하려 했으나 i가 증가하는지를 알지 못했음. 가능한것 같음
//    public int[] solution15(int n) {
//        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).toArray();
//    }
    
    //배열 회전시키기
    public int[] solution16(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];

        
        if(direction.equals("right")){
            answer[0] = numbers[numbers.length-1];
            for(int i = 1;i<numbers.length;i++){
                answer[i] = numbers[i-1];
            }
        }else if(direction.equals("left")){
            for(int i = 0;i<answer.length-1;i++){
                answer[i] = numbers[i+1];
            }
            answer[answer.length-1] = numbers[0];
        }
       
        return answer;
    }
    //인덱스 바꾸기
    public String solution17(String my_string, int num1, int num2) {
        String answer = "";
        char one = my_string.charAt(num1);
        char two = my_string.charAt(num2);
        char[]tmp = my_string.toCharArray();
        tmp[num1] = two;
        tmp[num2] = one;
        answer = new String(tmp);
        return answer;
    }
//    swap기능이 있다?
//    public String solution17(String myString, int num1, int num2) {
//        List<String> list = Arrays.stream(myString.split("")).collect(Collectors.toList());
//
//        Collections.swap(list, num1, num2);
//        return String.join("", list);
//    }
    
    //암호해독
    public String solution18(String cipher, int code) {
        String answer = "";
        char[] cp = cipher.toCharArray();
        char[] a = new char[10000];
        int cnt = 0;
        for(int i = 0; i<cipher.length();i++){
            if((i+1)%code==0){
                a[cnt] = cp[i];
                cnt++;
            }
        }
        for(int i = 0;i<cnt;i++){
            answer += a[i];
        }
        
        return answer;
    }
//    암호해독 다른사람 풀이
//    public String solution18(String cipher, int code) {
//        String answer = "";
//
//        for (int i = code; i <= cipher.length(); i = i + code) {
//            answer += cipher.substring(i - 1, i);
//        }
//
//        return answer;
//    }
    
    
    //숫자찾기
    public int solution19(int num, int k) {
        int answer = -1;
        char ck = (char)(k+'0');
        String tmp = String.valueOf(num);
        char[] numC = tmp.toCharArray();
        for(int i = numC.length-1;0<=i;i--){
            if(numC[i] == ck){
                answer = i+1;
            }
        }
        return answer;
    }
    
//    indexOf사용하는 방법이 있다!
//    public int solution19(int num, int k) {
//        String numStr = String.valueOf(num);
//        String kStr = String.valueOf(k);
//
//        int answer = numStr.indexOf(kStr);
//        return answer < 0 ? -1 : answer + 1 ;
//    }
    
    //피자 무조건 6조각
    //n명이 남기지 않고 같은수의 피자조각을 먹어야 함
    public int solution20(int n) {
        int answer = 0;
        int max = 1;
        for(int i=1;i<=n && i<=6;i++){
            if(n%i == 0 && 6 % i== 0){
                max = i;
            }
        }
        answer = n * 6 / max / 6;
        return answer;
    }
    
//    이쪽이 좀더 간단한 코드인듯.
//    public int solution20(int n) {
//        int answer = 1;
//
//        while(true){
//            if(6*answer%n==0) break;
//            answer++;
//        }
//
//        return answer;
//    }
    
    //외계행성의 나이
    public String solution21(int age) {
        String answer = "";
        String tmp = String.valueOf(age);
        String[] result = tmp.split("");
        for(int i = 0;i<result.length;i++){
            answer += ((char)(Integer.parseInt(result[i]) + 97));
        }
        return answer;
    }
    
//    다른 사람의 풀이
//    public String solution(int age) {
//        String answer = "";
//        String[] alpha = new String[]{"a","b","c","d","e","f","g","h","i","j"};
//
//        while(age>0){
//            answer = alpha[age % 10] + answer;
//            age /= 10;
//        }
//
//        return answer;
//    }
}

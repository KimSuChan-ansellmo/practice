package 코딩테스트;

import java.util.*;

public class 코딩테스트5 {
	// 오른쪽 한명 건너뛰고 던짐.6명이라면 1-3-5-1, 3명이면 1-3-2-1
	// 무조건 1번부터 던짐 k번째 공을 던지는 사람 번호
	public int solution1(int[] numbers, int k) {
		int answer = 0;
		// numbers[0]부터 시작 0 - 2 - 4 이렇게 나가다가 numbers길이보다 길어지면 다시 0부터 세야함
		// length가 5 면 0 - 2 - 4 - 1 - 3 - 0
		// 1 - 3 - 5 - 2 - 4 - 1
		answer = numbers[2 * (k - 1) % numbers.length];
		return answer;
	}

	// 숨어있는 숫자의 계산
	public int solution2(String my_string) {
		int answer = 0;
		String[] step1 = my_string.replaceAll("[^0-9]", " ").split(" ");
		for (int i = 0; i < step1.length; i++) {
			if (step1[i].equals("")) {
				continue;
			} else {
				answer += Integer.parseInt(step1[i].trim());
			}
		}
		return answer;
	}

	// 잘라서 배열로 저장하기 --다른사람 풀이
	public String[] solution3(String my_str, int n) {
		int resultCnt = (my_str.length() + n - 1) / n;
		String[] answer = new String[resultCnt];

		for (int i = 0; i < resultCnt; i++) {
			int start = n * i;
			int end = start + n >= my_str.length() ? my_str.length() : start + n;
			answer[i] = my_str.substring(start, end);
		}

		return answer;
	}

	// 소인수 분해
	public int[] solution4(int n) {
		List<Integer> list = new ArrayList<>();
		int soinsu = 2;
		while (n > 1) {
			if (n % soinsu == 0) {
				if (!list.contains(soinsu)) {
					list.add(soinsu);
				}
				n /= soinsu;
				continue;
			}
			soinsu++;
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	// 영어가 싫어요
	public long solution5(String numbers) {
		long answer = 0;
		numbers = numbers.replace("zero", "0").replace("one", "1").replace("two", "2").replace("three", "3")
				.replace("four", "4").replace("five", "5").replace("six", "6").replace("seven", "7")
				.replace("eight", "8").replace("nine", "9");
		answer = Long.parseLong(numbers);
		return answer;
	}

	// 종이자르기 M x N 크기의 종이를 1x1크기로 자르려면 최소 몇번이나 잘라야 하나
	public int solution6(int M, int N) {
		int answer = 0;
		answer = M * N - 1;
		return answer;
	}

	// 문자열 계산하기 문자열로 된 수식을 계산해서 return
	public int solution7(String my_string) {
		int answer = 0;
		// 공백 하나로 구분되어있으므로 잘라서 배열 형태로
		String[] step1 = my_string.split(" ");
		// 숫자와 기호 구분 무조건 첫 배열은 숫자
		answer = Integer.parseInt(step1[0]);
		for (int i = 1; i < step1.length; i++) {
			if (i % 2 != 0) {
				if (step1[i].equals("+")) {
					answer += Integer.parseInt(step1[i + 1]);
				} else {
					answer -= Integer.parseInt(step1[i + 1]);
				}
			}
		}

		return answer;
	}
	// 다른사람풀이 Stream...
//    public int solution7(String myString) {
//        return Arrays.stream(myString.replaceAll("- ", "-").replaceAll("[+] ", "").trim().split(" ")).mapToInt(Integer::parseInt).sum();
//    }

	// 구슬을 나누는 경우의 수 재귀를 쓰는데 어떻게 하는건지 이해하지 못하겠음
	public long solution8(int balls, int share) {
		share = Math.min(balls - share, share);

		if (share == 0)
			return 1;

		long result = solution8(balls - 1, share - 1);
		result *= balls;
		result /= share;

		return result;
	}

	// 외계어 사전
	public int solution9(String[] spell, String[] dic) {
		int answer = 2;
		int cnt = 0;
		for (int i = 0; i < dic.length; i++) {
			if (dic[i].length() == spell.length) {
				for (int j = 0; j < spell.length; j++) {
					if (dic[i].contains(spell[j])) {
						cnt++;
					} else {
						cnt = 0;
						break;
					}
					if (cnt == spell.length) {
						answer = 1;
						break;
					}
				}
			}
		}
		return answer;
	}

	// 다른사람 풀이
//    public int solution9(String[] spell, String[] dic) {
//        int answer = 2;
//        for(String dicS : dic) {
//            boolean isRight = true;
//            for(String spellS : spell) {
//                if(dicS.indexOf(spellS) == -1) {
//                    isRight = false;
//                    break;
//                }
//            }
//            if(isRight) {
//                answer = 1;
//                break;
//            }
//        }
//        return answer;
//    }
	//캐릭터 좌표
	public int[] solution10(String[] keyinput, int[] board) {
		int[] answer = new int[2];
		answer[0] = 0;
		answer[1] = 0;
		int lr = board[0] / 2;
		int lc = board[1] / 2;
		for (int i = 0; i < keyinput.length; i++) {
			if (keyinput[i].equals("up")) {
				if (answer[1] >= lc) {
					answer[1] = lc;
				} else {
					answer[1]++;
				}
			} else if (keyinput[i].equals("down")) {
				if (answer[1] <= (lc * (-1))) {
					answer[1] = -1 * lc;
				} else {
					answer[1]--;
				}
			} else if (keyinput[i].equals("left")) {
				if (answer[0] <= (lr * (-1))) {
					answer[0] = -1 * lr;
				} else {
					answer[0]--;
				}
			} else if (keyinput[i].equals("right")) {
				if (answer[0] >= lr) {
					answer[0] = lr;
				} else {
					answer[0]++;
				}
			}
		}
		return answer;
	}
	//직사각형 넓이 구하기 max min 제한을 걸어야 테스트케이스 4번이 풀림
    public int solution11(int[][] dots) {
        int answer = 0;
        int maxr = -257;
        int minr = 257;
        int r= 0;
        int maxc = -257;
        int minc = 257;
        int c = 0;
        for(int i = 0; i<dots.length;i++){
                maxr = Math.max(maxr,dots[i][0]);
                minr = Math.min(minr,dots[i][0]);
                maxc = Math.max(maxc,dots[i][1]);
                minc = Math.min(minc,dots[i][1]);
        }
        r = maxr - minr;
        c = maxc - minc;
        answer = r*c;
        return answer;
    }
    //컨트롤 제트
    public int solution12(String s) {
        int answer = 0;
        String[] sa = s.split(" ");
        for(int i = 0; i<sa.length;i++){
            if(!sa[i].equals("Z")){
                answer += Integer.parseInt(sa[i]);
            }else if(sa[0].equals("Z")){
                continue;
            }else{
                answer -= Integer.parseInt(sa[i-1]);
            }
        }
        return answer;
    }
    //다른사람 풀이
//    public int solution12(String s) {
//        String[] sArr = s.split(" ");
//        int answer = 0;
//
//         Stack<String> stack = new Stack<String>();
//
//         for(int i=0; i<sArr.length; i++) {
//             if(sArr[i].equals("Z") ){
//                 stack.pop();
//             } else {
//                 stack.push(sArr[i]);
//             }
//         }
//
//         while(!stack.empty()) {
//             answer += Integer.parseInt(stack.pop());
//         }
//         return answer;
//     }
    //문자열 밀기
    public int solution13(String A, String B) {
        int answer = 0;
        
        String ra = A;
        for(int i =0; i<A.length();i++){
            if(ra.equals(B)){
                return answer;
            }
                String tmp = ra.substring(A.length()-1);
                ra = tmp + ra.substring(0,A.length()-1);
                answer ++;
        }
        
        return -1;
    }
    //왜 3번 반복시키는가?
//    public int solution13(String A, String B) {
//        String tempB = B.repeat(3);
//        return tempB.indexOf(A);
//    }
    //로그인 성공?
    public String solution14(String[] id_pw, String[][] db) {
        String answer = "fail";
        String id = id_pw[0];
        String pw = id_pw[1];
        for(int i = 0;i<db.length;i++){
                if(db[i][0].equals(id) && db[i][1].equals(pw)){
                        return "login";
                }else if(db[i][0].equals(id) && !db[i][1].equals(pw)) {
                        return "wrong pw";
                }else{
                    continue;
                }
            
        }
        return answer;
    }
    //해쉬맵 사용한 정답 다른사람 풀이
//    public String solution14(String[] id_pw, String[][] db) {
//        String answer = "";
//        HashMap<String,String> map=new HashMap<>();
//        for(int i=0;i<db.length;i++){
//            map.put(db[i][0],db[i][1]);
//        }
//        String pw=map.get(id_pw[0]);
//        if(pw==null){
//            answer = "fail";
//        }else{
//            if(pw.equals(id_pw[1])){
//                answer = "login";
//            }else{
//                answer = "wrong pw";
//            }
//        }
//        return answer;
//    }
    //치킨쿠폰
    public int solution15(int chicken) {
        int answer = 0;

        while (chicken >= 10) {
            //쿠폰으로 시킨 새 치킨
            int newChick = chicken / 10;
            //쿠폰을 쓰고 남은 쿠폰(치킨)수
            int restChick = chicken % 10;
            chicken = newChick + restChick;

            answer += newChick;
        }

        return answer;
    }
    
}

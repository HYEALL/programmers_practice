package lv_1;



public class 지폐접기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{50, 50}, new int[]{100,241}));
    }
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int bill_max = Math.max(bill[0], bill[1]); // 지폐 최대값 최소값 구하기
        int bill_min = Math.min(bill[0], bill[1]);

        int wallet_max = Math.max(wallet[0], wallet[1]); // 지갑 최대값 최소값 구하기
        int wallet_min = Math.min(wallet[0], wallet[1]);

        while(true) {
            if (bill_min > wallet_min || bill_max > wallet_max) { // 지폐 min, max 값이 지갑보다 커야 계속 접음
                bill_max /= 2;
                if (bill_max < bill_min) { // 지폐 최대, 최소값 갱신
                    int min = bill_max;
                    bill_max = bill_min;
                    bill_min = min;
                }
                ++answer; // 접기 횟수 증가
            } else { // 반복문 끝내기
                return answer;
            }
        }
    }

}


package lv_1;



public class 지폐접기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{50, 50}, new int[]{100,241}));
    }
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int bill_max = Math.max(bill[0], bill[1]);
        int bill_min = Math.min(bill[0], bill[1]);

        int wallet_max = Math.max(wallet[0], wallet[1]);
        int wallet_min = Math.min(wallet[0], wallet[1]);

        while(true) {
            if (bill_min > wallet_min || bill_max > wallet_max) {
                bill_max /= 2;
                if (bill_max < bill_min) {
                    int min = bill_max;
                    bill_max = bill_min;
                    bill_min = min;
                }
                ++answer;
            } else {
                return answer;
            }
        }
    }

}


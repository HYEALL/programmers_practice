package lv_1;

public class 이웃한칸 {
    public static void main(String[] args) {

        System.out.println(solution(new String[][]{{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}}, 1, 1));
    }
    public static int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0; // 같은 색 카운트
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        for(int i=0; i<=3; i++){
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if(h_check>=0 && h_check<n && w_check>=0 && w_check<n){
                if(board[h][w].equals(board[h_check][w_check])){
                    count += 1;
                }
            }
        }

        return count;
    }

}

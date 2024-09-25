package lv_1;

import java.util.HashMap;

public class 가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        // key : 이름, value : friends 배열의 index
        // giftIndex, recode의 index(식별자 역할)를 파악하기 위한 HashMap
        HashMap<String, Integer> map = new HashMap<>(); // 이름, index 쌍으로 map 생성
        for (int i = 0; i < friends.length; i++) { // map 생성하여 map.get으로 접근 가능
            map.put(friends[i], i);
        }

        // 친구마다 선물 준 횟수를 저장하는 2차원 배열
        // (ex : 0번째 친구는 1,2,3,4에게, 1번째 친구는 0,2,3,4에게 준 횟수 카운트)
        int[][] count = new int[friends.length][friends.length]; // map 저장한 것과 같은 순서로 저장

        // 선물 지수 저장 배열
        // map에 저장된 index를 활용하여 선물 지수 저장
        int[] jisoo = new int[friends.length];

        for (int i = 0; i < gifts.length; i++) {
            // 0번째는 선물 한 친구 이름, 1번째는 선물 받은 친구 이름
            String[] gift = gifts[i].split(" ");

            // 선물 지수 증가 (선물 한 친구)
            jisoo[map.get(gift[0])]++;
            // 선물 지수 감소 (선물 받은 친구)
            jisoo[map.get(gift[1])]--;

            // 선물 주고받은 횟수 저장
            count[map.get(gift[0])][map.get(gift[1])]++;
        }

        int answer = 0;

        for(int i=0; i < friends.length; i++){ // 나
            int cnt = 0; // 최대값
            for(int j=0; j< friends.length; j++){ // 친구
                if(i==j) continue; // 나 자신은 continue
                if(count[i][j] > count[j][i]) { // map을 사용해서 위치 정해져있으니 비교 가능
                    // 준 선물 수가 더 많은 경우 선물 획득
                    cnt += 1;
                } else if(count[i][j] == count[j][i] && jisoo[i] > jisoo[j]){
                    // 주고 받은 선물 수가 같거나 없으면 지수 높은 쪽이 선물 획득
                    cnt += 1;
                }
                answer = Math.max(answer, cnt); // 가장 많은 선물을 받을 사람의 선물 수 갱신
            }
        }
        return answer;
    }
}

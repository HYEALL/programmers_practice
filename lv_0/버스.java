package lv_0;

public class 버스 {
    public int solution(int seat, String[][] passengers) {
        int num_passenger = 0;
        for(int i=0; i<passengers.length; i++){
            num_passenger += func4(passengers[i]); // 승차 승객 수 증가
            num_passenger -= func3(passengers[i]); // 하차 승객 수 감소
        }
        int answer = func1(seat-num_passenger); // 남은 자리 구하기 (좌석 수 - 현재 탑승인원)
        return answer;
    }

    public int func1(int num){ // 탑승 인원이 더 많을 경우 남은 자리 0으로 처리
        if(0 > num){
            return 0;
        }
        else{
            return num;
        }
    }
    public int func2(int num){
        if(num > 0){
            return 0;
        }
        else{
            return num;
        }
    }

    public int func3(String[] station){
        int num = 0;
        for(int i=0; i<station.length; i++){
            if(station[i].equals("Off")){
                num += 1;
            }
        }
        return num;
    }

    public int func4(String[] station) {
        int num = 0;
        for (int i = 0; i < station.length; i++) {
            if (station[i].equals("On")) {
                num += 1;
            }
        }
        return num;
    }
}

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingRecords = new TreeMap<>();// 차량이 들어온 순대로 계산해주기 위해 정렬되는 treeparkingRecords 사용

        for (String record : records) {
            String[] token = record.split(" ");
            int time =  (token[2].equals("IN") ? -1 : 1) * parseTime(token[0]);// 입차에 -를 붙여 한번에 연산

            String carNum = token[1];
            parkingRecords.put(carNum, parkingRecords.getOrDefault(carNum, 0) + time);// 차량번호를 key로 총주차시간을 저장
        }

        int[] answer = new int[parkingRecords.size()];
        int idx = 0;

        return parkingRecords.values().stream()
                .mapToInt(totalUsageTime -> calculatePrice(totalUsageTime, fees))
                .toArray();
    }
    private int calculatePrice(int totalUsageTime, int[] fees){
        int lastTime = parseTime("23:59");
        totalUsageTime = totalUsageTime <= 0 ? totalUsageTime + lastTime : totalUsageTime; // 출차를 안한 경우 입차 시간 + 종료시간을 더해서 총주차시간을 계산해줌
        double baseTime = totalUsageTime - fees[0] < 0 ? 0 : totalUsageTime - fees[0];// 기본시간보다 적게 주차했으면 추가 시간을 0으로 갱신
        return fees[1] + (int) Math.ceil(baseTime / fees[2]) * fees[3];// 기본요금 + 추가요금(추가시간/단위시간 * 단위요금)
    }
    private int parseTime(String time) {// "00:00" 형태의 문자열을 분으로 변환
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));
        return hour * 60 + minute;
    }
}
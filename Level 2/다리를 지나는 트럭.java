import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridgeWeight = 0;
        int index = 0;

        List<Truck> bridge = new LinkedList<>();
        bridge.add(new Truck(truck_weights[index], 0));
        bridgeWeight += truck_weights[index++];
        while (bridge.size() != 0) {
            answer++;
            // 다리 위에 있는 트럭들 한칸 전진
            for (Truck truck : bridge) {
                truck.location++;
            }

            // 가장 선두에 있는 트럭이 다리를 건넌 경우
            Truck truck = bridge.get(0);
            if (truck.location > bridge_length) {
                bridgeWeight -= truck.weight;
                bridge.remove(truck);
            }

            // 다리에 새 트럭이 들어옴
            if (index < truck_weights.length && bridgeWeight + truck_weights[index] <= weight) {
                bridge.add(new Truck(truck_weights[index], 1));
                bridgeWeight += truck_weights[index++];
            }
        }

        return answer;
    }

    public static class Truck {
        int weight, location;

        public Truck(int weight, int location) {
            this.weight = weight;
            this.location = location;
        }
    }
}

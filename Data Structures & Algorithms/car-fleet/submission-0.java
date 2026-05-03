

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        Map<Integer,Double> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            double time=(target-position[i])/(double)speed[i];
            map.put(position[i], time);
        }

        Deque<Double> fleet=new ArrayDeque<>();
        Arrays.sort(position);
        for(int i=n-1;i>=0;i--){
            if(fleet.isEmpty()){
                fleet.push(map.get(position[i]));
            }
            if(map.get(position[i])>fleet.peek()){
                fleet.push(map.get(position[i]));
            }
        }
        return fleet.size();
    }
}

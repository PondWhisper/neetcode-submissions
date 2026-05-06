
class TimeMap {
    public Map<String, ArrayList<String[]>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, b -> new ArrayList<>()).add(new String[]{value, String.valueOf(timestamp)});
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }


        List<String[]> list = map.get(key);
        int l = 0, r = list.size() - 1;

        int unless = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int currTime = Integer.parseInt(list.get(mid)[1]);
            if (currTime == timestamp) {
                return list.get(mid)[0];
            } else if (currTime < timestamp) {
                l = mid + 1;
                unless = mid;
            } else {
                r = mid - 1;
            }
        }
        if (Integer.parseInt(list.get(unless)[1]) <= timestamp) {
            return list.get(unless)[0];
        } else {
            return "";
        }
    }
}

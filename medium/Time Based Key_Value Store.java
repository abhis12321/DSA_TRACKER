class TimeMap {
    private Map<String , TreeMap<Integer , String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> T = map.getOrDefault(key , new TreeMap<>());
        T.put(timestamp , value);
        map.put(key , T);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> T = map.get(key);
        if(T == null) {
            return "";
        }
        Integer tmp = T.floorKey(timestamp);
        return tmp == null ? "" : T.get(tmp);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
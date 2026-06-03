class TimeMap {

    class pair
    {
        String value;
        int timestamp;

        public pair(String val,int time)
        {
            value=val;
            timestamp=time;
        }
    }
    HashMap<String, List<pair>> timemap;
    public TimeMap() {
            timemap=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<pair> list=new ArrayList<>();
        if(!timemap.containsKey(key)){
            
            list.add(new pair(value,timestamp));
            timemap.put(key, list);
        }
        else
        {
            timemap.get(key).add(new pair(value,timestamp));
        }
    }
    
    public String get(String key, int time) {
        String ans="";
        if(timemap.containsKey(key))
        {
            List<pair> temp=new ArrayList<>();
            temp= timemap.get(key);
            int low=0,high=temp.size()-1;
            
            while(low<=high)
            {
                int mid=low+(high-low)/2;
                if(temp.get(mid).timestamp==time)
                {
                    ans=temp.get(mid).value;
                    return ans;
                }
                else if(temp.get(mid).timestamp<time)
                {
                    ans=temp.get(mid).value;
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return ans;
        
    }
}

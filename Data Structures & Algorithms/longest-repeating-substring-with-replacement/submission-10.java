class Solution {
    public int characterReplacement(String s, int k) {
        int left=0,right=0;
        int max=0;
        int maxf=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(left<=right && right<s.length())
        {
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            maxf = Math.max(maxf, map.get(s.charAt(right)));

            while ((right - left + 1) - maxf > k) 
            {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;

    }
}

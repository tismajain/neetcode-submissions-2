class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word : strs)
        {
            int[] ch=new int[26];
            for(char c: word.toCharArray())
            {
                ch[c-'a']++;
            }
            String key=Arrays.toString(ch);
            map.computeIfAbsent(key,k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());

    }
}
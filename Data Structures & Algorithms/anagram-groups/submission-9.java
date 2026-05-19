class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        boolean[] used = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (used[i]) continue; // already processed

            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            used[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (used[j]) continue;
                if (isAnagram(strs[i], strs[j])) {
                    temp.add(strs[j]);
                    used[j] = true;
                }
            }
            answer.add(temp);
        }
        return answer;
    }
}
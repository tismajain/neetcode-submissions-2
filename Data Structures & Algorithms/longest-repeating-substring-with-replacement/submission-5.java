class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0,right=0, maxFreq = 0, result = 0;

       while(left<=right && right<s.length())
       {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // If replacements needed > k, shrink window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;

    }
}

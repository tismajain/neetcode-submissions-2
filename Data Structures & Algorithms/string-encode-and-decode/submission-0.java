class Solution {

    public String encode(List<String> strs) {
        StringBuilder s=new StringBuilder();
        int i;
        for(i=0;i<strs.size();i++)
        {
            String temp=strs.get(i);
            char len=(char)temp.length();
            s.append(len);
            s.append("#");
            s.append(temp);

        }
        return s.toString();

    }

    public List<String> decode(String str) {
        List<String> ans= new ArrayList<>();
        int i=0;
        while(i<str.length())
        {
            int len=(int)str.charAt(i);
            i=i+2;
            String s=str.substring(i,i+len);
            ans.add(s);
            i=i+len;
        }
        return ans;
    }
}

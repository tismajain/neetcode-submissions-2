class TrieNode
{
    TrieNode[] children;
    boolean end;
    TrieNode()
    {
        children=new TrieNode[26];
        end=false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
            TrieNode cur=root;
            for(char c: word.toCharArray())
            {
                int i=c-'a';
                if(cur.children[i]==null)
                {
                    cur.children[i]=new TrieNode();
                }
                cur=cur.children[i];

            }
            cur.end=true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, TrieNode cur)
    {
        if(index == word.length())
        {
            return cur.end;
        }

        char c = word.charAt(index);

        if(c == '.')
        {
            for(int i = 0; i < 26; i++)
            {
                if(cur.children[i] != null)
                {
                    if(dfs(word, index + 1, cur.children[i]))
                    {
                        return true;
                    }
                }
            }

            return false;
        }
        else
        {
            if(cur.children[c-'a'] == null)
            {
                return false;
            }

            return dfs(word, index+1, cur.children[c-'a']);
        }

    }
}

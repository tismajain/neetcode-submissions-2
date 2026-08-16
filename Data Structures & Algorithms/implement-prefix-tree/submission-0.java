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
class PrefixTree {

    private TrieNode root;
    public PrefixTree() {
         root=new TrieNode();
    }

    public void insert(String word) {

        TrieNode cur= root;

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
        TrieNode cur=root;
        for(char c: word.toCharArray())
        {
            if(cur.children[c-'a']==null)
            {
                return false;
            }
            cur=cur.children[c-'a'];
        }
        return cur.end;

    }

    public boolean startsWith(String prefix) {
         TrieNode cur=root;
        for(char c: prefix.toCharArray())
        {
            if(cur.children[c-'a']==null)
            {
                return false;
            }
            cur=cur.children[c-'a'];
        }
        return true;
    }
}

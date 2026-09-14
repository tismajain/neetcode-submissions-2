class LRUCache {
    static class dll
    {
     int k;
     int v;
     dll next;
     dll prev;

        dll(int key, int val)
        {
            k=key;
            v=val;
            next=null;
            prev=null;
        }
    }
    int cap;
    int size=0;
    dll head;
    dll tail;
    HashMap<Integer,dll> map=new HashMap<>();
   

    public LRUCache(int capacity) {
        cap=capacity;
        head=new dll(0,0);
        tail=new dll(0,0);
        head.next=tail;
        tail.prev=head;

    }

    void removeonce(dll node)
    {
        dll before=node.prev;
        dll after=node.next;
        before.next=after;
        after.prev=before;

    }

    void add(dll node)
    {
        dll after=head.next;
        head.next=node;
        node.prev=head;
        after.prev=node;
        node.next=after;
    }
    void delete()
    {
        dll del=tail.prev;
        dll last=tail.prev.prev;
        last.next=tail;
        tail.prev=last;
        map.remove(del.k);
    }
    
    public int get(int key) {
        if(size<1)
        {
            return -1;
        }
        if(map.containsKey(key))
        {
            dll node=map.get(key);
            int ans=node.v;
            removeonce(node);
            add(node);
            return ans;

        }
        
        return -1; 

    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key))
        {
            dll node = map.get(key);

            node.v = value;
            removeonce(node);
            add(node);
            return;
        }
        dll node=new dll(key,value);
        add(node);
        map.put(key,node);
        size++;
        if(size>cap)
        {
            delete();
            size--;
        }
        

    }
}

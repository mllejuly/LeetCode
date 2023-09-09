// 不使用任何内建的哈希表库设计一个哈希映射
// 具体地说，你的设计应该包含以下的功能


// remove(key)：
// tag: microsoft

class MyHashMap {
    
    // 存放key value的数组，key就是数组下标，value就是数组的值
    private int[] a = new int[100000];
    // 标记数组，用来指示该key是否被占用。数组值 = 1 表示被占用，0 表示不被占用
    private int[] b = new int[100000];
    
    public void put(int key, int value) {
        // 向哈希映射中插入(键,值)的数值对，如果键对应的值已经存在，更新这个值。
        a[key] = value;
        // 同时记录该 key 被占用
        b[key] = 1;
    }
    
    public int get(int key) {
        // 如果映射中不包含这个键，返回-1
        if(b[key] != 1) {
            return -1;
        }
        // 返回给定的键所对应的值
        else {
            return a[key];
        }
    }
    
    public void remove(int key) {
        // 移除操作，如果映射中存在这个键，删除这个数值对
        // 删除键值对，只需要标记该 key 未被占用
        b[key] = 0;
    }
}

// 字符串处理,Bloomberg,谷歌,亚马逊,微软
// Time complexity : O(N) since we go through the string of length N two times.
// Space complexity : O(N) since we have to keep a hash map with N elements

class Solution {
    public int firstUniqChar(String s) {
        // 创建一个哈希表
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        // 遍历字符串, 储存每个字母出现的次数，字母为key，出现的次数为value
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // 找到第一个出现次数为 1 的字母，返回其位置即可
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}


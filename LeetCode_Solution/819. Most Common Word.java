// Amazon, Hashmap
// 利用哈希表记录每个单词出现的次数即可


class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        // 讲禁止词列表转成HashSet
        Set<String> ban = new HashSet<> (Arrays.asList(banned));
        // HashMap储存每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        
        // 对原始字符串进行处理，最后讲字符串转化成以单词为单位的列表
        // .replaceAll("\\pP","") - 完全清除字符串paragraph中的标点
        // .toLowerCase() - 全部转成小写
        // .spilt("\\s+") - matches sequence of one or more whitespace characters.
        String[] words = paragraph.replaceAll("\\pP", " ").toLowerCase().split("\\s+");
        
        // 如果当前单词没有在禁止词列表中出现过
        // 则将单词作为Key记入哈希表，每出现一次计数 +1
        for (String w : words) {
            if (!ban.contains(w)) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }
        
        
        // 返回出现次数最多的单词
        // final Comparator<Map.Entry<String, Long>> keyComparator = Map.Entry.comparingByKey();
        String result = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        
        return result;
        
    }
}




class LadderLength {
    /**
     * 题号名称：127. 单词接龙
     * 题目链接：https://leetcode-cn.com/problems/word-ladder/
     * 算法思路：BFS
     * 时间复杂度：O(N*C*C)
     * 空间复杂度：O(N*C*C)
     */
    Map<String, Integer> map = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<>();
    int nodeNum = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (wordList.indexOf(endWord) < 0) {
            return 0;
        }
        for (String word: wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        int[] dist = new int[nodeNum];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int idx1 = map.get(beginWord);
        int idx2 = map.get(endWord);
        dist[idx1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx1);
        while (!queue.isEmpty()) {
            int front = queue.poll();
            if (front == idx2) {
                return dist[idx2] / 2 + 1;
            }
            for (Integer i: edge.get(front)) {
                if (dist[i] == Integer.MAX_VALUE) {
                    dist[i] = dist[front] + 1;
                    queue.offer(i);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char tmp = arr[i];
            arr[i] = '*';
            String newWord = String.valueOf(arr);
            addWord(newWord);
            int idx1 = map.get(word);
            int idx2 = map.get(newWord);
            edge.get(idx1).add(idx2);
            edge.get(idx2).add(idx1);
            arr[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!map.containsKey(word)) {
            map.put(word, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }
}

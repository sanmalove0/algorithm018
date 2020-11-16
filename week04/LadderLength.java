import java.util.*;

public class LadderLength {
    /**
     * 题号名称：127. 单词接龙
     * 题目链接：https://leetcode-cn.com/problems/word-ladder/
     * 算法思路：广度优先遍历求最短路
     * 1). 给beginWord和wordList中每个word添加序号，每个序号作为图中的一个节点；
     * 2). 对于每个word，依次将它的每个字母用'*'代替后，生成新word，也添加序号，作为图中的虚拟节点；
     * 3). 构造图：每个节点都一个list，用来存放能通过替换一个字母变成和它相同的word的序号，从而在这两个节点间建立起一条边；
     * 4). dist[]数组表示当前节点到beginWord节点需要替换中间字母的最小次数；
     * 5). 利用队列，从beginWord节点对图进行广度优先遍历，每次先弹出队首元素，如果队首元素所代表的word恰好是endWord，返回dist距离；
     * 6). 否则，将和队列首元素有建立起边的所有word序号依次加入队列中，这些序号到beginWord的距离dist加一；再进入下一个循环；
     * 7). 需要注意的是，因为虚拟节点的存在，所以最后endWord到beginWord的距离dist需要除以二再加一。
     * 时间复杂度：O(N*K^2)
     * 空间复杂度：O(N*K^2)
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


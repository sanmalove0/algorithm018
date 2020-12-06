学习笔记

### 第十三课 字典树和并查集

#### Trie树的基本实现和特性

字典树（Trie树），又称单词查找树或键树，是一种树形结构。

典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。

它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

基本性质
1. 节点本身不存完整单词；
2. 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串；
3. 每个节点的所有子节点路径表示的字符都不相同。

节点可以存储额外信息（比如频次）

核心思想：空间换时间。
利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

Trie树模板

    class Trie(object):
        
        def __init__(self):
            self.root = {}
            self.end_of_word = “#"

        def insert(self, word):
            node = self.root
            for char in word:
                node = node.setdefault(char, {})
            node[self.end_of_word] = self.end_of_word

        def search(self, word):
            node = self.root
            for char in word:
                if char not in word:
                    return False
                node = node[char]
            return self.end_of_word in node

        def startsWith(self, prefix):
            node = self.root
            for char in prefix:
                if char not in node:
                    return False
                node = node[char]
            return True

并查集（）

适用场景：组团、配对问题

基本操作
1. makeSet(s): 建立一个新的并查集，其中包括s个单元素集合；
2. unionSet(s): 把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并；
3. find(x): 找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。

并查集java模板

    class UnionFind{
        private int count = 0;
        private int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int p){
            while(p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
    }

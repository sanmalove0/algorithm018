学习笔记

### 第十九课 高级动态规划

#### 递归 - 函数自己调用自己

    public void recur(int level, int param) {
    
        // terminator
        if (level > MAX_LEVEL) {
            // process result
            return;
        }

        // process current logic
        process(level, param);

        // drill down
        recur(level: level + 1, newParam);

        // restore current status
    }

#### 分治代码模板 (归并排序为例）

    def divide_conquer(problem, param1, param2, …):
        # recursion terminator
        if problem is None:
            print_result
            return
        
        # prepare_data
        data = prepare_data(problem)
        subproblems = split_problem(problem, data)

        # conquer subproblems
        subresult1 = self.divide_conquer(subproblems[0], p1, …)
        subresult2 = self.divide_conquer(subproblems[1], p1, …)
        subresult3 = self.divide_conquer(subproblems[2], p1, …)
        …

        # process and generate the final result
        result = process_result(subresult1, subresult2, subresult3, …)

        # revert the current level status

#### 感触：
1. 人肉递归低效、很累
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳法思维（同理可得）

本质：寻找重复性 —》 计算机指令集

#### 动态规划Dynamic Programming
1. “Simplifying a complicated problem by breaking it down into simpler sub-problems” (in a recursive manner)
2. Divide & Conquer + Optimal substructure (分治 + 最优子结构）
3. 顺推形式：动态递推 （循环）

#### DP顺推模板

    function DP():
        dp = [][] # 二维情况
        for i = 0..M {
            for j = 0..N {
                dp[i][j] = _Function(dp[i`][j`]…)
            }
        }
        Return dp[M][N];

#### 股票买卖 (一系列6道题）

dp[i][k][0 or 1] (0 <= i <= n-1, 1 <= k <= K)
* i 为天数
* k为最多交易次数
* [0,1]为是否持有股票

总状态：n*K*2种状态

    for 0 <= i < n:
        for 1 <= k <= K
            for s in {0, 1}:
                dp[i][k][s] = max(buy, sell, rest) 

动态转移方程：

    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
                  max(  选择rest    ,   选择sell               )

解释：今天我没有持有股票，有两种可能：
* 我昨天就没有持有，然后今天选择rest，所以我今天还是没有持有；
* 我昨天持有，但是今天我sell了，所以我今天没有持有股票了。

    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
                  max(  选择rest    ,   选择buy                  )

解释：今天我持有着股票，有两种可能：
* 我昨天就持有着股票，然后今天选择了rest，所以我今天还持有着股票；
* 我昨天本没有持有，但今天我选择buy，所以今天我就持有股票了。

初始状态：

    dp[-1][k][0] = dp[i][0][0] = 0
    dp[-1][k][1] = dp[i][0][1] = -infinity

#### 编辑距离 （题解里有个表格很好）

* 如果word1[i]与word2[j]相同，显然dp[i][j]=dp[i-1][j-1]
* 如果word1[i]与word2[j]不同，那么dp[i][j]可以通过
    1. 在dp[i-1][j-1]的基础上做replace操作达到目的
    2. 在dp[i-1][j]的基础上做insert操作达到目的
    3. 在dp[i][j-1]的基础上做delete操作达到目的
    
    取三者最小情况即可

### 第二十课 字符串

在Java中String是immutable不可变的，线程安全。

### 最长子串、子序列
1. Longest common sequence （最长子序列）

    https://leetcode-cn.com/problems/longest-common-subsequence/

    dp[i][j] = dp[i-1][j-1] + 1 (if s1[i-1] == s2[j-1])

    else dp[i][j] = max(dp[i-1][j], dp[i][j-1])

2. Longest common substring （最长子串）

    dp[i][j] = dp[i-1][j-1] + 1 (if s1[i-1] == s2[j-1])
    
    else dp[i][j] = 0

3. Edit distance （编辑距离）

    https://leetcode-cn.com/problems/edit-distance/

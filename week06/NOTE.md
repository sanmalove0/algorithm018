学习笔记

### 第十二课 动态规划

分治 - 回溯 - 递归 - 动态规划


递归代码模板

    public void recur(int level, int param){

        // terminator
        if (level > MAX_LEVEL) {
            // process result
            return;
        }

        // process current logic;
        process(level, param);

        // drill down
        recur(level: level + 1, newParam);

        // restore current status
    }

分治代码模板

    def divide_conquer(problem, param1, param2, …):
    
    # recursion terminator
    if problem is None:
        print_result
        return

    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)

    # conquer subproblems
    subresult1 = sef.divide_conquer(subproblems[0], p1, …)
    subresult2 = sef.divide_conquer(subproblems[1], p1, …)
    subresult3 = sef.divide_conquer(subproblems[2], p1, …)
    …

    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3,…)

    # revert the current level states

感触：
1. 人肉递归低效、很累
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳法思维（抵制人肉递归的诱惑）

本质：寻找重复性 —》 计算机指令集

动态规划 = 分治 + 最优子结构

关键点：
1. 动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构）
2. 共性：找到重复子问题
3. 差异性：最优子结构、中途可以淘汰次优解

动态规划关键点：
1. 最优子结构 opt[n] = best_of(opt[n-1], opt[n-2], …)
2. 储存中间状态：opt[i]
3. 递推公式（美其名曰：状态转移方程或者DP方程）
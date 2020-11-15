学习笔记

* 递归（Recursion）

    Java代码模板

        public void recur(int level, int param) {
            
            // terminator
            if (level > MAX_LEVEL) {
                // process result
                return;
            }

            // process current logic
            process(level, param);

            // drill down
            recur(level: level+1, newParam);

            // restore current status
        }

    思维要点：
    1. 不要人肉进行递归（最大误区）；
    2. 找到最近最简方法，将其拆解成可重复解决的问题（最近重复子问题）；
    3. 数学归纳法思维

    （二叉搜索树）BST —> 中序遍历是递增的
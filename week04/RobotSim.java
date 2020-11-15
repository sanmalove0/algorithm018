import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class RobotSim {
    /**
     * 题号名称：874. 模拟行走机器人
     * 题目链接：https://leetcode-cn.com/problems/walking-robot-simulation/
     * 算法思路：数组保存向4个方向移动一步的坐标变换；移动方向做取模运算；用哈希表查找是否会遇到障碍物，如果不用哈希表而是遍历的话会超时
     * 时间复杂度：O(M+N)
     * 空间复杂度：O(N)
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] move = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int faceTo = 0;
        int[] curPos = new int[]{0, 0};
        int result = 0;
        Set<Pair<Integer, Integer>> obstacleSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstacleSet.add(new Pair<>(obstacles[i][0], obstacles[i][1]));
        }
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                faceTo = (faceTo + 1) % 4;
            } else if (commands[i] == -2) {
                faceTo = (faceTo + 3) % 4;
            } else {
                for (int j = 0; j < commands[i]; j++) {
                    if (obstacleSet.contains(new Pair<>(curPos[0] + move[faceTo][0], curPos[1] + move[faceTo][1]))) {
                        break;
                    }
                    curPos[0] = curPos[0] + move[faceTo][0];
                    curPos[1] = curPos[1] + move[faceTo][1];
                }
            }
            result = Math.max(result, curPos[0] * curPos[0] + curPos[1] * curPos[1]);
        }
        return result;
    }
}


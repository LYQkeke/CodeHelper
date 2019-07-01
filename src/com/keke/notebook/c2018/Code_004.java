package com.keke.notebook.c2018;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/7/1
 * 拼多多
 * 迷宫寻路
 * 假设一个探险家被困在了地底的迷宫之中，要从当前位置开始找到一条通往迷宫出口的路径。
 * 迷宫可以用一个二维矩阵组成，有的部分是墙，有的部分是路。
 * 迷宫之中有的路上还有门，每扇门都在迷宫的某个地方有与之匹配的钥匙，只有先拿到钥匙才能打开门。
 * 请设计一个算法，帮助探险家找到脱困的最短路径。
 * 如前所述，迷宫是通过一个二维矩阵表示的，
 * 每个元素的值的含义如下 0-墙，1-路，2-探险家的起始位置，
 * 3-迷宫的出口，大写字母-门，小写字母-对应大写字母所代表的门的钥匙
 */
public class Code_004 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        char[][] maze = new char[m][n];
        for (int i=0;i<m;i++){
            maze[i] = in.next().toCharArray();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j]=='2'){
                    // 使用广度优先搜索，只要搜索到答案，一定是最小的步数
                    System.out.println(bfs(i,j,maze));
                    break;
                }

            }
        }
    }

    private static int bfs(int bx, int by, char[][] maze){
        // 用map来存储搜索到到该节点时持有的钥匙的状态
        boolean[][][] map = new boolean[100][100][1025];
        // next来存储移动的四个不同方向
        int[][] next = {{-1,0},{0,1},{1,0},{0,-1}};
        int m = maze.length;
        int n = maze[0].length;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(bx,by,0,0));
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            // 向上下左右四个方向分别进行移动
            for (int i=0;i<4;i++){
                int x = temp.x + next[i][0];
                int y = temp.y + next[i][1];
                int key = temp.key;
                if (x<0||y<0||x>=m||y>=n||maze[x][y]=='0'){// 撞上墙壁或者超过边界
                    continue;
                }else if (maze[x][y]>='a'&&maze[x][y]<='z'){//碰到钥匙
                    key = key|(1<<(maze[x][y]-'a'));
                }else if (maze[x][y]>='A'&&maze[x][y]<='Z'&&(key&(1<<(maze[x][y]-'A')))==0){//如果没拿到钥匙那么就不能继续前进
                    continue;
                }else if (maze[x][y]=='3'){
                    return temp.step + 1;
                }
                if (!map[x][y][key]){
                    queue.offer(new Node(x,y,temp.step+1,key));
                    map[x][y][key] = true;
                }
            }
        }
        return -1;
    }

    private static class Node{
        int x;
        int y;
        int step;
        int key;

        public Node(int x, int y, int step, int key) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.key = key;
        }
    }
}

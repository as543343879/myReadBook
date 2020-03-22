package com.datastructure.map;

import lombok.Data;

import java.util.Arrays;

/**
 * ShortestPath_FLOYD class
 */
@Data
public class ShortestPath_FLOYD {
    private int[][] P; // 路径下标
    private int[][] D; // 带权长度

    public final static int MAX = Integer.MAX_VALUE / 2;



    public  void FLOYD(int map[][]) {
        int num = map.length;
        P = new int[num][num];
        D = new int[num][num];
        for(int v = 0; v < num; v ++) {
            for(int w = 0; w < num; w ++) {
                D[v][w] = map[v][w];
                P[v][w] = w;
            }
        }
        for(int k = 0; k < num; k ++) {
            for(int v = 0; v < num; v ++) {
                for(int w = 0; w < num; w ++) {
                    if(D[v][w] > D[v][k] + D[k][w]) {
                        D[v][w] = D[v][k] + D[k][w];
                        P[v][w] = P[v][k];
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        // 模式测试数据
        int[][] data = new int[16][3];
        data[0][0] = 0; data[0][1] = 1; data[0][2] = 1;
        data[1][0] = 0; data[1][1] = 2; data[1][2] = 5;
        data[2][0] = 1; data[2][1] = 2; data[2][2] = 3;
        data[3][0] = 1; data[3][1] = 4; data[3][2] = 5;
        data[4][0] = 1; data[4][1] = 3; data[4][2] = 7;
        data[5][0] = 2; data[5][1] = 5; data[5][2] = 7;
        data[12][0] = 2; data[12][1] = 4; data[12][2] = 1;
        data[6][0] = 3; data[6][1] = 4; data[6][2] = 2;
        data[7][0] = 4; data[7][1] = 5; data[7][2] = 3;
        data[8][0] = 3; data[8][1] = 6; data[8][2] = 3;
        data[9][0] = 4; data[9][1] = 6; data[9][2] = 6;
        data[10][0] = 4; data[10][1] = 7; data[10][2] = 9;
        data[13][0] = 5; data[13][1] = 7; data[13][2] = 5;
        data[11][0] = 6; data[11][1] = 7; data[11][2] = 2;
        data[14][0] = 6; data[14][1] = 8; data[14][2] = 7;
        data[15][0] = 7; data[15][1] = 8; data[15][2] = 4;

        // 初始化邻接矩阵
        int[][] map = new int[9][9];
        int num = map.length;
        for(int i = 0; i < num  ; i ++) {
            for (int j = 0; j <num ; j ++) {
                if(i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = MAX;
                }
            }
        }

        for(int i = 0; i < 16; i ++) {
            map[data[i][0]][data[i][1]] = data[i][2];
            map[data[i][1]][data[i][0]] = data[i][2];

        }
        System.out.println("邻接矩阵：");
        for(int i = 0; i < num; i ++ ) {
            System.out.println(Arrays.toString(map[i]));
        }


        ShortestPath_FLOYD shortestPath_floyd = new ShortestPath_FLOYD();
        shortestPath_floyd.FLOYD(map);

        System.out.println(" 最短路径权值数组：");
        for(int i = 0; i < num; i ++) {
            System.out.println(Arrays.toString(shortestPath_floyd.getD()[i] ));
        }
        System.out.println(" 前驱节点数组：" );
        for(int i = 0; i < num; i ++) {
            System.out.println(Arrays.toString(shortestPath_floyd.getP()[i] ));
        }

    }
}

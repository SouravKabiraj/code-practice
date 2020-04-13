package com.codeforce;

public class Main {

    public static void main(String[] args) {
        int[][] shorts = new int[4][2];
        int[][] players = new int[4][2];
        shorts[0][0] = 1;
        shorts[0][1] = 2;
        shorts[1][0] = 2;
        shorts[1][1] = 3;
        shorts[2][0] = 4;
        shorts[2][1] = 5;
        shorts[3][0] = 6;
        shorts[3][1] = 7;

        players[0][0] = 1;
        players[0][1] = 5;
        players[1][0] = 2;
        players[1][1] = 3;
        players[2][0] = 4;
        players[2][1] = 7;
        players[3][0] = 5;
        players[3][1] = 7;
        log(solve(shorts, players));
    }

    static int solve(int[][] shots, int[][] players) {
        int totalS = 0;
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < shots.length; j++) {
                if (isOverlapped(players[i], shots[j])) {
                    totalS++;
                }
            }
        }
        return totalS;
    }

    private static boolean isOverlapped(int[] player, int[] shot) {
        if (player[1] < shot[0]) {
            return false;
        } else if (shot[1] < player[0]) {
            return false;
        } else {
            return true;
        }
    }

    static void log(String text) {
        System.out.println(text);
    }

    static void log(int text) {
        System.out.println(text);
    }
}

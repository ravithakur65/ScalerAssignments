package com.learn.scaler.advance.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 *  Shortest Distance in a Maze
    Problem Description
    Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.

    1 represents a wall in a matrix and 0 represents an empty location in a wall.

    There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.

    Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.

    Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.



    Problem Constraints
    2 <= N, M <= 100

    0 <= A[i] <= 1

    0 <= B[i][0], C[i][0] < N

    0 <= B[i][1], C[i][1] < M



    Input Format
    The first argument given is the integer matrix A.

    The second argument given is an array of integer B.

    The third argument if an array of integer C.



    Output Format
    Return a single integer, the minimum distance required to reach destination



    Example Input
    Input 1:

    A = [ [0, 0], [0, 0] ]
    B = [0, 0]
    C = [0, 1]
    Input 2:

    A = [ [0, 0], [0, 1] ]
    B = [0, 0]
    C = [0, 1]


    Example Output
    Output 1:

    1
    Output 2:

    1


    Example Explanation
    Explanation 1:

    Go directly from start to destination in distance 1.
    Explanation 2:

    Go directly from start to destination in distance 1.
 */
public class ShortestDistanceInAMaze {

    ArrayList<Pair> neighbor = new ArrayList<Pair>();

    public int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        PriorityQueue<Trio> q = new PriorityQueue<Trio>(new CustomComp());
        neighbor.add(new Pair(0, -1));
        neighbor.add(new Pair(-1, 0));
        neighbor.add(new Pair(0, 1));
        neighbor.add(new Pair(1, 0));

        ArrayList<ArrayList<Integer>> d = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            d.add(new ArrayList<Integer>());
            for (int j = 0; j < A.get(i).size(); j++) {
                d.get(i).add(-1);
            }
        }

        q.add(new Trio(0, B.get(0), B.get(1)));

        while (!q.isEmpty()) {
            Trio t = q.poll();
            if (d.get(t.r).get(t.c) != -1) {
                continue;
            }
            d.get(t.r).set(t.c, t.dis);
            for (int i = 0; i < 4; i++) {
                Trio trio = findNext(t.dis, t.r, neighbor.get(i).r, t.c, neighbor.get(i).c, A);
                if (d.get(trio.r).get(trio.c) == -1) {
                    q.add(trio);
                }
            }
        }
        return d.get(C.get(0)).get(C.get(1));

    }

    public Trio findNext(int dis, int r, int newr, int c, int newc, ArrayList<ArrayList<Integer>> A) {
        int i = r, j = c;
        int newdis = dis;
        if (newr == 0) {
            for (j = c + newc; j >= 0 && j < A.get(r).size() && A.get(r).get(j) != 1; j += newc) {
                newdis++;
            }
            return new Trio(newdis, i, j - newc);
        } else {
            for (i = r + newr; i >= 0 && i < A.size() && A.get(i).get(c) != 1; i += newr) {
                newdis++;

            }
            return new Trio(newdis, i - newr, j);
        }
    }

}

class Trio {
    int dis;
    int r;
    int c;

    Trio(int dis, int r, int c) {
        this.dis = dis;
        this.r = r;
        this.c = c;
    }
}

class Pair {
    int r;
    int c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class CustomComp implements Comparator<Trio> {
    public int compare(Trio t1, Trio t2) {
        return t1.dis - t2.dis;
    }
}

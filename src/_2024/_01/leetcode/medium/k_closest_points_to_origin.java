package _2024._01.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class k_closest_points_to_origin {
    public static void main(String[] args) {
        k_closest_points_to_origin p = new k_closest_points_to_origin();
        int[][] points = new int[2][2];
        points[0] = new int[]{1, 3};
        points[1] = new int[]{-2, 2};
        p.kClosest(points, 1);
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.val));

        for (int i = 0; i < points.length; i++) {

            int x = points[i][0];
            int y = points[i][1];
            double val = Math.sqrt(x * x + y * y);

            pq.add(new Node(i, val));
        }

        for (int i = 0; i < k; i++) {
            Node node = pq.poll();

            result[i][0] = points[node.idx][0];
            result[i][1] = points[node.idx][1];
        }
        return result;
    }

    static class Node {
        int idx;
        double val;

        Node(int idx, double val) {
            this.idx = idx;
            this.val = val;
        }
    }
}

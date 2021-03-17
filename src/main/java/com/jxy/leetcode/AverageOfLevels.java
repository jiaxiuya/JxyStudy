package com.jxy.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        depthFirstSearch(root, 0, sums, counts);
        for (int i = 0; i < sums.size(); i++) {
            result.add(sums.get(i) / counts.get(i));
        }
        return result;
    }

    /**
     * 深度优先
     *
     * @param root
     * @return
     */
    private void depthFirstSearch(TreeNode root, int index, List<Double> sums, List<Integer> counts) {
        if (root == null) {
            return;
        }
        if (index < sums.size()) {
            sums.set(index, sums.get(index) + root.val);
            counts.set(index, counts.get(index) + 1);
        } else {
            sums.add((double)root.val);
            counts.add(1);
        }
        depthFirstSearch(root.left, index + 1, sums, counts);
        depthFirstSearch(root.right, index + 1, sums, counts);
    }

    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            double average = sum / size;
            result.add(average);
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}
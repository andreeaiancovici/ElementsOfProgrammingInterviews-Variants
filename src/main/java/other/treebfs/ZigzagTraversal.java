package other.treebfs;

import other.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*Given a binary tree, populate an array to represent its zigzag level order traversal.
You should populate the values of all nodes of the first level from left to right,
then right to left for the next level and keep alternating in the same manner for the following levels.*/
//Time: O(n)
//Space: O(n)
public class ZigzagTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode c2 = new TreeNode(2);
        TreeNode c3 = new TreeNode(3);
        TreeNode c4 = new TreeNode(4);
        TreeNode c5 = new TreeNode(5);
        TreeNode c6 = new TreeNode(6);
        TreeNode c7 = new TreeNode(7);
        TreeNode c8 = new TreeNode(8);
        TreeNode c9 = new TreeNode(9);

        c4.left = c8;
        c4.right = c9;

        c2.left = c4;
        c2.right = c5;

        c3.left = c6;
        c3.right = c7;

        tree.left = c2;
        tree.right = c3;

        boolean isZigZag = false;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        int level = 1;
        int levelCount = 1;
        int count;
        while(!queue.isEmpty()) {
            System.out.println("Level " + level);
            count = 0;
            while(count < levelCount) {
                TreeNode node;
                if(isZigZag) {
                    node = queue.pollLast();
                } else {
                    node = queue.pollFirst();
                }
                if(node != null) {
                    System.out.print(node.value);
                    if (count == levelCount - 1) {
                        System.out.println();
                    } else System.out.print(" ");
                    if (isZigZag) {
                        if (node.right != null) {
                            queue.addFirst(node.right);
                        }
                        if (node.left != null) {
                            queue.addFirst(node.left);
                        }
                    } else {
                        if (node.left != null) {
                            queue.addLast(node.left);
                        }
                        if (node.right != null) {
                            queue.addLast(node.right);
                        }
                    }
                }
                count++;
            }
            level++;
            levelCount *= 2;
            isZigZag = !isZigZag;
        }
    }
}

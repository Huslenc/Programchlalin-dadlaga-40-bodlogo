import java.io.*;
import java.util.*;

class Result {

    static class Node {
        int index;
        Node left;
        Node right;

        Node(int index) {
            this.index = index;
        }
    }

    static Node buildTree(List<List<Integer>> indexes) {
        Node root = new Node(1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        for (List<Integer> pair : indexes) {
            Node current = queue.poll();
            int leftIndex = pair.get(0);
            int rightIndex = pair.get(1);

            if (leftIndex != -1) {
                current.left = new Node(leftIndex);
                queue.add(current.left);
            }

            if (rightIndex != -1) {
                current.right = new Node(rightIndex);
                queue.add(current.right);
            }
        }

        return root;
    }

    static void swapAtDepth(Node node, int depth, int k) {
        if (node == null) return;

        if (depth % k == 0) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        swapAtDepth(node.left, depth + 1, k);
        swapAtDepth(node.right, depth + 1, k);
    }

    static void inOrderTraversal(Node node, List<Integer> result) {
        if (node == null) return;
        inOrderTraversal(node.left, result);
        result.add(node.index);
        inOrderTraversal(node.right, result);
    }

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        Node root = buildTree(indexes);
        List<List<Integer>> results = new ArrayList<>();

        for (int k : queries) {
            swapAtDepth(root, 1, k);
            List<Integer> traversal = new ArrayList<>();
            inOrderTraversal(root, traversal);
            results.add(traversal);
        }

        return results;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<List<Integer>> indexes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split(" ");
            List<Integer> row = Arrays.asList(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            indexes.add(row);
        }

        int t = Integer.parseInt(scanner.nextLine().trim());
        List<Integer> queries = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            queries.add(Integer.parseInt(scanner.nextLine().trim()));
        }

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        for (List<Integer> row : result) {
            for (int i = 0; i < row.size(); i++) {
                System.out.print(row.get(i));
                if (i < row.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

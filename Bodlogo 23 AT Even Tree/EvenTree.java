import java.util.*;

public class EvenTree {

    static List<List<Integer>> tree = new ArrayList<>();
    static int removableEdges = 0;

    public static int dfs(int node, int parent) {
        int subtreeSize = 1; 

        for (int child : tree.get(node)) {
            if (child != parent) {
                int childSize = dfs(child, node);
                if (childSize % 2 == 0) {
                    removableEdges++; 
                } else {
                    subtreeSize += childSize;
                }
            }
        }

        return subtreeSize;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        int m = scanner.nextInt(); 

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(1, -1); 
        System.out.println(removableEdges);
    }
}
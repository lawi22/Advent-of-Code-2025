
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day8 {

    public static class Position {

        long x;
        long y;
        long z;

        public Position(long pX, long pY, long pZ) {
            x = pX;
            y = pY;
            z = pZ;
        }

    }

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("8/input.txt"));
        List<Position> positions = populateList(lines);

        execute(positions);
    }

    public static void execute(List<Position> positions) {

    }

    public static List<Position> populateList(List<String> lines) {
        List<Position> res = new ArrayList<>();
        for (String s : lines) {
            String[] list = s.split(",");
            long x = Long.parseLong(list[0]);
            long y = Long.parseLong(list[1]);
            long z = Long.parseLong(list[2]);
            Position pos = new Position(x, y, z);
            res.add(pos);
        }
        return res;
    }

    public List<Position> populateTree(List<String> lines) {
        List<Position> res = new ArrayList<>();
        KDTree tree = new KDTree();

        // populate tree
        for (String s : lines) {
            String[] list = s.split(",");
            int x = Integer.parseInt(list[0]);
            int y = Integer.parseInt(list[1]);
            int z = Integer.parseInt(list[2]);

            int[] pos = new int[3];
            pos[0] = x;
            pos[1] = y;
            pos[2] = z;

            tree.insert(pos);
        }

        return res;
    }

    class KDTree {
        // Dimension of the space

        private static final int K = 3;

        static class Node {

            int[] point; // Array to store k dimensional point
            Node left, right; // Left and right child

            public Node(int[] arr) {
                // Copy the point array
                this.point = Arrays.copyOf(arr, K);
                // Initialize children
                this.left = this.right = null;
            }
        }

        Node root; // Root of the K-D Tree

        KDTree() {
            root = null; // Initialize the root
        }

        // Recursive method to insert a new point in the subtree
        // rooted with the given node
        Node insertRec(Node root, int[] point, int depth) {
            // Base case: If the tree is empty, return a new
            // node
            if (root == null) {
                return new Node(point);
            }

            // Calculate current dimension (cd) of comparison
            int cd = depth % K;

            // Compare the new point with the root on current
            // dimension and decide the left or right subtree
            if (point[cd] < root.point[cd]) {
                root.left
                        = insertRec(root.left, point, depth + 1);
            } else {
                root.right
                        = insertRec(root.right, point, depth + 1);
            }

            return root;
        }

        // Method to insert a new point in the K-D Tree
        void insert(int[] point) {
            root = insertRec(root, point, 0);
        }

        // Recursive method to search a point in the subtree
        // rooted with the given node
        boolean searchRec(Node root, int[] point, int depth) {
            // Base case: The tree is empty or the point is
            // present at root
            if (root == null) {
                return false;
            }
            if (Arrays.equals(root.point, point)) {
                return true;
            }

            // Calculate current dimension (cd)
            int cd = depth % K;

            // Compare the point with the root on current
            // dimension and decide the left or right subtree
            if (point[cd] < root.point[cd]) {
                return searchRec(root.left, point, depth + 1);
            } else {
                return searchRec(root.right, point, depth + 1);
            }
        }

        // Method to search a point in the K-D Tree
        boolean search(int[] point) {
            return searchRec(root, point, 0);
        }

        // Recursive method for range search in the subtree
        // rooted with the given node
        void rangeSearchRec(Node root, int[] lower, int[] upper,
                int depth) {
            if (root == null) {
                return;
            }

            // Check if the point of root is in range
            boolean inside = true;
            for (int i = 0; i < K; i++) {
                if (root.point[i] < lower[i]
                        || root.point[i] > upper[i]) {
                    inside = false;
                    break;
                }
            }

            // If the point is in range, print it
            if (inside) {
                System.out.println(Arrays.toString(root.point));
            }

            // Calculate current dimension (cd)
            int cd = depth % K;

            // Check subtrees if they can have points within the
            // range
            if (lower[cd] <= root.point[cd]) {
                rangeSearchRec(root.left, lower, upper,
                        depth + 1);
            }
            if (upper[cd] >= root.point[cd]) {
                rangeSearchRec(root.right, lower, upper,
                        depth + 1);
            }
        }

        // Method for range search
        void rangeSearch(int[] lower, int[] upper) {
            rangeSearchRec(root, lower, upper, 0);
        }

    }
}

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class TreeTopView {

    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static class HDNode {
        Node node;
        int hd;

        public HDNode(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    private static void printTopView(Node root) {

        if (root == null)
            return;

        Map<Integer, Integer> topViewMap = new HashMap<>();

        Queue<HDNode> queue = new LinkedList<>();
        queue.offer(new HDNode(root, 0));

        while (!queue.isEmpty()) {
            HDNode currNode = queue.poll();
            int hd = currNode.hd;
            Node node = currNode.node;

            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.data);
            }

            if (node.left != null) {
                queue.offer(new HDNode(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new HDNode(node.right, hd + 1));
            }
        }

        for (int val : topViewMap.values()) {
            System.out.print(val + " ");
        }
    }

    private static Node createTree(Scanner sc) {
        System.out.println("Enter the data (-1 to exit): ");
        int data = sc.nextInt();

        if (data == -1)
            return null;

        Node newNode = new Node(data);

        System.out.println("Enter the left of " + data + " : ");
        newNode.left = createTree(sc);

        System.out.println("Enter the right of " + data + " : ");
        newNode.right = createTree(sc);

        return newNode;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = createTree(sc);
        printTopView(root);
    }
}

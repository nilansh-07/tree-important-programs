import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Tree {
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

    private static Node createTree(Scanner sc) {
        System.out.print("Enter data or -1 to exit: ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node newNode = new Node(data);
        System.out.println("Enter the left of " + data + " : ");
        newNode.left = createTree(sc);

        System.out.println("Enter the right of " + data + " : ");
        newNode.right = createTree(sc);

        return newNode;
    }

    private static int treeSize(Node root) {
        if (root == null)
            return 0;

        return treeSize(root.left) + treeSize(root.right) + 1;
    }

    private static int minTree(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;

        return Math.min(root.data, Math.min(minTree(root.left), minTree(root.right)));
    }

    private static int maxTree(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;

        return Math.max(root.data, Math.max(maxTree(root.left), maxTree(root.right)));
    }

    private static void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private static void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    private static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static int treeHeight(Node root) {
        if (root == null)
            return 0;

        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    private static void treeBFS(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node currNode = queue.poll();
            System.out.print(currNode.data + " ");

            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
        }
    }

    private static void treeDFS(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node currNode = stack.pop();

            System.out.print(currNode.data + " ");

            if (currNode.left != null)
                stack.push(currNode.left);
            if (currNode.right != null)
                stack.push(currNode.right);
        }
    }

    private static void leftView(Node root, int level, ArrayList<Node> list) {
        if (root == null)
            return;

        if (list.size() == level) {
            System.out.print(root.data + " ");
        }

        leftView(root.left, level + 1, list);
        leftView(root.right, level + 1, list);
    }

    private static void rightView(Node root, int level, ArrayList<Node> list) {
        if (root == null)
            return;

        if (list.size() == level) {
            System.out.print(root.data + " ");
        }

        rightView(root.right, level + 1, list);
        rightView(root.left, level + 1, list);
    }

    private static void topView(Node root) {
        if (root == null) {
            return;
        }

        Map<Integer, Integer> topViewMap = new HashMap<>();
        Queue<HDNode> queue = new LinkedList<>();
        queue.add(new HDNode(root, 0));

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = createTree(sc);
        ArrayList<Node> list = new ArrayList<>();

        boolean flag = true;

        do {
            System.out.println("1. Tree size.");
            System.out.println("2. Minimum in the tree.");
            System.out.println("3. Maximum in the tree.");
            System.out.println("4. Height of the tree.");
            System.out.println("5. In-order traversal of the tree.");
            System.out.println("6. Pre-order traversal of the tree.");
            System.out.println("7. Post-order traversal of the tree.");
            System.out.println("8. BFS of the tree.");
            System.out.println("9. DFS of the tree.");
            System.out.println("10. Left view of the tree.");
            System.out.println("11. Right view of the tree.");
            System.out.println("12. Top view of the tree.");

            System.out.println("Choose to perform task: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("The Size of the tree is: " + treeSize(root));
                    break;
                case 2:
                    System.out.println("The Minimum of the tree is: " + minTree(root));
                    break;
                case 3:
                    System.out.println("The Maximum of the tree is: " + maxTree(root));
                    break;
                case 4:
                    System.out.println("The Height of the tree is: " + treeHeight(root));
                    break;
                case 5:
                    System.out.println("The In-order traversal of the tree is: ");
                    inOrder(root);
                    break;
                case 6:
                    System.out.println("The Pre-order traversal of the tree is: ");
                    preOrder(root);
                    break;
                case 7:
                    System.out.println("The Post-order of the tree is: ");
                    postOrder(root);
                    break;
                case 8:
                    System.out.println("The BFS of the tree is: ");
                    treeBFS(root);
                    break;
                case 9:
                    System.out.println("The DFS of the tree is: ");
                    treeDFS(root);
                    break;
                case 10:
                    System.out.println("The Left view of the tree is: ");
                    leftView(root, 0, list);
                    break;
                case 11:
                    System.out.println("The Right view of the tree is: ");
                    rightView(root, 0, list);
                    break;

                case 12:
                    System.out.println("The Top view of the tree is: ");
                    topView(root);
                    break;

                default:
                    System.out.println("Thanks for using it!");
                    flag = false;
                    break;
            }
        } while (flag);
    }
}

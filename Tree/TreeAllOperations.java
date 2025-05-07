import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class TreeAllOperations {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        Node node;
        int hd;

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    static Node createTree(Scanner sc) {
        System.out.print("Enter data:");
        int data = sc.nextInt();
        // Base case
        if (data == -1) {
            return null;
        }

        Node newNode = new Node(data);

        System.out.println("Enter the left of " + data);
        newNode.left = createTree(sc);
        System.out.println("Enter the right of " + data);
        newNode.right = createTree(sc);

        return newNode;
    }

    // Traversal methods
    static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // Method to find the node with minimum element
    static int findMin(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(root.data, Math.min(findMin(root.left), findMin(root.right)));
    }

    // Method to find the node with maximum element
    static int findMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(findMax(root.left), findMax(root.right)));
    }

    // Method to find the number of nodes in the tree
    static int findSize(Node root) {
        if (root == null) {
            return 0;
        }

        return findSize(root.left) + findSize(root.right) + 1;
    }

    // Method to find the sum of all nodes in the tree
    static int findSum(Node root) {
        if (root == null) {
            return 0;
        }

        return findSum(root.left) + findSum(root.right) + root.data;
    }

    // Method to find the hight of the tree
    static int findHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    // Method to print the leaf nodes in the tree
    static void printLeafNode(Node root) {
        // Base case
        if (root == null) {
            return;
        }

        // Recursive case
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }

        // Recursively calling for left and right
        printLeafNode(root.left);
        printLeafNode(root.right);
    }

    // Method to print the level order traversal
    static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.data + " ");

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
    }

    // Method to calculate left view
    static void leftView(Node root, ArrayList<Node> list, int level) {
        if (root == null) {
            return;
        }

        if (list.size() <= level) {
            list.add(root);
        }

        leftView(root.left, list, level + 1);
        leftView(root.right, list, level + 1);
    }

    // Method to print the left view of the tree
    static void printLeftView(Node root) {
        ArrayList<Node> list = new ArrayList<>();
        leftView(root, list, 0);

        for (Node currentNode : list) {
            System.out.print(currentNode.data + " ");
        }
    }

    // Method to calculate right view
    static void rightView(Node root, ArrayList<Node> list, int level) {
        if (root == null) {
            return;
        }

        if (list.size() <= level) {
            list.add(root);
        }
        rightView(root.right, list, level + 1);
        rightView(root.left, list, level + 1);
    }

    // Method to print right view
    static void printRightView(Node root) {
        ArrayList<Node> list = new ArrayList<>();
        rightView(root, list, 0);

        for (Node currentNode : list) {
            System.out.print(currentNode.data + " ");
        }
    }

    // Method to remove the leaf nodes
    static Node removeLeafNodes(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);

        return root;
    }

    static void printAfterRemovedLeafNode(Node root) {
        inOrder(root);
    }

    // Method to find the vertical width in a tree(Vertical width = no. of vertical
    // paths in the tree)
    static int findVerticalWidth(Node root) {
        if (root == null) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            Node currentNode = currentPair.node;
            int newHD = currentPair.hd;

            set.add(newHD);

            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, newHD - 1));
            }

            if (currentNode.right != null) {
                queue.add(new Pair(currentNode.right, newHD + 1));
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = createTree(sc);
        int option;
        do {
            System.out.println("1. Tree Traversal");
            System.out.println("2. Minimum in tree");
            System.out.println("3. Maximum in tree");
            System.out.println("4. Tree Size");
            System.out.println("5. Sum of Tree Nodes");
            System.out.println("6. Height of tree");
            System.out.println("7. Leaf Nodes of tree");
            System.out.println("8. Level order Traversal");
            System.out.println("9. Left View of the tree");
            System.out.println("10. Right View of the tree");
            System.out.println("11. Remove the leaf nodes");
            System.out.println("12. Find Vertical Width");
            System.out.println("0. To exit..");
            System.out.print("Choose one of the above options: ");
            option = sc.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("The Pre-order traversal is: ");
                    preOrder(root);
                    System.out.println();
                    System.out.print("The In-order traversal is: ");
                    inOrder(root);
                    System.out.println();
                    System.out.print("Post-order Traversal is: ");
                    postOrder(root);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("The Minimum in the tree is: " + findMin(root));
                    System.out.println();
                    break;
                case 3:
                    System.out.print("The Maximum in the tree is: " + findMax(root));
                    System.out.println();
                    break;
                case 4:
                    System.out.print("The Size of the tree is: " + findSize(root));
                    System.out.println();
                    break;
                case 5:
                    System.out.print("The Sum of nodes in the tree is: " + findSum(root));
                    System.out.println();
                    break;
                case 6:
                    System.out.print("The Height of the tree is: " + findHeight(root));
                    System.out.println();
                    break;
                case 7:
                    System.out.print("The Leaf Nodes in the tree are: ");
                    printLeafNode(root);
                    System.out.println();
                    break;
                case 8:
                    System.out.print("The Level of tree is: ");
                    levelOrderTraversal(root);
                    System.out.println();
                    break;
                case 9:
                    System.out.print("The Left view of the tree is: ");
                    printLeftView(root);
                    System.out.println();
                    break;
                case 10:
                    System.out.print("The Right view of the tree is:");
                    printRightView(root);
                    System.out.println();
                    break;
                case 11:
                    System.out.println("The Remaining nodes are: ");
                    Node newRoot = removeLeafNodes(root);
                    printAfterRemovedLeafNode(newRoot);
                    System.out.println();
                    break;

                case 12:
                    System.out.print("The Vertical Width of the given tree is: " + findVerticalWidth(root));
                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid option! Please enter a valid option.");
                    break;
            }
        } while (option != 0);
    }
}

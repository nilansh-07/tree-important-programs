import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateSubtrees {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node createTree(Scanner sc) {
        System.out.print("Enter data: ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node newNode = new Node(data);

        System.out.println("Enter left of " + data + ": ");
        newNode.left = createTree(sc);
        System.out.println("Enter right of " + data + ": ");
        newNode.right = createTree(sc);

        return newNode;
    }

    static ArrayList<Node> findDuplicate(Node root) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Node> list = new ArrayList<>();

        getSubTreesString(root, map, list);

        return list;
    }

    static String getSubTreesString(Node root, HashMap<String, Integer> map, ArrayList<Node> list) {
        if (root == null) {
            return "N";
        }
        String str = root.data + "," + getSubTreesString(root.left, map, list) + "," + getSubTreesString(root.right, map, list);

        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2) {
            list.add(root);
        }

        return str;
    }

    static void printDuplicateSubtrees(ArrayList<Node> list) {
        for (Node node : list) {
            printTree(node);
            System.out.println();
        }
    }

    static void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = createTree(sc);
        ArrayList<Node> newList = findDuplicate(root);

        System.out.println("Duplicate Subtrees:");
        printDuplicateSubtrees(newList);

        sc.close();
    }
}

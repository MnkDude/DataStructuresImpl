import java.util.Scanner;

class BinaryTree {
    public BinaryTree left;
    public BinaryTree right;
    public int data;

    private BinaryTree() {
    }

    public static BinaryTree create() {
        BinaryTree newNode = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        newNode.data = scanner.nextInt();
        if (newNode.data == -1) return null;
        System.out.println("Enter data for left node of " + newNode.data + "(" + newNode.toString() + ")(-1 if no data)");
        newNode.left = create();
        System.out.println("Enter data for right node of " + newNode.data + "(" + newNode.toString() + ")(-1 if no data)");
        newNode.right = create();
        return newNode;
    }

    public static BinaryTree leftChildOf(BinaryTree tree) {
        return new BinaryTree();
    }

    public static BinaryTree rightChildOf(BinaryTree tree) {
        return new BinaryTree();


    }

    public static BinaryTree parentOf(BinaryTree tree) {
        return new BinaryTree();
    }

    public static void preOrderOf(BinaryTree tree) {
        if (tree != null) {
            System.out.println(tree.data);
            preOrderOf(tree.left);
            preOrderOf(tree.right);
        }
    }

    public static void postOrderOf(BinaryTree tree) {
        if (tree != null) {
            postOrderOf(tree.left);
            postOrderOf(tree.right);
            System.out.println(tree.data);
        }
    }

    public static void inOrderOf(BinaryTree tree) {
        if (tree != null) {
            inOrderOf(tree.left);
            System.out.println(tree.data);
            inOrderOf(tree.right);
        }
    }
}

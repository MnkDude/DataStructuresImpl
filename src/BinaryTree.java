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

    public static void printTree(BinaryTree tree, int space) {
        if (tree != null) {
            space += 5;
            printTree(tree.left, space);
            for (int i = 0; i < space; i++) {
                System.out.print("  ");
            }
            System.out.println(tree.data);
            printTree(tree.right, space);
        }

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

    public static BinaryTree copy(BinaryTree tree) {
        if (tree == null) return null;
        BinaryTree newTree = new BinaryTree();
        newTree.data = tree.data;
        newTree.left = copy(tree.left);
        newTree.right = copy(tree.right);
        return newTree;
    }

    public static boolean isEqual(BinaryTree tree1, BinaryTree tree2) {
        if (height(tree1) != height(tree2)) return false;
        if (nodeCount(tree1) != nodeCount(tree2)) return false;
        return isEqual(tree1, tree2, true);
    }

    private static boolean isEqual(BinaryTree tree1, BinaryTree tree2, boolean isit) {
        if (tree1 != null) {
            if (isit && tree1.data == tree2.data) {
                isit = isEqual(tree1.left, tree2.left, true);
                if (!isit) return false;
                isit = isEqual(tree1.right, tree2.right, true);
                if (!isit) return false;
            } else {
                return false;
            }
        }
        return true;
    }

    public static int height(BinaryTree tree) {
        if (tree == null) return 0;
        else return Math.max(height(tree.left), height(tree.right)) + 1;
    }

    public static int nodeCount(BinaryTree tree) {
        if (tree == null) return 0;
        return nodeCount(tree.left) + 1 + nodeCount(tree.right);
    }

    public static boolean contains(int data, BinaryTree tree) {
        boolean is = false;
        if (tree != null) {
            if (data == tree.data) return true;
            contains(data, tree.left);
            contains(data, tree.right);
        } else {
        }
        return false;
    }

    public static void preOrderNonRecursive(BinaryTree tree) {
        BinaryTree temp = tree;
        while (true) {
            if (tree.left == null) {

            }
        }
    }

    public boolean checkBST(BinaryTree tree) {
        return checkBST(tree, 0, Integer.MAX_VALUE);
    }

    private boolean checkBST(BinaryTree tree, int min, int max) {
        if(tree!=null) {
            if(tree.data>min&&tree.data<max) {
                return checkBST(tree.left,min,tree.data) && checkBST(tree.right,tree.data,max);
            }
            return false;
        }
        return true;
    }
}

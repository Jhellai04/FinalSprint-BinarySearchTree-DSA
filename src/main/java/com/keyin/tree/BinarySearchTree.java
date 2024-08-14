package com.keyin.tree;

public class BinarySearchTree {
    private Node root;

    public String JsonFormat() {
        return "";
    }

    public static class Node {
        private final int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    public Node getRoot() {
        return root;
    }

    public String toJson() {
        if (root == null) {
            return "{}";
        }

        return "{\n\"root\":" + toJsonRecursive(root, 0) + "\n}";
    }

    private String toJsonRecursive(Node current, int level) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");

        String indentation = "  ".repeat(level + 1);

        jsonBuilder.append(indentation).append("\"value\":").append(current.getValue());

        if (current.getLeft() != null) {
            jsonBuilder.append(",\n").append(indentation).append("\"left\":").append(toJsonRecursive(current.getLeft(), level + 1));
        } else {
            jsonBuilder.append(",\n").append(indentation).append("\"left\":null");
        }

        if (current.getRight() != null) {
            jsonBuilder.append(",\n").append(indentation).append("\"right\":").append(toJsonRecursive(current.getRight(), level + 1));
        } else {
            jsonBuilder.append(",\n").append(indentation).append("\"right\":null");
        }

        jsonBuilder.append("\n").append("  ".repeat(level)).append("}");

        return jsonBuilder.toString();
    }

    // Example methods utilizing setLeft and setRight
    public void setLeftChild(Node parent, Node child) {
        if (parent != null) {
            parent.setLeft(child);
        }
    }

    public void setRightChild(Node parent, Node child) {
        if (parent != null) {
            parent.setRight(child);
        }
    }

    // Example method utilizing getRoot
    public void printRootValue() {
        Node rootNode = getRoot();
        if (rootNode != null) {
            System.out.println("Root value: " + rootNode.getValue());
        } else {
            System.out.println("The tree is empty.");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        // Utilizing setLeft and setRight
        Node root = bst.getRoot();
        Node leftChild = new Node(2);
        bst.setLeftChild(root.getLeft(), leftChild);  // Set left child of node with value 5

        Node rightChild = new Node(6);
        bst.setRightChild(root.getLeft(), rightChild); // Set right child of node with value 5

        // Utilizing getRoot
        bst.printRootValue();

        // Print JSON representation
        System.out.println(bst.toJson());
    }
}

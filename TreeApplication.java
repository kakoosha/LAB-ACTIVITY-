import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Node class representing each node in the tree
class TreeNode {
    String data;
    List<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    // Method to add a child
    public void addChild(TreeNode child) {
        children.add(child);
    }

    // Method to display the tree
    public void display(String prefix) {
        System.out.println(prefix + data);
        for (TreeNode child : children) {
            child.display(prefix + "    ");
        }
    }
}

public class TreeApplication {
    private TreeNode root;

    public TreeApplication(String rootData) {
        root = new TreeNode(rootData);
    }

    public TreeNode getRoot() {
        return root;
    }

    // Method to add a child to a node
    public void addChild(TreeNode parent, String childData) {
        parent.addChild(new TreeNode(childData));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeApplication treeApp = new TreeApplication("Root");

        // Build the tree
        while (true) {
            System.out.print("Enter parent node and child node (parent, child) or 'exit' to quit: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            String[] nodes = input.split(",");
            if (nodes.length == 2) {
                String parentData = nodes[0].trim();
                String childData = nodes[1].trim();
                // You would typically search for the parent node in the tree
                // Here we'll just add it to the root for simplicity
                treeApp.addChild(treeApp.getRoot(), childData);
            } else {
                System.out.println("Invalid input. Please enter in the format (parent, child).");
            }
        }

        scanner.close();

        // Display the tree
        System.out.println("Tree structure:");
        treeApp.getRoot().display("");
    }
}
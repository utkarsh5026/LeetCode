package linked_lists.medium;

// https://leetcode.com/problems/design-browser-history/description/
// 1472. Design Browser History
class BrowserHistory {

    class Node {
        String website;
        Node left;
        Node right;

        public Node(String website) {
            this.website = website;
        }
    }

    Node current;

    public BrowserHistory(String homepage) {
        this.current = new Node(homepage);
    }

    public void visit(String url) {
        Node newSite = new Node(url);
        current.right = newSite;
        newSite.left = current;
        current = newSite;
    }

    public String back(int steps) {
        while (current.left != null && steps-- > 0) {
            current = current.left;
        }

        return current.website;
    }

    public String forward(int steps) {
        while (current.right != null && steps-- > 0) {
            current = current.right;
        }

        return current.website;
    }
}

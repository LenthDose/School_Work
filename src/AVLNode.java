public class AVLNode<T extends Comparable> {
    public AVLNode<T> left;
    public AVLNode<T> right;
    public T data;
    public int height;

    public AVLNode(AVLNode<T> left, AVLNode<T> right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
        this.height = 1;
    }

}

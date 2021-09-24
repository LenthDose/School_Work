/**
 * @author Silhouette76
 */
public class AVLNode<T extends Comparable> {
    public AVLNode<T> left;
    public AVLNode<T> right;
    public T data;
    public int height;

    public AVLNode(T data) {
        this.left = null;
        this.right= null;
        this.data = data;
    }
}

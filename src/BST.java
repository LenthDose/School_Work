public class BST<T extends Comparable<T>> {
    private Node<T> root;

    private class Node<T>{
        private T data;
        private Node left,right;

        public Node(T data,Node<T> left, Node<T> right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void put(T data){
        root = put(data,root);
    }

    private Node<T> put(T data, Node<T> p){
        if(p == null){
            return new Node<>(data,null,null);
        }

        int cmp = data.compareTo(p.data);
        if(cmp<0){
            p.left = put(data,p.left);
        }
        if(cmp>0){
            p.right = put(data,p.right);
        }
        else p.data = data;
        return p;
    }

    public Node<T> search(T data){
        return search(data,root);
    }

    private Node<T> search(T data,Node<T> p){
        if(p == null){
            return null;
        }
        int cmp = data.compareTo(p.data);
        if(cmp<0){
            return put(data,p.left);
        }
        if(cmp>0){
            return put(data,p.right);
        }
        else return p;
    }

    public void inorder(BST<T> tree){
        inorder(root);
    }

    private void inorder(Node<T> p){
        if(p!=null){
            inorder(p.left);
            System.out.println(p.data.toString()+" ");
            inorder(p.right);
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {6,18,12,36,81,54,66,99,57,76};
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < arr.length; i++) {
            bst.put(arr[i]);
        }
        long startTime = System.nanoTime();
        bst.search(9);
        long endTime = System.nanoTime();
        System.out.println("二叉排序树搜索运行时间："+(endTime-startTime)+"ns");
//        bst.inorder(bst);

    }
}

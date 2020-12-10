public class AVLTree<T extends Comparable> {
    private AVLNode<T> root;

    //LL 右旋转
    private AVLNode<T> SingleRotateRight(AVLNode<T> x){
        AVLNode<T> w = x.left;
        x.left = w.right;
        w.right = x;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
        w.height = Math.max(getHeight(w.left),getHeight(w.right))+1;
        return w;
    }

    //RR 左旋转
    private AVLNode<T> SingleRotateLeft(AVLNode<T> x){
        AVLNode<T> w = x.right;
        x.right = w.left;
        w.left = x;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
        w.height = Math.max(getHeight(w.left),getHeight(w.right))+1;
        return w;
    }

    //LR 结点的左孩子先左旋转，结点再自己右旋转
    private AVLNode<T> DoubleRotateRight(AVLNode<T> x){
        x.left = SingleRotateLeft(x.left);
        return SingleRotateRight(x);
    }

    //Rl 结点的右孩子先右旋转，结点再自己左旋转
    private AVLNode<T> DoubleRotateLeft(AVLNode<T> x){
        x.right = SingleRotateRight(x.right);
        return SingleRotateLeft(x);
    }


    //获取高度
    public int getHeight(AVLNode<T> p){
        if(p == null){
            return 0;
        }
        return p.height;
    }

    //结点的平衡因子
    private int getBalanceFactor(AVLNode<T> p){
        if(p == null){
            return 0;
        }

        return getHeight(p.left)-getHeight(p.right);
    }

    //插入
    public void  insert(T data){
        root = insert(data,root);
    }

    private AVLNode<T> insert(T data,AVLNode<T> p){
        if( p == null){
           p =  new AVLNode<T>(null,null,data);
        }
        int cmp = data.compareTo(p.data);
        if(cmp<0){
            p.left = insert(data,p.left);
        }
        else if(cmp>0){
            p.right = insert(data,p.right);
        }
        else{
            p.data = data;
        }
        p.height = Math.max(getHeight(p.left),getHeight(p.right)+1);
        int balanceFactor = getBalanceFactor(p);

        //判断结点的左孩子的左子树高度是否大于右子树，如果大于将结点进行LL型调整，也就是向右旋转。
        if(balanceFactor == 2 && getBalanceFactor(p.left) >=0){
            return SingleRotateRight(p);
        }
        //判断结点的左孩子的右子树高度是否大于左子树，如果大于将结点进行LR调整，也就是先进行左旋转再进行右旋转
        if(balanceFactor == 2 && getBalanceFactor(p.left) <0){
            return DoubleRotateRight(p);
        }
        //判断结点的右孩子的右子树高度是否大于左子树，如果大于结点将进行RR调整，也就是向左旋转
        if(balanceFactor == -2 && getBalanceFactor(p.right) <=0){
            return SingleRotateLeft(p);
        }
        //判断结点的右孩子的左子树高度是否大于右子树，如果大于将结点进行RL调整，也就是先进行右旋转再进行左旋转
        if(balanceFactor == -2 && getBalanceFactor(p.right) >0){
            return DoubleRotateLeft(p);
        }
        return p;
    }

    //查找
    public AVLNode<T> Search(T data){
        return Search(data,root);
    }

    private AVLNode<T> Search(T data,AVLNode<T> p){
        if (p == null){
            return null;
        }
        int cmp = data.compareTo(p.data);
        if(cmp<0){
            return Search(data, p.left);
        }
        else if(cmp>0){
            return Search(data, p.right);
        }
        else {return p;}
    }

    //删除最小值
    public AVLNode<T> deleteMin(AVLNode<T> p){
        if(p.left == null){
            return p.right;
        }
        p.left = deleteMin(p.right);
        return p;
    }

    //最小值
    public T min(){
        return min(root).data;
    }

    private AVLNode<T> min(AVLNode<T> p){
        if(p.left == null){
            return p;
        }
        return min(p.left);
    }

    //删除
    public void delete(T data){
        root = delete(root, data);
    }

    public AVLNode<T> delete(AVLNode<T> p, T data){
        if(p == null){
            return null;
        }

        int cmp = data.compareTo(p.data);
        if(cmp<0){
            p.left = delete(p.left,data);
        }
        else if(cmp>0){
            p.right = delete(p.right,data);
        }
        else{
            if(p.left == null){
                return p.right;
            }
            if(p.right == null){
                return p.left;
            }
            AVLNode<T> x = p;
            p = min(x.right);
            p.right = deleteMin(x.right);
            p.left = x.left;
        }

        p.height = Math.max(getHeight(p.left),getHeight(p.right)+1);
        int balanceFactor = getBalanceFactor(p);

        //判断结点的左孩子的左子树高度是否大于右子树，如果大于将结点进行LL型调整，也就是向右旋转。
        if(balanceFactor == 2 && getBalanceFactor(p.left) >=0){
            return SingleRotateRight(p);
        }
        //判断结点的左孩子的右子树高度是否大于左子树，如果大于将结点进行LR调整，也就是先进行左旋转再进行右旋转
        if(balanceFactor == 2 && getBalanceFactor(p.left) <0){
            return DoubleRotateRight(p);
        }
        //判断结点的右孩子的右子树高度是否大于左子树，如果大于结点将进行RR调整，也就是向左旋转
        if(balanceFactor == -2 && getBalanceFactor(p.right) <=0){
            return SingleRotateLeft(p);
        }
        //判断结点的右孩子的左子树高度是否大于右子树，如果大于将结点进行RL调整，也就是先进行右旋转再进行左旋转
        if(balanceFactor == -2 && getBalanceFactor(p.right) >0){
            return DoubleRotateLeft(p);
        }
        return p;
    }

    //中序遍历
    public void inorder(AVLTree<T> tree){
        inorder(root);
    }

    public void inorder(AVLNode<T> p){
        if(p!=null){
            inorder(p.left);
            System.out.println("结点"+p.data.toString()+"   "+"结点因子"+getBalanceFactor(p));
            inorder(p.right);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {6,12,18,36,54,57,66,76,81,99};
        AVLTree<Comparable> tree = new AVLTree<>();
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }

        long startTime = System.nanoTime();
        tree.Search(9);
        long endTime = System.nanoTime();
        System.out.println("平衡二叉树搜索运行时间："+(endTime-startTime)+"ns");
//        tree.delete(36);
//        System.out.println("中序遍历："+"\n");
//        tree.inorder(tree);
    }

}

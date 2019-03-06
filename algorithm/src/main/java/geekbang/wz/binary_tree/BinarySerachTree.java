package geekbang.wz.binary_tree;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * <pre>类名: BinarySerachTree</pre>
 * <pre>描述: 二分查找树</pre>
 * <pre>日期: 2019/3/6 13:46</pre>
 * <pre>作者: xueshun</pre>
 */
public class BinarySerachTree {

    private Node tree;

    /**
     * 向树插入数据
     *
     * @param data 需要插入的数据
     */
    public void insert(int data) {
        //[1] 判断树是否为空，为null 创建一颗树
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            // [2] 判断data是否大于父节点
            if (data > p.data) {
                // [2.1] 如果父节点的右节点为null，直接插入
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                // [2.2] 如果父节点的有右节点不为null,p = p.right
                p = p.right;
            } else { // data < p.data
                // [2.3] 判断父节点的左节点是否为null，是，直接插入
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                // [2.4] 父节点的左节点不为null, p = p.left
                p = p.left;
            }
        }
    }


    /**
     * 查找数据
     *
     * @param data 需要查找的数据
     * @return Node
     */
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) {
                p = p.left;
            } else if (data > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 删除节点
     *
     * @param data
     */
    public void delete(int data) {
        Node p = tree;
        Node pp = null;

        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        // 没有查找到数据
        if (p == null) {
            return;
        }

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }

        // 删除的节点是叶子节点或者仅有一个子节点
        // p的子节点
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    /**
     * 查找二分查找树的最小值
     *
     * @return
     */
    public Node findMin() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    /**
     * 查找二分查找树的最大值
     *
     * @return
     */
    public Node findMax() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }


    /**
     * 定义节点
     * data : 节点数据
     * left ： 左节点
     * right : 右节点
     */
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return ReflectionToStringBuilder.toString(this);
        }
    }
}

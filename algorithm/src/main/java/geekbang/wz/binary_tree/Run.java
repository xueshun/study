package geekbang.wz.binary_tree;

public class Run {
    public static void main(String[] args) {
        BinarySerachTree tree = new BinarySerachTree();
        tree.insert(33);
        tree.insert(16);
        tree.insert(50);
        tree.insert(13);
        tree.insert(18);
        tree.insert(34);
        tree.insert(58);
        tree.insert(15);
        tree.insert(17);
        tree.insert(25);
        tree.insert(51);
        tree.insert(66);
        tree.insert(19);
        tree.insert(27);
        tree.insert(55);
        System.out.println(tree.findMax());
    }
}

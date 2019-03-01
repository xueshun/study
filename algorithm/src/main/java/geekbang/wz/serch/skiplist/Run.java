package geekbang.wz.serch.skiplist;

public class Run {
    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(4);
        skipList.insert(5);
        skipList.insert(17);
        skipList.insert(18);
        skipList.insert(3);
        skipList.insert(9);
        skipList.insert(10);
        skipList.printAll();

    }
}

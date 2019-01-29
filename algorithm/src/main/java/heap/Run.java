package heap;

public class Run {

    public static void main(String[] args) {
        MaxPQ maxPQ = new MaxPQ();
        maxPQ.inSert(1);
        maxPQ.inSert(2);
        maxPQ.inSert(2);
        maxPQ.inSert(3);
        maxPQ.inSert(4);
        maxPQ.inSert(6);
        maxPQ.inSert(5);
        System.out.println(maxPQ);
    }
}

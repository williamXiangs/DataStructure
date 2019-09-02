package list;

public class ListMain {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 0 ;i < 5;i++){
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }

        for(int i = 0 ;i < 5;i++){
            linkedList.addLast(i);
            System.out.println(linkedList.toString());
        }

        linkedList.add(5,5);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(5));

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.get(5));

        linkedList.set(5,6);
        System.out.println(linkedList);

        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);
        System.out.println(linkedList.remove(5));
        System.out.println(linkedList);
    }
}

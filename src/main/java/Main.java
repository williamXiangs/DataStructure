import array.Array;
import queue.ArrayQueue;
import stack.ArrayStack;

public class Main {

    public static void main(String[] args) {
        Array<String> stringArray = new Array<String>();

        for (int i = 0; i < 10 ; i++){
            stringArray.add(i,i+"");
        }
        System.out.println(stringArray.toString());

        stringArray.remove(0);
        System.out.println(stringArray.toString());

        ArrayStack<String> stringArrayStack = new ArrayStack<String>();

        for (int i = 0; i < 10 ; i++){
            stringArrayStack.push(i+"");
        }
        System.out.println(stringArrayStack.toString());


        ArrayQueue<String> arrayQueue = new ArrayQueue<String>();
        for (int i = 0; i < 10 ; i++){
            arrayQueue.enqueue(i + "");
            System.out.println(arrayQueue.toString());

            if( i % 3 == 2){
                arrayQueue.dequeue();
                System.out.println(arrayQueue.toString());
            }
        }

    }
}

package queue;

public interface Queue<E> {
    /**
     * 获取队列长度
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入队操作
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队操作
     * @return
     */
    E dequeue();

    /**
     * 查看队首元素
     * @return
     */
    E getFront();
}

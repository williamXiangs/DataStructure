package stack;

public interface Stack<E> {

    /**
     * 获得栈的大小
     * @return 栈的大小
     */
    int getSize();

    /**
     * 向栈顶添加一个元素
     */
    void push(E e);

    /**
     * 移除栈顶元素
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    E peek();

    /**
     * 判断栈是否未空
     * @return true == 空；false != 空
     */
    boolean isEmpty();
}

public class Array<E> {
    /**
     * 数组大小
     */
    private int size;

    /**
     * 泛型数组
     */
    private E[] data ;

    /**
     * 指定容量大小的数组
     * @param capacity 数组的容量
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造方法，默认容量大小为10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的某个元素
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("get fail,Require index >= 0 and index < size");

        return data[index];
    }

    /**
     * 修改数组中某一位置的元素
     * @param index 设置元素的下标
     * @param e 设置的元素
     */
    public void set(int index,E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("get fail,Require index >= 0 and index < size");

        data[index] = e;
    }

    /**
     * 获取数组大小
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 在数组第一个位置添加一个元素，其他元素依次向后移动
     * @param e 需要添加的元素
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在数组最后一个位置添加一个元素
     * @param e 需要添加的元素
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 在数组某个位置添加一个元素
     * <br>
     *      index不能小于0
     * <br>
     *      index也不能大于数组的size,否则会在数组中产生空隙
     * @param index 元素添加的位置
     * @param e 需要添加的元素
     */
    public void add(int index,E e){
        if(index < 0 || index > size )
            throw new IllegalArgumentException("add failed,Require index >= 0 and index < size");

        if(size == data.length)
            resize(data.length * 2);

        for(int i = size;i > index; i--){
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    /**
     * 移除第一个元素
     * @return 被移除的元素
     */
    public E removeFirst(){
        return remove(0);
    }


    /**
     * 移除最后一个元素
     * @return 被移除的元素
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 移除数组某一位置上的元素，该位置后的元素向前移动，补齐空缺
     * @param index 移除元素的位置
     * @return 被移除的元素
     */
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("remove fail,Require index >= 0 and index < size");

        E e = data[index];

        //移除操作的做法为将index+1开始的元素向前覆盖
        //这里设置初始值为index+1
        //是因为当要删除的元素为最后一个元素时
        //只需要将size减1，使得用户无法访问到最后一个元素即可
        //而不是对最后一个元素进行覆盖
        for(int i = index + 1;i < size;i++)
            data[i - 1] = data[i];

        size--;
        //用户虽然不能访问到下标为size的这一个元素
        //但是当这个位置存储了一个对象却没地方可以访问，就会造成空间的浪费
        data[size] = null;

        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return e;
    }

    /**
     * 判断数组是否包含某元素，若包含返回“true”，否则返回“false”
     * @param e 查询的元素
     * @return
     */
    public boolean contains(E e){
        for(int i = 0;i < size;i++)
            if(data[i] == e)
                return true;
        return false;
    }

    /**
     * 对数组大小进行赋值
     * @param int 新的容量大小
     * @return 数组新的容量大小
     */
    private int resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0;i < size;i++){
            newData[i] = data[i];
        }

        data = newData;

        return data.length;
    }

    /**
     * 查找元素在数组中的下标，若查找到返回该元素下标，否则返回“-1”
     * @param e 查询的元素
     * @return
     */
    public int find(E e){
        for(int i = 0;i < size;i++)
            if(data[i] == e)
                return i;
        return -1;
    }


    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();
        res.append(String.format("Array: size = %d,capacity = %d \n",size,data.length));
        res.append("[");
        for(int i = 0 ; i < size;i++){
            res.append(data[i]);
            if (i != size -1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }
}

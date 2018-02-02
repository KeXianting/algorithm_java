package data_struct.stack_queue;

/**
 * Created by kentorvalds on 2017/6/6.
 */
/**
 * 队列接口
 */
public interface QQueue<T> {

    boolean isEmpty();// 判断队列是否空

    void enquenu(T x);// 元素x入队

    T dequeue();// 出队,返回对头元素
}

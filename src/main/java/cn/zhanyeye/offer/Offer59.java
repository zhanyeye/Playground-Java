package cn.zhanyeye.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
/**
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 */
class Offer59 {
    // 维护一个单调的双端队列
    // 如果关注动态变化的最大值：队列中添加一个值后，在它之前比它小的元素都不会对它产生影响
    // 如果关注动态变化的最小值：队列中添加一个值后，在它之前比它大的元素都不会对它产生影响
    Queue<Integer> queue;
    Deque<Integer> deque;

    public Offer59() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    
    public int max_value() {    
        if (queue.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }
    
    public void push_back(int value) {
        // 为什么不是 <= 呢？等于的话，仍然会对结果产生影响
        while(!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }
    
    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        // 大于127的Integer对象要用equal比较，不能用== ！！！！！
        if (queue.peek().equals(deque.peekFirst())) {
            deque.pollFirst();
        }
        return queue.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
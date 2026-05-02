
class MinStack {
    Deque<Long> stack;
    Deque<Long> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push((long) val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push((long) val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        long pop = stack.pop();
        if (pop == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek().intValue();
    }

    public int getMin() {
        return minStack.peek().intValue();
    }
}

       
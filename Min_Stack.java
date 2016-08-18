public class MinStack {
    
  /** initialize your data structure here. */
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;

  public MinStack() {
    stack1 = new Stack<Integer>();
    stack2 = new Stack<Integer>();
  }

  public void push(int x) {
    stack1.push(x);
    if (stack2.isEmpty()) {
      stack2.push(x);
    } else if (x <= stack2.peek()) {
      stack2.push(x);
    }
  }

  public void pop() {
    int x = stack1.pop();
    if (x <= stack2.peek()) {
      stack2.pop();
    }
  }

  public int top() {
    return stack1.peek();
  }

  public int getMin() {
    return stack2.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

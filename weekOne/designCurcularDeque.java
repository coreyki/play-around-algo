class MyCircularDeque {
    class DoubleLinkedNode {
        int value;
        DoubleLinkedNode next;
        DoubleLinkedNode prev;
        DoubleLinkedNode(int val) {
            value = val;
        }
    }

    int capacity;
    int curSize;
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.curSize = 0;
        this.head = new DoubleLinkedNode(0);
        this.tail = new DoubleLinkedNode(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public boolean insertFront(int value) {
        if (curSize == capacity) return false;
        DoubleLinkedNode next = head.next;
        DoubleLinkedNode newNode = new DoubleLinkedNode(value);
        head.next = newNode;
        newNode.prev = head;
        newNode.next = next;
        next.prev = newNode;
        curSize++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (curSize == capacity) return false;
        DoubleLinkedNode prev = tail.prev;
        DoubleLinkedNode newNode = new DoubleLinkedNode(value);
        newNode.next = tail;
        tail.prev = newNode;
        newNode.prev = prev;
        prev.next = newNode;
        curSize++;
        return true;
    }
    
    public boolean deleteFront() {
        if (curSize == 0) return false;
        DoubleLinkedNode node = head.next;
        head.next = node.next;
        node.next.prev = head;
        curSize--;
        return true;
    }
    
    public boolean deleteLast() {
        if (curSize == 0) return false;
        DoubleLinkedNode node = tail.prev;
        tail.prev = node.prev;
        node.prev.next = tail;
        curSize--;
        return true;
    }
    
    public int getFront() {
        return curSize == 0 ? -1 : head.next.value;
    }
    
    public int getRear() {
        return curSize == 0 ? -1 : tail.prev.value;
    }
    
    public boolean isEmpty() {
        return curSize == 0;
    }
    
    public boolean isFull() {
        return curSize == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

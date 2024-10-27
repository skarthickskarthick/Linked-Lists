class ll {
    node head, tail;
    int size;

    ll() {
        this.size = 0;
    }

    void insertfirst(int value) {
        node nod = new node(value);
        nod.next = head;
        head = nod;
        if (tail == null)
            tail = head;
        size++;

    }

    void insertlast(int value) {
        node nod = new node(value);
        if (tail == null) {
            insertfirst(value);
            return;
        }
        tail.next = nod;
        tail = nod;
        size++;
    }

    void insert(int value, int index) {
        if (index == 0) {
            insertfirst(value);
            return;
        }
        if (index == size) {
            insertlast(value);
            return;
        }
        node temp = head;
        for (int i = 1; i < index; i++)
            temp = temp.next;
        node nod = new node(value, temp.next);
        temp.next = nod;
        size++;

    }

    void search(int value) {
        node temp = head;
        while (temp != null) {
            if (temp.value == value)
                System.out.println("found");
            temp = temp.next;
        }
    }

    node get(int index) {

        node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;
        return temp;
    }

    int deletefirst() {
        int val = head.value;
        head = head.next;
        if (head == null)
            tail = null;
        size--;
        return val;
    }

    int deletelast() {
        if (size <= 1)
            return deletefirst();
        node secondlast = get(size - 2);
        int val = tail.value;
        tail = secondlast;
        tail.next = null;
        size--;
        return val;

    }

    int delete(int index) {
        if (index == 0)
            return deletefirst();
        if (index == size - 1)
            return deletelast();
        node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    class node {
        int value;
        node next;

        node(int value) {
            this.value = value;
        }

        node(int value, node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String args[]) {
        ll l = new ll();
        l.insert(5, 0);
        l.insert(3, 1);
        l.insert(4, 2);
        l.display();
        l.search(4);
        l.delete(2);
        l.display();
    }

}
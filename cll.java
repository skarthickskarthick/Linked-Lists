class cll {
    node head;
    node tail;

    cll() {
        this.head = null;
        this.tail = null;
    }

    void insert(int value) {
        node nod = new node(value);
        if (head == null) {
            head = nod;
            tail = nod;
            return;
        }
        tail.next = nod;
        nod.next = head;
        tail = nod;
    }

    void display() {
        node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.value + " ");
                if (temp != null)
                    temp = temp.next;
            } while (temp != head);
        } else
            System.out.println("empty list");
    }

    void delete(int value) {
        node temp = head;
        if (temp == null)
            return;
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        if (temp.value == value) {
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            node n = temp.next;
            if (n.value == value) {
                temp.next = n.next;
                break;

            }
            temp = temp.next;
        } while (temp != head);

    }

    class node {
        int value;
        node next;

        node(int value)

        {
            this.value = value;
        }

    }

    public static void main(String args[]) {
        cll l = new cll();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.display();
        l.delete(1);

        l.display();
    }
}
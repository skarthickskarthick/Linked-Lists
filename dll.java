class dll {
    node head;

    void insertfirst(int value) {
        node nod = new node(value);
        nod.next = head;
        nod.prev = null;
        if (head != null)
            head.prev = nod;
        head = nod;
    }

    void insertlast(int value) {
        node nod = new node(value);
        node last = head;
        nod.next = null;
        if (head == null) {
            nod.prev = null;
            head = nod;
            return;
        }
        while (last.next != null)
            last = last.next;
        last.next = nod;
        nod.prev = last;
    }

    node get(int value) {
        node temp = head;
        while (temp != null) {
            if (temp.value == value)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    void insert(int after, int value) {
        node nod = new node(value);
        node aft = get(after);
        if (aft == null) {
            System.out.println("no list");
            return;
        }
        nod.next = aft.next;
        aft.next = nod;
        nod.prev = aft;
        if (nod.next != null)
            nod.next.prev = nod;
    }

    void display() {
        node temp = head;
        node last = null;
        while (temp != null) {
            last = temp;
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        while (last != null) {
            System.out.print(last.value + " ");
            last = last.prev;
        }
    }

    class node {
        int value;
        node next;
        node prev;

        node(int value) {
            this.value = value;
        }

        node(int value, node next, node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String args[]) {
        dll l = new dll();
        l.insertfirst(1);
        l.insert(1, 2);
        l.insert(2, 3);
        l.insertlast(4);
        l.display();
    }
}
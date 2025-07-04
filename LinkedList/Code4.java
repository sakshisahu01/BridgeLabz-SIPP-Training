class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    Item head;

    void addAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    void addAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    void addAtPosition(int pos, String name, int id, int quantity, double price) {
        if (pos == 0) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = temp.next;
        temp.next = newItem;
    }

    void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println("Item: " + temp.name + ", ID: " + temp.id + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            }
            temp = temp.next;
        }
    }

    void searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Item: " + temp.name + ", ID: " + temp.id + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            }
            temp = temp.next;
        }
    }

    void calculateTotalValue() {
        Item temp = head;
        double total = 0;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    Item mergeSort(Item head, String sortBy, boolean ascending) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSort(head, sortBy, ascending);
        Item right = mergeSort(nextOfMiddle, sortBy, ascending);
        return sortedMerge(left, right, sortBy, ascending);
    }

    Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Item sortedMerge(Item a, Item b, String sortBy, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;
        boolean condition;
        if (sortBy.equals("name")) {
            condition = ascending ? a.name.compareToIgnoreCase(b.name) <= 0 : a.name.compareToIgnoreCase(b.name) > 0;
        } else {
            condition = ascending ? a.price <= b.price : a.price > b.price;
        }
        Item result;
        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, sortBy, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, sortBy, ascending);
        }
        return result;
    }

    void sortInventory(String sortBy, boolean ascending) {
        head = mergeSort(head, sortBy, ascending);
    }

    void displayInventory() {
        Item temp = head;
        while (temp != null) {
            System.out.println("Item: " + temp.name + ", ID: " + temp.id + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

class Code4 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addAtEnd("Pen", 101, 50, 5.0);
        inventory.addAtBeginning("Notebook", 102, 20, 20.0);
        inventory.addAtPosition(1, "Eraser", 103, 100, 2.0);
        inventory.displayInventory();
        System.out.println("--- After Sorting by Name Descending ---");
        inventory.sortInventory("name", false);
        inventory.displayInventory();
        System.out.println("--- Total Inventory Value ---");
        inventory.calculateTotalValue();
        System.out.println("--- Search by ID 103 ---");
        inventory.searchById(103);
        System.out.println("--- Update Quantity of ID 101 to 80 ---
        ");
        inventory.updateQuantity(101, 80);
        inventory.displayInventory();
    }
}

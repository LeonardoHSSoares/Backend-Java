public class HashMapInt {

    private static final int CAPACITY = 31;
    private SinglyLinkedList[] table;

    public HashMapInt() {
        table = new SinglyLinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            table[i] = new SinglyLinkedList();
        }
    }

    private int hash(int key) {
        return key % CAPACITY;
    }

    public void put(int key) {
        int index = hash(key);
        if (!table[index].contains(key)) {
            table[index].add(key);
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    public boolean remove(int key) {
        int index = hash(key);
        return table[index].remove(key);
    }
}

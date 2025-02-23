public class Main {

    public static void main(String[] args) {
        // Testando Pilha (Stack)
        System.out.println("=== Testando Pilha ===");
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Topo da Pilha: " + stack.top()); // Deve imprimir 30
        System.out.println("Removendo: " + stack.pop()); // Deve remover 30
        System.out.println("Pilha vazia? " + stack.isEmpty()); // false

        // Testando Fila (Queue)
        System.out.println("\n=== Testando Fila ===");
        Queue queue = new Queue(5);
        queue.enqueue(5);
        queue.enqueue(15);
        queue.enqueue(25);
        System.out.println("Primeiro da Fila: " + queue.peek()); // Deve imprimir 5
        System.out.println("Removendo: " + queue.dequeue()); // Deve remover 5
        System.out.println("Fila vazia? " + queue.isEmpty()); // false

        // Testando Lista Encadeada
        System.out.println("\n=== Testando Lista Encadeada ===");
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(100);
        list.add(200);
        list.add(300);
        System.out.println("Tamanho da lista: " + list.size()); // Deve imprimir 3
        System.out.println("Contém 200? " + list.contains(200)); // true
        System.out.println("Removendo 200: " + list.remove(200)); // true
        System.out.println("Contém 200? " + list.contains(200)); // false

        // Testando HashMapInt
        System.out.println("\n=== Testando HashMapInt ===");
        HashMapInt hashMap = new HashMapInt();
        hashMap.put(10);
        hashMap.put(20);
        hashMap.put(31); // Deve cair na mesma posição de 10, pois 31 % 31 == 0
        System.out.println("Contém 10? " + hashMap.contains(10)); // true
        System.out.println("Contém 31? " + hashMap.contains(31)); // true
        System.out.println("Removendo 10: " + hashMap.remove(10)); // true
        System.out.println("Contém 10? " + hashMap.contains(10)); // false
    }
}

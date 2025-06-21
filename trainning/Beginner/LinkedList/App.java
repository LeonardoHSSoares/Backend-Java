
import java.util.ArrayList;


class App {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        for (String i : list) {
            System.out.println(i);
        }
    }
}

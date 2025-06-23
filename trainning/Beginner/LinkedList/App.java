
import java.util.ArrayList;
import java.util.HashMap;

class App {

    public static void main(String[] args) {

        HashMap<Long, String> map = new HashMap<>();
        map.put(1L, "one");
        map.put(2L, "two");
        map.put(3L, "three");
        ArrayList<String> list = new ArrayList<>();
        for (Long key : map.keySet()) {
            list.add(map.get(key));
        }

        for (String value : list) {
            System.out.println(value);
        }

    }
}

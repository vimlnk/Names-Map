package app;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {

   private final Map<Integer,String> map;

    public DataHandler() {
        this.map = new DataRepository().getData();
    }

    // Метод формує виведення нумерованого переліку імен
    public String getAll() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(0);
        map.forEach((id, name) ->
                sb.append(String.format("%d) %d, %s%n",
                        count.incrementAndGet(),id, name)
        ));
        return "ALL NAMES:\n" + sb;
    }

    // Метод формує виведення імені за певним id
    public String getById(int id) {
        if (map.containsKey(id)) {
            return "NAME: id " + id + ", " +
                    map.get(id);
        } else return "No data!";
    }
}

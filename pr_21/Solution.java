import java.util.*;

public class Solution<T, K, V> {
    private T t;
    private K k;
    private V v;

    public Solution(T t, K k, V v) {
        this.t = t;
        this.k = k;
        this.v = v;
    }

    // Создание ArrayList
    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    // Создание HashSet
    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> set = new HashSet<>();
        for (T element : elements) {
            set.add(element);
        }
        return set;
    }

    // Создание HashMap
    public static <K, V> HashMap<K, V> newHashMap(K[] keys, V[] values) {
        if (keys.length != values.length) {
            throw new IllegalArgumentException("Количество ключей и значений должно совпадать");
        }
        HashMap<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }

    // Тестирование
    public static void main(String[] args) {
        // Тест newArrayList
        ArrayList<String> list = newArrayList("A", "B", "C");
        System.out.println("ArrayList: " + list);

        // Тест newHashSet
        HashSet<Integer> set = newHashSet(1, 2, 3, 2, 1);
        System.out.println("HashSet: " + set);

        // Тест newHashMap
        String[] keys = {"key1", "key2", "key3"};
        Integer[] values = {100, 200, 300};
        HashMap<String, Integer> map = newHashMap(keys, values);
        System.out.println("HashMap: " + map);

        // Создание экземпляра Solution с параметрами
        Solution<String, Integer, Double> solution =
                new Solution<>("text", 42, 3.14);
        System.out.println("Solution fields: " + solution.t + ", " + solution.k + ", " + solution.v);
    }
}
//задача 1
import java.util.*;

public class GenericConverter {
    public static <T> List<T> arrayToList(T[] array) {
        return array == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(array));
    }

    public static void main(String[] args) {
        System.out.println(arrayToList(new String[]{"Zayd", "Zoxir"}));
        System.out.println(arrayToList(new Integer[]{1, 2, 3}));
    }
}

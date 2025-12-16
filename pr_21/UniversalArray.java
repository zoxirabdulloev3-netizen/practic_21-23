//Задача 2
import java.util.Arrays;

public class UniversalArray<T> {
    private T[] array;
    public UniversalArray(T[] array) { this.array = array; }
    public T[] getArray() { return array; }
    public void setArray(T[] array) { this.array = array; }
    public String toString() { return Arrays.toString(array); }

    public static void main(String[] args) {
        System.out.println(new UniversalArray<>(new Integer[]{1, 2, 3}));
        System.out.println(new UniversalArray<>(new String[]{"x", "y"}));
    }

}

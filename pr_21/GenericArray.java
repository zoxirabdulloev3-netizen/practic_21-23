//Задача 3
import java.util.Arrays;

public class GenericArray<T> {
    private T[] data;

    public GenericArray(T[] data) {
        this.data = data;
    }

    public T getElementByIndex(int index) {
        return data[index];
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        GenericArray<String> strings = new GenericArray<>(new String[]{"A", "B", "C"});
        System.out.println(strings.getElementByIndex(1)); // B

        GenericArray<Integer> numbers = new GenericArray<>(new Integer[]{10, 20, 30});
        System.out.println(numbers.getElementByIndex(2)); // 30
    }
}
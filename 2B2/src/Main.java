import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(arr);
        Collections.reverse(list);
        System.out.println(list);
    }
}

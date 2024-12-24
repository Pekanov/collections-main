import java.util.Comparator;
import java.util.List;

public class MyCollections {

    // binarySearch для List
    public static <T> int binarySearch(List<T> list, T key) {
        return binarySearch(list, 0, list.size(), key, null);
    }

    // binarySearch для List с Comparator
    public static <T> int binarySearch(List<T> list, T key, Comparator<? super T> c) {
        return binarySearch(list, 0, list.size(), key, c);
    }

    private static <T> int binarySearch(List<T> list, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        while (fromIndex < toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            T midVal = list.get(mid);
            int cmp = (c == null) ? ((Comparable<? super T>) midVal).compareTo(key) : c.compare(midVal, key);
            if (cmp < 0) {
                fromIndex = mid + 1;
            } else if (cmp > 0) {
                toIndex = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Comparable;


class Value implements Comparable<Value>{


    private final int value;

    
    Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
    
    public String toString() {
        return String.valueOf(this.value);
    }

    private static boolean SORT_LOWER;

    public static void setSortLower() {
        SORT_LOWER = true;
    }

    public static void setSortHigher() {
        SORT_LOWER = false;
    }

    public static boolean isSortLower() {
        if (SORT_LOWER) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSortHigher() {
        if (SORT_LOWER) {
            return false;
        } else {
            return true;
        }

    }

    public int compareTo(Value o) {
            if (SORT_LOWER) {
                if (this.value < o.value) {
                    return -1;
                } else if (this.value > o.value) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (this.value < o.value) {
                    return 1;
                } else if (this.value > o.value) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
}

class MyFancyDataStructure {
    public static void main(String[] args) {
        List<Value> list = Arrays.asList(new Value(2), new Value(3), new Value(1));

        Value.setSortLower();
        Collections.sort(list);
        System.out.println(list);
        // OUTPUT: [1, 2, 3]

        Value.setSortHigher();
        Collections.sort(list);
        System.out.println(list);
        // OUTPUT: [3, 2, 1]
    }
}
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Comparable;
import java.util.Comparator;


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


    // the following method can also be done using the integer compare method but judging by the wording of the question, I think this is what is required
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


 // the following classes use the integer compare method but as shown previously I do know how to complete a comparison without it
class PreferLowerValues implements Comparator<Value> {
    public int compare(Value v1, Value v2) {
        return Integer.compare(v1.getValue(), v2.getValue());
    }
}

class PreferHigherValues implements Comparator<Value> {
    public int compare(Value v1, Value v2) {
        return Integer.compare(v2.getValue(), v1.getValue());
    }
}




class MyFancyDataStructure {
    public static void main(String[] args) {
        List<Value> list = Arrays.asList(
            new Value(2), new Value(3), new Value(1));
    
        list.sort(new PreferLowerValues());
        System.out.println(list);
        // OUTPUT: [1, 2, 3]
    
        list.sort(new PreferHigherValues());
        System.out.println(list);
        // OUTPUT: [3, 2, 1]
    }
}
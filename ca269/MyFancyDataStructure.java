import java.util.List;
import java.util.Arrays;
import java.util.Collections;


class Value{


    private final int value;

    
    Value(int value) {
        this.value = value;
    }
    
    public String ToString() {
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
}


class MyFancyDataStructure{

    public static void main(String[] args) {
        Value value1 = new Value(1);
        Value value2 = new Value(2);
        Value value3 = new Value(3);
        System.out.println(value1.ToString());
        System.out.println(value2.ToString());
        System.out.println(value3.ToString());
        Value.setSortLower(true);
        System.out.println(Value.isSortLower());
        System.out.println(Value.isSortHigher());
        Value.setSortHigher(true);
        System.out.println(Value.isSortLower());
        System.out.println(Value.isSortHigher()); 
        
        List<Value> list = Arrays.asList(
        new Value(2), new Value(3), new Value(1));

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
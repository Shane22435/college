import java.util.Scanner;

public class AlarmClock {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String alarm_time = input.nextLine();
        String[] alarm_array = alarm_time.split(" ");
        int wakey_time = Integer.parseInt(alarm_array[0]) * 100 + Integer.parseInt(alarm_array[1]);

        int n = 0;

        while (true) {

            String time = input.nextLine();
            String[] time_array = time.split(" ");
            int check_time = Integer.parseInt(time_array[0]) * 100 + Integer.parseInt(time_array[1]);

            if (check_time < wakey_time) {
                n++;
            } else {
                break;
            }

        }

        System.out.println("false alarms: " + n);

    }

}

import java.util.Scanner;


public class VowelAge {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        String name  = input.nextLine();
        int age = input.nextInt();


        char[] name_array = name.toCharArray();
        name_array[0] = Character.toLowerCase(name_array[0]);
        int n = 0;
        {
        int i = 0;
        while (i < name_array.length){

            if (name_array[i] == 'a' || name_array[i] == 'e' || name_array[i] == 'i' || name_array[i] == 'o' || name_array[i] == 'u'){

                n++;

            }
            i++;
        }
        }

        String status = "";
        if (age < 18){

            status = "a minor";

        }

        else {

            status = "an adult";

        }

        System.out.println("Hello " + name + ", you have " + n + " vowels, and you are " + status);

    }
}
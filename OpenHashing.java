import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tian on 11/20/14.
 */
public class OpenHashing {
    public static List<List<Integer>> table = new ArrayList<List<Integer>>(); //2D list
    //prints the table after insert and delete
    public static void printTable(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("ROW" + i);
            for (Integer v : table.get(i)) {
                System.out.print(" | " + v);
            }
            System.out.println();
        }
    }

    public static int getHashAddress(int value, int size) {
        return value % size; //simple integer
    }
    //Deletes a value
    public static void delete (int value, int size) {
        int address = getHashAddress(value, size);
        if (!table.get(address).contains(value)) {
            System.out.println("Value " + value + "not in the table...");
        } else {
            int index = table.get(address).indexOf(value);
            table.get(address).remove(index);
            System.out.println("Value " + value + " removed!");
        }
    }
    //Looks up a value
    public static void lookUp (int value, int size) {
        int address = getHashAddress(value, size);
        if (table.get(address).contains(value)) {
            System.out.println("Value '" + value + "' found!");
        } else {
            System.out.println("Value '" + value + "' not found...");
        }
    }
    //Inserts a value in the inner list
    public static void insert(int value, int size) {
        int address = getHashAddress(value, size);
        table.get(address).add(value);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Table Size: ");
        int size = in.nextInt(); //num values

        for (int i = 0; i < size; i++) {
            table.add(new ArrayList<Integer>());
        }

        while (true) {
            System.out.println("Enter '1' to insert, '2' to look-up, '3' to delete, or a negative number to quit: ");
            int command = in.nextInt();

            if (command < 0) {
                break;
            }

            System.out.println("Enter value: ");
            int value = in.nextInt();

            if (command == 1) {
                insert(value, size);
                printTable(size);
            } else if (command == 2) {
                lookUp(value, size);
            } else {
                delete(value, size);
                printTable(size);
            }
        }
    }
}

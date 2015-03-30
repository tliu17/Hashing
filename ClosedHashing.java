import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tian on 11/20/14.
 */
public class ClosedHashing {
    public static List<Integer> table = new ArrayList<Integer>();

    public static void printTable() {
        for (Integer v : table) {
            System.out.print(" | " + v);
        }
        System.out.print(" |\n");
    }

    public static int getHashAddress(int value, int size) {
        return value % size; //simple integer
    }

    public static void delete (int value, int size) {
        int address = getHashAddress(value, size);
        if (table.contains(value)) {
            table.remove(address);
            table.add(address, null);
            System.out.println("Value " + value + " removed!");
        } else {
            System.out.println("Value " + value + " not in the table...");
        }
    }

    public static void lookUp (int value) {
        if (table.contains(value)) {
            System.out.println("Value " + value + " found!");
        } else {
            System.out.println("Value " + value + " not found...");
        }
    }
    //Inserts a value. If position is filled, it shifts by linear probing
    public static void insert(int value, int size) {
        int address = getHashAddress(value, size);
        while (table.get(address) != null) {
            address++; //linear probing
            if (address == size) {
                address = 0;
            }
        }
        table.remove(address);
        table.add(address, value);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Table Size: ");
        int size = in.nextInt(); //num values

        for (int i = 0; i < size; i++) {
            table.add(null);
        }

        int count = 0;

        while (count < size) {
            System.out.println("Enter '1' to insert, '2' to look-up, '3' to delete, or a negative number to quit: ");
            int command = in.nextInt();

            if (command < 0) {
                break;
            }

            System.out.println("Enter value: ");
            int value = in.nextInt();

            if (command == 1) {
                insert(value, size);
                printTable();
                count++;
            } else if (command == 2) {
                lookUp(value);
            } else {
                delete(value, size);
                printTable();
                count--;
            }
        }
    }
}

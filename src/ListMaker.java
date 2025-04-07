import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String choice;

        do {
            displayList(list);
            choice = displayMenu(in);

            switch (choice.toUpperCase()) {
                case "A":
                    addItem(list, in);
                    break;
                case "D":
                    deleteItem(list, in);
                    break;
                case "I":
                    insertItem(list, in);
                    break;
                case "P":
                    displayList(list);
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?")) {
                        System.out.println("Exiting program. Bye!");
                    } else {
                        choice = "X"; // keep looping
                    }
                    break;
            }
        } while (!choice.equalsIgnoreCase("Q"));
    }

    private static String displayMenu(Scanner in) {
        System.out.println("\n=== LISTMAKER MENU ===");
        System.out.println("[A] Add Item");
        System.out.println("[D] Delete Item");
        System.out.println("[I] Insert Item");
        System.out.println("[P] Print List");
        System.out.println("[Q] Quit");
        return SafeInput.getRegExString(in, "Choose an option", "[AaDdIiPpQq]");
    }

    private static void displayList(ArrayList<String> list) {
        System.out.println("\nCurrent List:");
        if (list.isEmpty()) {
            System.out.println("[The list is empty]");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%3d: %s\n", i + 1, list.get(i));
            }
        }
    }

    private static void addItem(ArrayList<String> list, Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter item to add");
        list.add(item);
    }

    private static void deleteItem(ArrayList<String> list, Scanner in) {
        if (list.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        int index = SafeInput.getRangedInt(in, "Enter item number to delete", 1, list.size());
        list.remove(index - 1);
    }

    private static void insertItem(ArrayList<String> list, Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter item to insert");
        int index = SafeInput.getRangedInt(in, "Enter position to insert at", 1, list.size() + 1);
        list.add(index - 1, item);
    }
}

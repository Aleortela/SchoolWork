
public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine machine1 = new VendingMachine(100);
        VendingMachine machine2 = new VendingMachine(200, "Library");
        System.out.println("===== Welcome to the CSUMB Vending Machine =====");
        System.out.println(machine1);
        System.out.println("");
        System.out.println(machine2);
        System.out.println("\n=== Compare Two Machines ===");
        System.out.println(machine1.equals(machine2));
        machine1.setLocation("BIT104");
        machine1.setSerialNumber(50);
        machine1.setSerialNumber(100);
        System.out.println("\n=== Machine Reset ===");
        /*
        for machine1() we assume that a machine administrator
        resets the contents of a machine
        */
        machine1.resetItems(4, 5, 0, 6);
        machine1.addItems(1, 2, 3, 4);
        // A system admin can add items to the machine
        System.out.println(machine1); System.out.println();
        System.out.println("\n=== Buy an Item ===");
        machine1.buyItem(2);
        System.out.println("\n=== Buy another Item ===");
        if (machine1.buyItem(1, 4) == false)
        {
            System.exit(1);
        }
        System.out.println("\n=== Return Two Items ===");
        machine1.returnItem(1, 2);
        machine1.returnItem(2, 3);
        System.out.println("\n=== Buy another Item ===");
        System.out.println();
        machine1.buyItem(3, 5);
        machine1.buyItem(3, 2);
        machine1.displayReceipt();
        System.out.println("\n=== Pay for items selected. ===");
        if (machine1.pay(2.0))
        {
            System.out.println("\n=== Valid payment. ===");
        }
        else
            {
            System.out.println("\n=== Invalid payment. Try one more time. ===");
            machine1.pay(7.0);
        }
        machine1.addItems(5, 5, 5, 5);
        System.out.println("\n=== Machine Status ===");
        System.out.println(machine1);
        System.out.println("\n===== Thank you! =====");
    } }
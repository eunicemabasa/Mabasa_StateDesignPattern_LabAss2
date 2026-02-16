public class Main {
    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();

        System.out.println("=== Normal Flow ===");
        machine.selectItem("Soda");
        machine.insertCoin(1.0);
        machine.insertCoin(1.0);

        System.out.println("\n=== Invalid Dispense Attempt ===");
        machine.dispenseItem();

        System.out.println("\n=== Insert Coin Before Selection ===");
        machine.insertCoin(1.0);

        System.out.println("\n=== Out Of Order Scenario ===");
        machine.setOutOfOrder();
        machine.selectItem("Chips");
        machine.insertCoin(2.0);
        machine.dispenseItem();
    }
}

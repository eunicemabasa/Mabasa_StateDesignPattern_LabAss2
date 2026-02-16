import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private VendingMachineState currentState;

    private Map<String, Integer> inventory = new HashMap<>();
    private double balance = 0.0;
    private String selectedItem;

    // States
    private VendingMachineState idleState;
    private VendingMachineState itemSelectedState;
    private VendingMachineState dispensingState;
    private VendingMachineState outOfOrderState;

    public VendingMachine() {
        idleState = new IdleState(this);
        itemSelectedState = new ItemSelectedState(this);
        dispensingState = new DispensingState(this);
        outOfOrderState = new OutOfOrderState(this);

        currentState = idleState;

        // Sample inventory
        inventory.put("Soda", 5);
        inventory.put("Chips", 3);
    }

    // Delegation methods
    public void selectItem(String item) {
        currentState.selectItem(item);
    }

    public void insertCoin(double amount) {
        currentState.insertCoin(amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem();
    }

    public void setOutOfOrder() {
        currentState.setOutOfOrder();
    }

    // Getters & Setters
    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getIdleState() { return idleState; }
    public VendingMachineState getItemSelectedState() { return itemSelectedState; }
    public VendingMachineState getDispensingState() { return dispensingState; }
    public VendingMachineState getOutOfOrderState() { return outOfOrderState; }

    public Map<String, Integer> getInventory() { return inventory; }

    public double getBalance() { return balance; }
    public void addBalance(double amount) { balance += amount; }
    public void resetBalance() { balance = 0.0; }

    public String getSelectedItem() { return selectedItem; }
    public void setSelectedItem(String item) { selectedItem = item; }

    public void reduceInventory(String item) {
        inventory.put(item, inventory.get(item) - 1);
    }
}

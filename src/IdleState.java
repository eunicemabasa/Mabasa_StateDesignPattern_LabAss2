public class IdleState implements VendingMachineState {

    private VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem(String item) {
        if (machine.getInventory().containsKey(item) &&
                machine.getInventory().get(item) > 0) {

            machine.setSelectedItem(item);
            System.out.println("Item selected: " + item);
            machine.setState(machine.getItemSelectedState());

        } else {
            System.out.println("Item out of stock.");
        }
    }

    @Override
    public void insertCoin(double amount) {
        System.out.println("Please select item first.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("No item selected.");
    }

    @Override
    public void setOutOfOrder() {
        machine.setState(machine.getOutOfOrderState());
    }
}

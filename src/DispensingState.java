public class DispensingState implements VendingMachineState {

    private VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectItem(String item) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void insertCoin(double amount) {
        System.out.println("Currently dispensing. Cannot insert coins.");
    }

    @Override
    public void dispenseItem() {
        String item = machine.getSelectedItem();

        machine.reduceInventory(item);
        System.out.println("Dispensing: " + item);

        machine.resetBalance();
        machine.setSelectedItem(null);

        // Automatically return to Idle
        machine.setState(machine.getIdleState());
    }

    @Override
    public void setOutOfOrder() {
        machine.setState(machine.getOutOfOrderState());
    }
}

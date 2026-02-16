public interface VendingMachineState {
    void selectItem(String item);
    void insertCoin(double amount);
    void dispenseItem();
    void setOutOfOrder();
}

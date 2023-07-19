public class SmartKitchen {

    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;
    private Refrigerator iceBox;

    public SmartKitchen(CoffeeMaker brewMaster, DishWasher dishWasher, Refrigerator iceBox) {
        this.brewMaster = brewMaster;
        this.dishWasher = dishWasher;
        this.iceBox = iceBox;
    }

    private void addWater(Boolean bool){
        this.iceBox.setHasWorkToDo(bool);
    }

    private void pourMilk(Boolean bool){
        this.brewMaster.setHasWorkToDo(bool);
    }

    private void loadDishWasher(Boolean bool){
        this.dishWasher.setHasWorkToDo(bool);
    }

    private void setKitchenState(Boolean refrigeratorHasWorkToDo, boolean brewMasterHasWorkToDo, boolean dishWasherHasWorkToDo){
        addWater(refrigeratorHasWorkToDo);
        pourMilk(brewMasterHasWorkToDo);
        loadDishWasher(dishWasherHasWorkToDo);
    }

    public void doKitchenWork(){
        setKitchenState(true, true, true);
        this.iceBox.orderFood();
        this.brewMaster.brewCoffee();
        this.dishWasher.doDishWash();
    }
}

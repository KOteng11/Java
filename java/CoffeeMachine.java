package coffeemachine;

public class CoffeeMachine{
    private float coffeeQty;
    private float waterQty;
    
    private CoffeeMachine(){
        coffeeQty = 1;
        waterQty = 1;
    }
    
    private static CoffeeMachine our = null;
    
    public static CoffeeMachine getInstance(){
        if (our == null){
            our = new CoffeeMachine();
        }
        return our;
    }
}
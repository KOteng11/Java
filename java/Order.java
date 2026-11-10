package coupling;

public class Order{
    private NotificationService notificationService;
    
    public Order(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    
    public void placeOrder(){
        notificationService.sendNotification("Order placed successfully.");
    }
    
    public static void main(String[] args){
        Order order = new Order(new SmsSender());
        order.placeOrder();
    }
}
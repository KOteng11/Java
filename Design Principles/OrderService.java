import java.util.*;

public class OrderService{
    public void sendNotification(){
        NotificationFactory factory = new EmailFactory();
        Notification notification = factory.createNotification();
        notification.send();
    }
    
}
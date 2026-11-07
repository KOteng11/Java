//import java.util.List;

public interface NotificationFactory{
        Notification createNotification();
    
    /**
    public static List<Notification> sendNotification(List<String> types){
        List<Notification> notifications = new ArrayList<>();
        
        for(String type : types){
            if (type.equals("EMAIL")){
                notifications.add(new EmailNotification());
            }else if (type.equals("SMS")){
                notifications.add(new SmsNotification());
            }
            throw new IllegalArgumentException("Invalid Type.");            
        }
    }
    */
}
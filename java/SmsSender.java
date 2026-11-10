package coupling;

public class SmsSender implements NotificationService{
    public void sendNotification(String msg){
        System.out.println("SMS message: " + msg);
    }
}
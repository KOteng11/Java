public class SmsFactory implements NotificationFactory{
    public Notification createNotification(){
        return new SmsNotification();
    }
}
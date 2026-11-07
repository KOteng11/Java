public class EmailFactory implements NotificationFactory{
    public Notification createNotification(){
        return new EmailNotification();
    }
}
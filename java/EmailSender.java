package coupling;

public class EmailSender implements NotificationService{
    public void sendNotification(String msg){
        System.out.println("Sending email: " + msg);
    }
}
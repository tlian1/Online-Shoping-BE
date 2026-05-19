package StreamAPI;

public class DependencyInversion {
}

interface Sender {
    void  send(String msg);
}

class EmailSender2 implements Sender{
    public void send(String msg) {}
}

class NotifyService2{
    private final Sender sender;

    public  NotifyService2(Sender sender) {this.sender = sender;}
    
    void notify(String msg){sender.send(msg);}
}

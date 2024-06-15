import java.util.concurrent.TimeUnit;

public class TestWaiting {
    public static void main(String[] args) {

        WaitingMessege waitingMessege = new WaitingMessege();
        try {
			TimeUnit.SECONDS.sleep(1);
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
        waitingMessege.messege(1);
    }
}

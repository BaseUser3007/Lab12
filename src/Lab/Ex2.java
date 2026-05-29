package Lab;

import java.time.LocalTime;

public class Ex2 {
    static void main(String[] args) {
         new Thread(() -> {
            for (int i = 1; i <= 10; i++){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

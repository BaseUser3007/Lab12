package Lab;

public class Ex3 {
    static void main(String[] args) {
         new Thread(() -> {
            for (int i = 1; i <= 10; i +=2){
                System.out.println(i);
                //Не удалять из-за этого может выводить в разнабой из-за скорости
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 2; i <= 10; i += 2){
                System.out.println(i);
                //Не удалять из-за этого может выводить в разнабой из-за скорости
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

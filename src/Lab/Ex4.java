package Lab;

public class Ex4 {
    static void main(String[] args) {
        for (int i = 1; i <= 10; i++){
            final int n = i;
            new Thread(() -> {
                System.out.println("Поток № " + n);
            }).start();
        }
    }
}

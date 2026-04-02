public class KioskCoffee {

    private static final double IDK = 15.0;

    public static void main(String[] args) {

        double price = 15000;
        int i = 0;

        while (true) {
            i++;

            price = price - calculateDiscount(price, IDK);
            System.out.println(i + "번째 할인 후 금액 : " + price);

            if (price < 1) {
                System.out.println(i + "번째에 종료");
                break;
            }
        }

    }

    private static double calculateDiscount(double price, double rate) {
        return (price * rate) / 100;
    }

}
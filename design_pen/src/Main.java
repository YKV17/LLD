// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Ink ink = new Ink(InkColor.BLUE);
        Nib nib = new Nib(2, "Copper");
        Refill refill = new BallRefill(ink, nib, 100);
        Pen ballPen = new Ball("Hyper", "Cello", 10, ClosingType.CAP, refill, ClosingStrategyFactory.getClosingStrategyFromType(ClosingType.CAP));

        System.out.println(ballPen.getName());
        System.out.println(ballPen.getBrand());
        System.out.println(ballPen.getPrice());
        System.out.println(ballPen.getPenType());
        System.out.println(ballPen.getClosingType());

        ballPen.write();
        ballPen.close();
        ballPen.getColor();
        ballPen.getNibRadius();
        ballPen.getInkLevel();

    }
}
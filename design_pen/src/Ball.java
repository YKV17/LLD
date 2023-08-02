public class Ball extends Pen{

    private Refill refill;

    Ball(String name, String brand, int price, ClosingType closingType, Refill refill, ClosingStrategy closingStrategy) {
        super(name, brand, price, PenType.BALL, closingType, closingStrategy);
        this.refill = refill;
    }

    public Refill getRefill() {
        return refill;
    }

    public void setRefill(Refill refill) {
        this.refill = refill;
    }

    @Override
    void write() {
        System.out.println("Ball pen is writing");
    }

    @Override
    void getColor() {
        System.out.println(refill.getInk().getColor());
    }

    @Override
    void getNibRadius() {
        System.out.println(refill.getNib().getRadius());
    }

    @Override
    void getInkLevel() {
        System.out.println(refill.getLevel());
    }
}

public class Gell extends Pen{

    private Refill refill;

    Gell(String name, String brand, int price, PenType penType, ClosingType closingType, GellRefill refill, ClosingStrategy closingStrategy) {
        super(name, brand, price, penType, closingType, closingStrategy);
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
        System.out.println("Gell pen is writing");
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

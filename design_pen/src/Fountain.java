public class Fountain extends Pen {

    private Ink ink;

    private Nib nib;
    private int level;

    Fountain(String name, String brand, int price, PenType penType, ClosingType closingType, Ink ink, int level, Nib nib, ClosingStrategy closingStrategy) {
        super(name, brand, price, penType, closingType, closingStrategy);
        this.ink = ink;
        this.level = level;
        this.nib = nib;
    }

    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    @Override
    void write() {
        System.out.println("Fountain pen is writing");
    }

    @Override
    void getColor() {
        System.out.println(ink.getColor());
    }

    @Override
    void getNibRadius() {
        System.out.println(nib.getRadius());
    }

    @Override
    void getInkLevel() {
        System.out.println(level);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Nib getNib() {
        return nib;
    }

    public void setNib(Nib nib) {
        this.nib = nib;
    }
}

abstract class Refill {
    private Ink ink;

    private Nib nib;

    private int level;

    private RefillType type;

    Refill(Ink ink, Nib nib, int level, RefillType refillType){
        this.ink = ink;
        this.nib = nib;
        this.level = level;
        this.type = refillType;
    }

    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public Nib getNib() {
        return nib;
    }

    public void setNib(Nib nib) {
        this.nib = nib;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public RefillType getType() {
        return type;
    }

    public void setType(RefillType type) {
        this.type = type;
    }
}

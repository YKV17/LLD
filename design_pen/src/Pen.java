abstract class Pen {
    private String name;
    private String brand;
    private int price;
    private PenType penType;
    private ClosingType closingType;
    private ClosingStrategy closingStrategy;

    Pen(String name, String brand, int price, PenType penType, ClosingType closingType, ClosingStrategy closingStrategy){
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.penType = penType;
        this.closingType = closingType;
        this.closingStrategy = closingStrategy;
    }

    abstract void write();

    abstract void getColor();
    abstract void getNibRadius();
    abstract void getInkLevel();

    public void close(){
        closingStrategy.close();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PenType getPenType() {
        return penType;
    }

    public void setPenType(PenType penType) {
        this.penType = penType;
    }

    public ClosingType getClosingType() {
        return closingType;
    }

    public void setClosingType(ClosingType closingType) {
        this.closingType = closingType;
    }
}

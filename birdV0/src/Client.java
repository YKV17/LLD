public class Client {
    public static void main(String[] args) {
        Bird sparrow = new Bird();
        sparrow.setName("Sparrow");
        sparrow.setColor("Brown");
        sparrow.setAge(4);
        sparrow.setType("bird");
        sparrow.setWeight(10);

        sparrow.fly();
    }
}

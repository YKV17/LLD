
public class CapCloseStrategy implements ClosingStrategy {
    @Override
    public void close() {
        System.out.println("Pen closing using Cap Closing Strategy");
    }
}

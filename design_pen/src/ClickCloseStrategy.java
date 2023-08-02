public class ClickCloseStrategy implements ClosingStrategy{
    @Override
    public void close() {
        System.out.println("Pen closing using Click Closing Strategy");
    }
}

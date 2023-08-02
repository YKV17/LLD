public class ClosingStrategyFactory {

    public static ClosingStrategy getClosingStrategyFromType(ClosingType closingType){
        ClosingStrategy closingStrategy = null;
        switch (closingType){
            case CAP:
                closingStrategy = new CapCloseStrategy();
                break;

            case CLICK: {
                closingStrategy = new ClickCloseStrategy();
                break;
            }
        }
        return closingStrategy;
    }

}

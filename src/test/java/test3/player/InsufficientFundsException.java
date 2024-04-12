package test3.player;

//
public final class InsufficientFundsException extends Exception {
    private final int missingFunds;

    //
    public InsufficientFundsException(int missingFunds) {
        super("Insufficient funds exception");
        this.missingFunds = missingFunds;
    }

    //
    public int getMissingFunds() {
        return missingFunds;
    }
}
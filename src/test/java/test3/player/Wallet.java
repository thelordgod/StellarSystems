package test3.player;

//
public class Wallet {
    private int money;

    //
    protected Wallet(int money) {
        this.money = money;
    }

    //
    public int getMoney() {
        return money;
    }

    //adds money; throws an exception, if negative result
    public void addMoney(int money) throws InsufficientFundsException {
        int result = this.money + money;
        if (result < 0) {
            throw new InsufficientFundsException(-result);
        } else {
            this.money = result;
        }
    }

    //subtracts money; throws an exception, if negative result
    public void subtractMoney(int money) throws InsufficientFundsException {
        this.addMoney(-money);
    }
}
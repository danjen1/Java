
public class CashRegister {

    private double cashInRegister;
    private int economicalSold;
    private int gourmetSold;
    private static final double PRICE_OF_ECONOMICAL = 2.5;
    private static final double PRICE_OF_GOURMET = 4.0;

    public CashRegister() {
        this.cashInRegister = 1000;
    }

    public double payEconomical(double cashGiven) {
        if (cashGiven >= PRICE_OF_ECONOMICAL) {
            this.cashInRegister += PRICE_OF_ECONOMICAL;
            this.economicalSold++;
            return cashGiven - PRICE_OF_ECONOMICAL;
        }
        return cashGiven;
    }

    public double payGourmet(double cashGiven) {
        if (cashGiven >= PRICE_OF_GOURMET) {
            this.cashInRegister += PRICE_OF_GOURMET;
            this.gourmetSold++;
            return cashGiven - PRICE_OF_GOURMET;
        }
        return cashGiven;
    }

    public boolean payEconomical(LyyraCard card) {
        if (card.balance() >= PRICE_OF_ECONOMICAL) {
            card.pay(PRICE_OF_ECONOMICAL);
            this.economicalSold++;
            return true;
        }
        return false;
    }

    public boolean payGourmet(LyyraCard card) {
        if (card.balance() >= PRICE_OF_GOURMET) {
            card.pay(PRICE_OF_GOURMET);
            this.gourmetSold++;
            return true;
        }
        return false;
    }

    public void loadMoneyToCard(LyyraCard card, double sum) {
        if (sum > 0) {
            this.cashInRegister += sum;
            card.loadMoney(sum);
        }
    }

    public String toString() {
        return "money in register " + cashInRegister + " economical lunches sold: " + economicalSold + " gourmet lunches sold: " + gourmetSold;
    }
}

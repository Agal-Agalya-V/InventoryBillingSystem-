package javaassignment_2;

public class PremiumCustomer extends Customer {
    private int rewardPoints;

    public PremiumCustomer(String id, String name) {
        super(id, name);
        this.rewardPoints = 0;
    }

    @Override
    public boolean isPremium() {
        return true;
    }

    public void addPoints(double amountSpent) {
        rewardPoints += (int)(amountSpent / 100);
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public double applyDiscount() {
        if (rewardPoints >= 200) {
            int discountUnits = rewardPoints / 100;
            rewardPoints -= discountUnits * 100;
            return discountUnits * 10;
        }
        return 0;
    }
}

package arrays.medium;

// https://leetcode.com/problems/simple-bank-system/description/
// 2043. Simple Bank System
class Bank {

    long[] accounts;
    int cnt;

    public Bank(long[] balance) {
        this.accounts = balance;
        this.cnt = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > cnt || account2 > cnt) {
            return false;
        }

        if (accounts[idx(account1)] < money)
            return false;

        accounts[idx(account1)] -= money;
        accounts[idx(account2)] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (outOfRange(account))
            return false;
        accounts[idx(account)] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (outOfRange(account))
            return false;

        if (accounts[idx(account)] < money)
            return false;

        accounts[idx(account)] -= money;
        return true;
    }

    private int idx(int account) {
        return account - 1;
    }

    boolean outOfRange(int account) {
        return idx(account) >= cnt;
    }
}
package hello.hellospring.domain;

public class Account {
    public String getaccountName() {
        return accountName;
    }

    public void setaccountName(String accountName) {
        this.accountName = accountName;
    }

    private String accountName;

    public int getNowBalance() {
        return nowBalance;
    }

    public void setNowBalance(int nowBalance) {
        this.nowBalance = nowBalance;
    }

    private int nowBalance;

}

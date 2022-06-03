package hello.hellospring.repository;

import hello.hellospring.domain.Account;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MemoryAccountRepository implements AccountRepository {

    private static Map<String, Integer> store = new HashMap<>();


    @Override
    public Account NowState(Account account) {
        if (store.size() == 0) {
            account.setaccountName("계좌 미생성");
            account.setNowBalance(0);
            return account;
        }
        account.setNowBalance(store.get(account.getaccountName()));
        return account;
    }

    @Override
    public Account Create(Account account) {
        if (store.containsKey(account.getaccountName())){
            account.setNowBalance(store.get(account.getaccountName()));
            return account;
        }
        store.put(account.getaccountName(), 0);
        account.setNowBalance(0);
        return account;
    }

    @Override
    public Account Deposit(Account account) {
        int sum = store.get(account.getaccountName())+ account.getNowBalance();
        store.put(account.getaccountName(),sum);
        account.setNowBalance(store.get(account.getaccountName()));
        return account;
    }

    @Override
    public Account Withdraw(Account account) {
        int sum = 0;
        if(store.get(account.getaccountName()) > account.getNowBalance()) {
            sum = store.get(account.getaccountName()) - account.getNowBalance();
        }
        store.put(account.getaccountName(),sum);
        account.setNowBalance(store.get(account.getaccountName()));
        return account;
    }

    @Override
    public Map<String, Integer> ListStore() {
        return store;
    }

    @Override
    public Map<String,String> ListStore2() {
        Map<String, String> result = new HashMap<>();
        AtomicInteger a = new AtomicInteger();
        store.forEach((s,b)->result.put("num"+ a.getAndIncrement(),s));


    return result;
    }


}

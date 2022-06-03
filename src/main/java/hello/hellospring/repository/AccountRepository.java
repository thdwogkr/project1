package hello.hellospring.repository;

import hello.hellospring.domain.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AccountRepository {

    Account NowState(Account account);
    Account Create(Account account);

    Account Deposit(Account account);

    Account Withdraw(Account account);

//    Account Change(Account account);

    Map<String, Integer> ListStore();

    Map<String,String> ListStore2();
}

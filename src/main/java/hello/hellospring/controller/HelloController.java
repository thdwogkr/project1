package hello.hellospring.controller;

import hello.hellospring.domain.Account;
import hello.hellospring.repository.MemoryAccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    Account account = new Account();
    MemoryAccountRepository memoryAccountRepository = new MemoryAccountRepository();


    @GetMapping("top")
    @ResponseBody
    public Account top(@RequestParam("accountName") String accountName ) {
        account.setaccountName(accountName);
        return memoryAccountRepository.NowState(account);
    }

    @GetMapping("create")
    @ResponseBody
    public Account create(@RequestParam("accountName") String accountName) {
        account.setaccountName(accountName);
        return memoryAccountRepository.Create(account);
    }

    @GetMapping("deposit")
    @ResponseBody
    public Account deposit(@RequestParam("accountName") String accountName,@RequestParam("addBalance") int nowBalance ) {
        account.setaccountName(accountName);
        account.setNowBalance(nowBalance);
        return memoryAccountRepository.Deposit(account);
    }

    @GetMapping("withdraw")
    @ResponseBody
    public Account withdraw(@RequestParam("accountName") String accountName,@RequestParam("delBalance") int nowBalance ) {
        account.setaccountName(accountName);
        account.setNowBalance(nowBalance);
        return memoryAccountRepository.Withdraw(account);
    }

    @GetMapping("change1")
    @ResponseBody
    public Map<String, Integer> change1() {
        return memoryAccountRepository.ListStore();
    }

    @GetMapping("change2")
    @ResponseBody
    public Map<String,String> change2() {
        return memoryAccountRepository.ListStore2();
    }









    static class Hello {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

    }
}

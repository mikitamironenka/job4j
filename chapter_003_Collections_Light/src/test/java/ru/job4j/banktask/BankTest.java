package ru.job4j.banktask;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        User userOne = new User("1", "hb001");
        bank.addUser(userOne);
        assertThat(bank.getStore().containsKey(userOne), is(true));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User userOne = new User("1", "hb001");
        bank.addUser(userOne);
        bank.deleteUser(userOne);
        assertThat(bank.getStore().containsKey(userOne), is(false));
    }

    @Test
    public void whenAddAccountToUserAccountAdds() {
        Bank bank = new Bank();
        User userOne = new User("1", "hb001");
        Account accountOne = new Account(1000.0, "123456");
        bank.addUser(userOne);
        bank.addAccountToUser(userOne.getPassport(), accountOne);
        assertThat(bank.getStore().get(userOne).size(), is(1));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        Bank bank = new Bank();
        User userOne = new User("1", "hb001");
        bank.addUser(userOne);
        Account accountOne = new Account(1000.0, "123456");
        bank.addAccountToUser(userOne.getPassport(), accountOne);
        bank.deleteAccountFromUser(userOne.getPassport(), accountOne);
        assertThat(bank.getStore().get(userOne).size(), is(0));
    }

    @Test
    public void whenGetUserAccounts() {
        Bank bank = new Bank();
        User userOne = new User("1", "hb001");
        bank.addUser(userOne);
        Account accountOne = new Account(1000.0, "123456");
        Account accountTwo = new Account(100.0, "1234567");
        bank.addAccountToUser(userOne.getPassport(), accountOne);
        bank.addAccountToUser(userOne.getPassport(), accountTwo);
        List<Account> result = bank.getUserAccounts(userOne.getPassport());
        List<Account> checked = new ArrayList<>();
        checked.add(accountOne);
        checked.add(accountTwo);
        assertThat(result, is(checked));
    }

    @Test
    public void whenTransferMoneySucceed() {
        Bank bank = new Bank();
        User userOne = new User("1", "hb001");
        Account accountOne = new Account(1000.0, "123456");
        Account accountTwo = new Account(100.0, "1234567");
        bank.addUser(userOne);
        bank.addAccountToUser(userOne.getPassport(), accountOne);
        bank.addAccountToUser(userOne.getPassport(), accountTwo);
        boolean result = bank.transferMoney(userOne.getPassport(), accountOne.getRequisites(), userOne.getPassport(), accountTwo.getRequisites(), 500);
        double moneyOnAccountOne = bank.getStore().get(userOne).get(bank.getStore().get(userOne).indexOf(accountOne)).getValue();
        double moneyOnAccountTwo = bank.getStore().get(userOne).get(bank.getStore().get(userOne).indexOf(accountTwo)).getValue();
        assertThat(result, is(true));
        assertThat(moneyOnAccountOne, is(500.0));
        assertThat(moneyOnAccountTwo, is(600.0));
    }


    @Test
    public void whenTransferMoneyFailedBecauseCantFindAccount() {
        Bank bank = new Bank();
        User userOne = new User("1", "hb001");
        Account accountOne = new Account(1000.0, "123456");
        Account accountTwo = new Account(100.0, "1234567");
        bank.addUser(userOne);
        bank.addAccountToUser(userOne.getPassport(), accountOne);
        boolean result = bank.transferMoney(userOne.getPassport(), accountTwo.getRequisites(), userOne.getPassport(), accountOne.getRequisites(), 500);
        assertThat(result, is(false));
    }

    @Test
    public void whenTransferMoneyFailedBecauseNotEnoughMoney() {
        Bank bank = new Bank();
        User userOne = new User("1", "hb001");
        Account accountOne = new Account(100.0, "123456");
        Account accountTwo = new Account(100.0, "1234567");
        bank.addUser(userOne);
        bank.addAccountToUser(userOne.getPassport(), accountOne);
        bank.addAccountToUser(userOne.getPassport(), accountTwo);
        boolean result = bank.transferMoney(userOne.getPassport(), accountOne.getRequisites(), userOne.getPassport(), accountTwo.getRequisites(), 500);
        assertThat(result, is(false));
    }
}
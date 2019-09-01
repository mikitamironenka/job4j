package ru.job4j.banktask;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bank {

    private Map<User, List<Account>> store = new TreeMap<>();

    public Map<User, List<Account>> getStore() {
        return store;
    }

    /**
     * The method add user to map
     * @param user
     */
    public void addUser(User user) {
        this.store.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * The method delete user from map
     * @param user
     */
    public void deleteUser(User user) {
        this.store.remove(user);
    }

    /**
     * The method add account to user
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        User user = getUserFromMapByPassword(passport);
        if (user != null) {
            this.store.get(user).add(account);
        }
    }

    /**
     * The method delete account from user
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User user = getUserFromMapByPassword(passport);
        if (user != null) {
            this.store.get(user).remove(account);
        }
    }

    /**
     * The method returns list of user's accounts
     * @param passport
     * @return list of user's accounts
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        User user = getUserFromMapByPassword(passport);
        if (user != null) {
            for (Account account : this.store.get(user)) {
                result.add(account);
            }
        }
        return result;
    }

    /**
     * The method for transfer money from one account to another
     * @param srcPassport
     * @param srcRequisite
     * @param dstPassport
     * @param dstRequisite
     * @return boolean value - is operation worked or failed (not enough money or account is not found)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean result;
        Account srcAccount = getAccountByPassportAndRequisite(srcPassport, srcRequisite);
        Account dstAccount = getAccountByPassportAndRequisite(dstPassport, dstRequisite);;
        if (srcAccount == null) {
            result = false;
        } else if (srcAccount.getValue() < amount) {
            result = false;
        } else {
            double moneyOnSrcAccount = srcAccount.getValue();
            double moneyOnDstAccount = dstAccount.getValue();
            srcAccount.setValue(moneyOnSrcAccount - amount);
            dstAccount.setValue(moneyOnDstAccount + amount);
            result = true;
        }
        return result;
    }

    private User getUserFromMapByPassword(String passport) {
        User user = null;
        List<User> users = new ArrayList<User>(store.keySet());
        for (User tmp : users) {
            if (tmp.getPassport().equals(passport)) {
                user = tmp;
            }
        }
        return user;
    }

    private Account getAccountByRequisite(User user, String requisite) {
        Account account = null;
        for (Account tmp : this.store.get(user)) {
            if (tmp.getRequisites().equals(requisite)) {
                account = tmp;
            }
        }
        return account;
    }

    private Account getAccountByPassportAndRequisite(String passport, String requisite) {
        Account result = null;
        User user = null;
        List<User> users = new ArrayList<User>(store.keySet());
        for (User tmp : users) {
            if (tmp.getPassport().equals(passport)) {
                user = tmp;
            }
        }
        for (Account account : this.store.get(user)) {
            if (account.getRequisites().equals(requisite)) {
                result = account;
            }
        }
        return result;
    }
}

package ru.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Bank system.
 */
public class Bank {
    /**
     * Bank map.
     */
    private final Map<User, List<Account>> bankMap;

    /**
     * Constructor.
     * @param bankMap - bank map
     */
    public Bank(Map<User, List<Account>> bankMap) {
        this.bankMap = bankMap;
    }

    /**
     * Adding new User.
     * @param user - new User
     */
    public void addUser(User user) {
        if (!bankMap.containsKey(user)) {
            bankMap.put(user, new ArrayList<>());
        }
    }

    /**
     * Deleting User.
     * @param user for deleting
     */
    public void deleteUser(User user) {
        bankMap.remove(user);
    }

    /**
     * Adding user Account.
     * @param user needed to add Account
     * @param account - new Account
     */
    public void addAccountToUser(User user, Account account) {
        List<Account> accountList = bankMap.get(user);
        if (accountList != null && !accountList.contains(account)) {
            accountList.add(account);
        }
    }

    /**
     * Deleting user Account.
     * @param user needed to delete Account
     * @param account - existing Account
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> accountList = bankMap.get(user);
        if (accountList != null) {
            accountList.remove(account);
        }
    }

    /**
     * List<Account> getter.
     * @param user with accounts
     * @return list with user accounts.
     */
    public List<Account> getUserAccounts(User user) {
        return bankMap.get(user);
    }

    /**
     * Transfer money from src account to dst account.
     * @param srcUser user
     * @param srcAccount user account
     * @param dstUser user
     * @param dstAccount user account
     * @param amount - transfer value
     * @return is operation done
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean result = false;
        Account srcUserAccount;
        Account dstUserAccount;
        try {
            List<Account> srcUserList = bankMap.get(srcUser);
            srcUserAccount = srcUserList.get(srcUserList.indexOf(srcAccount));
            List<Account> dstUserList = bankMap.get(dstUser);
            dstUserAccount = dstUserList.get(dstUserList.indexOf(dstAccount));
            double value = srcUserAccount.takeValue(amount);
            if (value > 0) {
                dstUserAccount.addValue(value);
                result = true;
            }
        } catch (NullPointerException e) {
            System.out.print("Пользователей с введенными данными не сущетсвует.");
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Указанных номеров счетов нет в базе.");
        }
        return result;
    }
}

/**
 * Test bank system.
 *
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.bank;

import org.junit.Test;
import ru.job4j.bank.Account;
import ru.job4j.bank.Bank;
import ru.job4j.bank.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test class.
 */
public class BankTest {
    /**
     * Test method.
     */
    @Test
    public void whenAddNewUserThenSizeMapIsOne() {
        Map<User, List<Account>> bankMap = new HashMap<>();
        Bank bank = new Bank(bankMap);
        bank.addUser(new User("NotMe", 111111));
        int result = bankMap.size();
        int expected = 1;
        assertThat(result, is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenDeleteUserThenSizeMapIsZero() {
        Map<User, List<Account>> bankMap = new HashMap<>();
        User user = new User("NotMe", 111111);
        Bank bank = new Bank(bankMap);
        bank.addUser(user);
        bank.deleteUser(user);
        int result = bankMap.size();
        int expected = 0;
        assertThat(result, is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenAddAccountThenAccountListSizeIsOne() {
        Map<User, List<Account>> bankMap = new HashMap<>();
        User user = new User("NotMe", 111111);
        Bank bank = new Bank(bankMap);
        bank.addUser(user);
        bank.addAccountToUser(user, new Account(12345678));
        int result = bank.getUserAccounts(user).size();
        int expected = 1;
        assertThat(result, is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenDeleteAccountThenAccountListSizeIsZero() {
        Map<User, List<Account>> bankMap = new HashMap<>();
        User user = new User("NotMe", 111111);
        Account userAccount = new Account(12345678);
        Bank bank = new Bank(bankMap);
        bank.addUser(user);
        bank.addAccountToUser(user, userAccount);
        bank.deleteAccountFromUser(user, userAccount);
        int result = bank.getUserAccounts(user).size();
        int expected = 0;
        assertThat(result, is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenTransferMoneyThenGetTrue() {
        Map<User, List<Account>> bankMap = new HashMap<>();
        User srcUser = new User("srcName", 111111);
        Account srcUserAccount = new Account(12345678);
        srcUserAccount.addValue(1000);
        Bank bank = new Bank(bankMap);
        bank.addUser(srcUser);
        bank.addAccountToUser(srcUser, srcUserAccount);
        User dstUser = new User("dstName", 222222);
        Account dstUserAccount = new Account(12345678);
        dstUserAccount.addValue(100);
        bank.addUser(dstUser);
        bank.addAccountToUser(dstUser, dstUserAccount);
        boolean result = bank.transferMoney(srcUser, srcUserAccount, dstUser, dstUserAccount, 900);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenTransferMoneyThenGetFalse() {
        Map<User, List<Account>> bankMap = new HashMap<>();
        User srcUser = new User("srcName", 111111);
        Account srcUserAccount = new Account(12345678);
        srcUserAccount.addValue(1000);
        Bank bank = new Bank(bankMap);
        bank.addUser(srcUser);
        bank.addAccountToUser(srcUser, srcUserAccount);
        User dstUser = new User("dstName", 222222);
        Account dstUserAccount = new Account(12345678);
        dstUserAccount.addValue(100);
        bank.addUser(dstUser);
        bank.addAccountToUser(dstUser, dstUserAccount);
        boolean result = bank.transferMoney(srcUser, srcUserAccount, dstUser, dstUserAccount, 1500);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenTransferMoneyThenGetNullPointerEMessage() {
        Map<User, List<Account>> bankMap = new HashMap<>();
        User srcUser = new User("srcName", 111111);
        Account srcUserAccount = new Account(12345678);
        srcUserAccount.addValue(1000);
        Bank bank = new Bank(bankMap);
        bank.addUser(srcUser);
        bank.addAccountToUser(srcUser, srcUserAccount);
        User dstUser = new User("dstName", 222222);
        Account dstUserAccount = new Account(12345678);
        srcUserAccount.addValue(100);
        bank.addUser(dstUser);
        bank.addAccountToUser(dstUser, dstUserAccount);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        bank.transferMoney(srcUser, srcUserAccount, new User("SomeName", 1234567), dstUserAccount, 1500);
        String result = baos.toString();
        String expected = "Пользователей с введенными данными не сущетсвует.";
        assertThat(result, is(expected));
    }

    /**
     * Test method.
     */
    @Test
    public void whenTransferMoneyThenGetIndexOutOfBoundEMessage() {
        Map<User, List<Account>> bankMap = new HashMap<>();
        User srcUser = new User("NotMe", 111111);
        Account srcUserAccount = new Account(12345678);
        srcUserAccount.addValue(1000);
        Bank bank = new Bank(bankMap);
        bank.addUser(srcUser);
        bank.addAccountToUser(srcUser, srcUserAccount);
        User dstUser = new User("NotMe", 111111);
        Account dstUserAccount = new Account(12345678);
        srcUserAccount.addValue(100);
        bank.addUser(dstUser);
        bank.addAccountToUser(dstUser, new Account(98765432));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        bank.transferMoney(srcUser, srcUserAccount, dstUser, new Account(555555), 900);
        String result = baos.toString();
        String expected = "Указанных номеров счетов нет в базе.";
        assertThat(result, is(expected));
    }
}

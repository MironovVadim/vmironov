/**
 * Account in bank system.
 *
 * @author Vadim Moronov (Mironov6292@gmail.ru/Multik6292@mail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.bank;

/**
 * User account.
 */
public class Account {
    /**
     * Money.
     */
    private double value = 0;
    /**
     * Number of account.
     */
    private int requisites;

    /**
     * Constructor.
     * @param requisites - number of account
     */
    public Account(int requisites) {
        this.requisites = requisites;
    }

    /**
     * Adding money.
     * @param value of money.
     */
    public void addValue(double value) {
        this.value += value;
    }

    /**
     * Taking money from account.
     * @param value of money
     * @return value of money
     */
    public double takeValue(double value) {
        double result = 0;
        if (this.value >= value) {
            this.value -= value;
            result = value;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        return requisites;
    }
}

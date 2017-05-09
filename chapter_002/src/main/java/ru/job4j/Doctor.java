/**
 * Class Doctor.
 *
 * @author Vadim Mironov (multik6292@mail.ru/mironov6292@gmail.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.job4j;

/**
 * Class with Doctor person.
 */
public class Doctor extends Profession {
    /**
     * Clients in a day.
     */
    private String[] clientsInADay = new String[10];
    /**
     * Number of next client in clientsInADay.
     */
    private int numberOfNextClient = 0;
    /**
     * number of a new client.
     */
    private int numberOfClientInMassif = 0;
    /**
     * Constructor.
     * @param name - name of doctor
     * @param surname - surname of doctor
     * @param speciality - speciality of doctor
     */
    public Doctor(String name, String surname, String speciality) {
        super(name, surname, speciality);
    }
    /**
     * Service next client.
     * @return String - string with details.
     */
    public String serveNextClient() {
        if (numberOfNextClient >= clientsInADay.length || clientsInADay[numberOfNextClient] == null) {
            return "Все излечены, пора идти домой.";
        }
        return String.format("Доктор %s %s вылечил пациента %s", getName(), getSurname(), clientsInADay[numberOfNextClient++]);
    }
    /**
     * Adding next client.
     * @param client - new client.
     * @return boolean - if client is added - true, else - false.
     */
    public boolean addNewClient(String client) {
        if (numberOfClientInMassif == clientsInADay.length) {
            return false;
        }
        clientsInADay[numberOfClientInMassif++] = client;
        return true;
    }
}

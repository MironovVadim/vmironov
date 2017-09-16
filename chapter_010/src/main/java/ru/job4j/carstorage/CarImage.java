package ru.job4j.carstorage;

import java.util.Arrays;

public class CarImage {
    /**
     * Id.
     */
    private int id;
    /**
     * Image.
     */
    private byte[] image;

    /**
     * Id getter.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Id setter
     * @param id - id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Image getter.
     * @return image.
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Image setter.
     * @param image - image.
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CarImage carImage = (CarImage) o;

        if (id != carImage.id) {
            return false;
        }
        return Arrays.equals(image, carImage.image);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}

package ru.job4j.carstorage.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import sun.misc.BASE64Encoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;

/**
 * Car image.
 */
@JsonAutoDetect
@Entity
@Table(name = "images")
public class Image {
    /**
     * Id.
     */
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    /**
     * Image.
     */
    @Column(name = "image")
    private byte[] image;

    /**
     * Default constructor.
     */
    public Image() {
    }

    /**
     * Second constructor with initialization fields.
     * @param image of car.
     */
    public Image(byte[] image) {
        this.image = image;
    }

    /**
     * Id getter.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Id setter.
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
     * Base64 image format getter.
     * @return Base64 image.
     */
    @JsonProperty("image")
    public String get64BaseImage() {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(image);
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

        Image image = (Image) o;

        if (id != image.id) {
            return false;
        }
        return Arrays.equals(this.image, image.image);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
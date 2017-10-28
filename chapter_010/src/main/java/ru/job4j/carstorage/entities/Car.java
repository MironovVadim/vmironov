package ru.job4j.carstorage.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Car.
 */
@JsonFilter("carFilter")
@JsonAutoDetect
@Entity
@Table(name = "cars")
@Where(clause = "is_sold = false")
public class Car {
    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    /**
     * Car owner.
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    /**
     * Mark.
     */
    @Column(name = "mark")
    private String mark;
    /**
     * Model.
     */
    @Column(name = "model")
    private String model;
    /**
     * Release year.
     */
    @Column(name = "release_year")
    private int releaseYear;
    /**
     * Mileage.
     */
    @Column(name = "mileage")
    private int mileage;
    /**
     * Body type.
     */
    @Column(name = "body_type")
    private String bodyType;
    /**
     * Color.
     */
    @Column(name = "color")
    private String color;
    /**
     * Engine capacity.
     */
    @Column(name = "engine_capacity")
    private double engineCapacity;
    /**
     * Engine type.
     */
    @Column(name = "engine_type")
    private String engineType;
    /**
     * Power.
     */
    @Column(name = "power")
    private int power;
    /**
     * Cost.
     */
    @Column(name = "cost")
    private int cost;
    /**
     * Is car sold.
     */
    @JsonIgnore
    @Column(name = "is_sold")
    private boolean sold;
    /**
     * Description.
     */
    @Column(name = "description")
    private String description;
    /**
     * Created date.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date created;
    /**
     * Comments.
     */
    @OrderBy("created asc")
    @JoinColumn(name = "car_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Comment.class)
    private Set<Comment> comments;
    /**
     * Images.
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Image.class)
    @JoinColumn(name = "car_id")
    private List<Image> images;
    /**
     * Addition field to know is current user of car storage a owner of current car.
     */
    @Transient
    private boolean owner;

    /**
     * Default constructor.
     */
    public Car() {
    }

    /**
     * Constructor with initialization fields.
     * @param mark of car
     * @param model of car
     * @param releaseYear of car
     * @param mileage of car
     * @param bodyType of car
     * @param color of car
     * @param engineCapacity of car
     * @param engineType of car
     * @param power of car
     * @param cost of car
     * @param description of car
     * @param created of car
     * @param images of car
     */
    public Car(String mark, String model, int releaseYear, int mileage, String bodyType, String color,
               double engineCapacity, String engineType, int power, int cost, String description,
               Date created, List<Image> images) {
        this.mark = mark;
        this.model = model;
        this.releaseYear = releaseYear;
        this.mileage = mileage;
        this.bodyType = bodyType;
        this.color = color;
        this.engineCapacity = engineCapacity;
        this.engineType = engineType;
        this.power = power;
        this.cost = cost;
        this.description = description;
        this.created = created;
        this.images = images;
    }

    /**
     * Id getter.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Id setter.
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * User getter.
     * @return user.
     */
    public User getUser() {
        return user;
    }

    /**
     * User setter.
     * @param user - user.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Mark getter.
     * @return mark.
     */
    public String getMark() {
        return mark;
    }

    /**
     * Mark setter.
     * @param mark - mark.
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * Model getter.
     * @return model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Model setter.
     * @param model - model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Release year getter.
     * @return release year.
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Release year setter.
     * @param releaseYear - release year.
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * Mileage getter.
     * @return mileage.
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Mileage setter.
     * @param mileage - mileage.
     */
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    /**
     * Body type getter.
     * @return body type.
     */
    public String getBodyType() {
        return bodyType;
    }

    /**
     * Body type setter.
     * @param bodyType - body type.
     */
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    /**
     * Color setter.
     * @return color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Color setter.
     * @param color - color.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Engine capacity getter.
     * @return engine capacity.
     */
    public double getEngineCapacity() {
        return engineCapacity;
    }

    /**
     * Engine capacity setter.
     * @param engineCapacity - engine capacity.
     */
    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    /**
     * Engine type getter.
     * @return engine type.
     */
    public String getEngineType() {
        return engineType;
    }

    /**
     * Engine type setter.
     * @param engineType - engine type.
     */
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    /**
     * Power getter.
     * @return power.
     */
    public int getPower() {
        return power;
    }

    /**
     * Power setter.
     * @param power - power.
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Cost getter.
     * @return cost.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Cost setter.
     * @param cost - cost.
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Is car sold.
     * @return is car sold.
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * Set is car sold.
     * @param sold - is car sold.
     */
    public void setSold(boolean sold) {
        this.sold = sold;
    }

    /**
     * Description getter.
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Description setter.
     * @param description - description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Created date getter.
     * @return date created.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Created date setter.
     * @param created date.
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * Comments getter.
     * @return comments.
     */
    public Set<Comment> getComments() {
        return comments;
    }

    /**
     * Comments setter.
     * @param comments - comments.
     */
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Images getter.
     * @return images.
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * Images setter.
     * @param images of car.
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     * owner getter.
     * @return is curr user is owner.
     */
    public boolean isOwner() {
        return owner;
    }

    /**
     * owner setter.
     * @param owner of current car.
     */
    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

        if (id != car.id) {
            return false;
        }
        if (releaseYear != car.releaseYear) {
            return false;
        }
        if (mileage != car.mileage) {
            return false;
        }
        if (Double.compare(car.engineCapacity, engineCapacity) != 0) {
            return false;
        }
        if (power != car.power) {
            return false;
        }
        if (cost != car.cost) {
            return false;
        }
        if (sold != car.sold) {
            return false;
        }
        if (!user.equals(car.user)) {
            return false;
        }
        if (!mark.equals(car.mark)) {
            return false;
        }
        if (!model.equals(car.model)) {
            return false;
        }
        if (!bodyType.equals(car.bodyType)) {
            return false;
        }
        if (!color.equals(car.color)) {
            return false;
        }
        if (!engineType.equals(car.engineType)) {
            return false;
        }
        if (!description.equals(car.description)) {
            return false;
        }
        if (!created.equals(car.created)) {
            return false;
        }
        if (!comments.equals(car.comments)) {
            return false;
        }
        return images.equals(car.images);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + user.hashCode();
        result = 31 * result + mark.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + releaseYear;
        result = 31 * result + mileage;
        result = 31 * result + bodyType.hashCode();
        result = 31 * result + color.hashCode();
        temp = Double.doubleToLongBits(engineCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + engineType.hashCode();
        result = 31 * result + power;
        result = 31 * result + cost;
        result = 31 * result + (sold ? 1 : 0);
        result = 31 * result + description.hashCode();
        result = 31 * result + created.hashCode();
        result = 31 * result + comments.hashCode();
        result = 31 * result + images.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{"
                + "id=" + id
                + ", user=" + user
                + ", mark='" + mark + '\''
                + ", model='" + model + '\''
                + ", releaseYear=" + releaseYear
                + ", mileage=" + mileage
                + ", bodyType='" + bodyType + '\''
                + ", color='" + color + '\''
                + ", engineCapacity=" + engineCapacity
                + ", engineType='" + engineType + '\''
                + ", power=" + power
                + ", cost=" + cost
                + ", sold=" + sold
                + ", description='" + description + '\''
                + ", created=" + created
                + ", comments=" + comments
                + ", images=" + images
                + ", owner=" + owner
                + '}';
    }
}
package dev.stormery.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Model class, to represents developed programs and their statistics <br>
 */
public class Programs {

    //Editable
    private Integer id;

    private String name;

    private Integer diskSpace;

    private Integer compilationTime;

    private Double installTime;

    private Double delay;

    private Integer programLevel;

    //Getting from table ProgramLevelFactor

    private Integer strength;

    private Integer price;

    //switch button
    private Integer amount;

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);

    public Programs(Integer id, String name, Integer diskSpace, Integer compilationTime, Double installTime, Double delay, Integer programLevel, Integer strength, Integer price,
    Integer amount) {
        this.id = id;
        this.name = name;
        this.diskSpace = diskSpace;
        this.compilationTime = compilationTime;
        this.installTime = installTime;
        this.delay = delay;
        this.programLevel = programLevel;
        this.strength = strength;
        this.price = price;
        this.amount = amount;
    }

    public static double formatStringToDouble(String string) throws ParseException{
        return numberFormat.parse(string).doubleValue();
    }
    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiskSpace() {
        return diskSpace;
    }

    public void setDiskSpace(Integer diskSpace) {
        this.diskSpace = diskSpace;
    }

    public Integer getCompilationTime() {
        return compilationTime;
    }

    public void setCompilationTime(Integer compilationTime) {
        this.compilationTime = compilationTime;
    }

    public Double getInstallTime() {
        return installTime;
    }

    public void setInstallTime(Double installTime) {
        this.installTime = installTime;
    }

    public Double getDelay() {
        return delay;
    }

    public void setDelay(Double delay) {
        this.delay = delay;
    }

    public Integer getProgramLevel() {
        return programLevel;
    }

    public void setProgramLevel(Integer programLevel) {
        this.programLevel = programLevel;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Programs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", diskSpace=" + diskSpace +
                ", compilationTime=" + compilationTime +
                ", installTime=" + installTime +
                ", delay=" + delay +
                ", programLevel=" + programLevel +
                ", strength=" + strength +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}

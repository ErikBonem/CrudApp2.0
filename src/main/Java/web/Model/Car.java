package web.Model;

public class Car {
    private String model;
    private String series;
    private int horsePowers;

    public Car(String model, String series, int horsePowers) {
        this.model = model;
        this.series = series;
        this.horsePowers = horsePowers;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getHorsePowers() {
        return horsePowers;
    }

    public void setHorsePowers(int horsePowers) {
        this.horsePowers = horsePowers;
    }
}

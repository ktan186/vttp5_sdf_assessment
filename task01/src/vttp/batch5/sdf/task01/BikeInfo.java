package vttp.batch5.sdf.task01;

public class BikeInfo {
    private final Integer season;
    private final Integer month;
    private final boolean holiday;
    private final Integer day;
    private final Integer weather;
    private final Integer casual;
    private final Integer registered;
    private final Integer total;

    

    public BikeInfo(Integer season, Integer month, boolean holiday, Integer day, Integer weather, Integer casual,
            Integer registered, Integer total) {
        this.season = season;
        this.month = month;
        this.holiday = holiday;
        this.day = day;
        this.weather = weather;
        this.casual = casual;
        this.registered = registered;
        this.total = total;
    }
    
    public Integer getSeason() {
        return season;
    }
    public Integer getMonth() {
        return month;
    }
    public boolean isHoliday() {
        return holiday;
    }
    public Integer getDay() {
        return day;
    }
    public Integer getWeather() {
        return weather;
    }
    public Integer getCasual() {
        return casual;
    }
    public Integer getRegistered() {
        return registered;
    }
    public Integer getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "BikeInfo [season=" + season + ", month=" + month + ", holiday=" + holiday + ", day=" + day
                + ", weather=" + weather + ", casual=" + casual + ", registered=" + registered + ", total=" + total
                + "]";
    }

}

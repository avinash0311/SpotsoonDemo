package application.android.spotsoondemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by boobeshb on 7/20/2017.
 */

public class CountryListArray {
    @SerializedName("country")
    private String country;

    @SerializedName("flag")
    private String flag;

    @SerializedName("rank")
    private String rank;

    @SerializedName("population")
    private String population;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}

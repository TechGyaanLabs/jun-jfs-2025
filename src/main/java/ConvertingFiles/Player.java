package ConvertingFiles;

public class Player {
    private String name;
    private String country;
    private String dob;

    public Player() {}

    public Player(String name, String country, String dob) {
        this.name = name;
        this.country = country;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}


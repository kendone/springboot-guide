package com.kendo.xml;

/*One*/
@SuppressWarnings("unused")
class OneToOneAddress {
    private Integer id;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("id：")
                .append(this.getId())
                .append("，street：")
                .append(street)
                .append("，city：")
                .append(city)
                .append("，state：")
                .append(state)
                .append("，zip：")
                .append(zip)
                .append("，country：")
                .append(country)
                .toString();
    }
}
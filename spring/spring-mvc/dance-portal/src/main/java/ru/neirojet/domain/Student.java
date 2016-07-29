package ru.neirojet.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

    private Integer id;

    @JsonProperty("results.login.username")
    private String login;

    @JsonProperty("results.name.first")
    private String firstName;

    @JsonProperty("results.name.last")
    private String lastName;

    @JsonProperty("results.email")
    private String email;

    @JsonProperty("results.cell")
    private String cell;

    @JsonProperty("results.gender")
    private String gender;

    @JsonProperty("results.picture.large")
    private String photoUrl;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

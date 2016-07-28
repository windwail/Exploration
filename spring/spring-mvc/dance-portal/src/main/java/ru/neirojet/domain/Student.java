package ru.neirojet.domain;

import java.time.LocalDate;


public class Student {

    private String name;

    private String secondName;

    private LocalDate birthDate;

    private String photoUlr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhotoUlr() {
        return photoUlr;
    }

    public void setPhotoUlr(String photoUlr) {
        this.photoUlr = photoUlr;
    }
}

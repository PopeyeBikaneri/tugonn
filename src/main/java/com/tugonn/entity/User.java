package com.tugonn.entity;

import javax.persistence.*;

/**
 * @author Chhavi Priya Tanwar
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String email;
    private String phone;
    private String username;

    @Column(name = "country_code")
    private String countryCode;

    private String password;
    private String type;

    @Column(name = "device_id")
    private String deviceId;
    private String otp;

    @Column(name = "device_token")
    private String deviceToken;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String about;

    @Column(name = "artist_band_name")
    private String artistBandName;

    private String gender;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name =  "login_type")
    private String loginType;

    private String category;
    private String instrument;
    private String genre;

    @Column(name = "social_urls")
    private String socialUrls;


    private String services;

    private long creationTs;
    private long modifiedTs;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getArtistBandName() {
        return artistBandName;
    }

    public void setArtistBandName(String artistBandName) {
        this.artistBandName = artistBandName;
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

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSocialUrls() {
        return socialUrls;
    }

    public void setSocialUrls(String socialUrls) {
        this.socialUrls = socialUrls;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public long getCreationTs() {
        return creationTs;
    }

    public void setCreationTs(long creationTs) {
        this.creationTs = creationTs;
    }

    public long getModifiedTs() {
        return modifiedTs;
    }

    public void setModifiedTs(long modifiedTs) {
        this.modifiedTs = modifiedTs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", otp='" + otp + '\'' +
                ", deviceToken='" + deviceToken + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", about='" + about + '\'' +
                ", artistBandName='" + artistBandName + '\'' +
                ", gender='" + gender + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", loginType='" + loginType + '\'' +
                ", category='" + category + '\'' +
                ", instrument='" + instrument + '\'' +
                ", genre='" + genre + '\'' +
                ", socialUrls='" + socialUrls + '\'' +
                ", services='" + services + '\'' +
                ", creationTs=" + creationTs +
                ", modifiedTs=" + modifiedTs +
                '}';
    }
}

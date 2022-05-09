package com.example.e_commerce_app;

public class registers {
    private String registerName;
    private String registerEmail;
    private String registerPhoneNumber;
    private String registerAddress;
    private String registerCountry;
    private String registerUsername;
    private String registerPassword;
    private  boolean isAdmin;

    public registers(String registerName,String registerEmail,String registerPhoneNumber,String registerAddress,String registerCountry,String registerUsername,String registerPassword, boolean isAdmin){
        this.registerName = registerName;
        this.registerEmail = registerEmail;
        this.registerPhoneNumber = registerPhoneNumber;
        this.registerAddress = registerAddress;
        this.registerCountry = registerCountry;
        this.registerUsername = registerUsername;
        this.registerPassword = registerPassword;
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public registers(){

    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getRegisterEmail() {
        return registerEmail;
    }

    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }

    public String getRegisterPhoneNumber() {
        return registerPhoneNumber;
    }

    public void setRegisterPhoneNumber(String registerPhoneNumber) {
        this.registerPhoneNumber = registerPhoneNumber;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getRegisterCountry() {
        return registerCountry;
    }

    public void setRegisterCountry(String registerCountry) {
        this.registerCountry = registerCountry;
    }

    public String getRegisterUsername() {
        return registerUsername;
    }

    public void setRegisterUsername(String registerUsername) {
        this.registerUsername = registerUsername;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }
}

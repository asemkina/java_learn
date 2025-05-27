package ru.stqa.mantis.model;

public record UserData(String username, String email, String password) {
    public UserData() {
        this("", "","password");
    }

    public UserData withEmail(String email){
        return new UserData(this.username, email, "password");
    }

    public UserData withUsername(String username){
        return new UserData(username, this.email, "password");
    }
}

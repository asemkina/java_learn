package model;

public record ContactData(String id, String firstname, String lastname, String address, String home, String email) {

    public ContactData(){
        this ("", "","","","","");
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.address, this.home, this.email);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.address, this.home, this.email);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, address, this.home, this.email);
    }

    public ContactData withPhone(String home) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, home, this.email);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.home, email);
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.address, this.home, email);
    }
}
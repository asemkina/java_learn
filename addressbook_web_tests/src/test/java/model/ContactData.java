package model;

public record ContactData(
        String id,
        String firstname,
        String lastname,
        String address,
        String home,
        String email,
        String photo,
        String mobile,
        String work,
        String phone2,
        String email2,
        String email3
)

{
    public ContactData(){
        this ("", "","","","","", "", "", "", "","","");
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.address, this.home, this.email, this.photo, this.mobile, this.work, this.phone2, this.email2, this.email3);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.address, this.home, this.email, this.photo, this.mobile, this.work, this.phone2, this.email2, this.email3);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, address, this.home, this.email, this.photo, this.mobile, this.work, this.phone2, this.email2, this.email3);
    }

    public ContactData withHomePhone(String home) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, home, this.email, this.photo, this.mobile, this.work, this.phone2, this.email2, this.email3);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.home, email, this.photo, this.mobile, this.work, this.phone2, this.email2, this.email3);
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.address, this.home, this.email, this.photo, this.mobile, this.work, this.phone2, this.email2, this.email3);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.home, this.email, photo, this.mobile, this.work, this.phone2, this.email2, this.email3);
    }

    public ContactData withMobilePhone(String mobile) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.home, this.email, this.photo, mobile, this.work, this.phone2, this.email2, this.email3);
    }

    public ContactData withWorkPhone(String work) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.home, this.email, this.photo, this.mobile, work, this.phone2, this.email2, this.email3);
    }

    public ContactData withPhone2Phone(String phone2) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.home, this.email, this.photo, this.mobile, this.work, phone2, this.email2, this.email3);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.home, this.email, this.photo, this.mobile, this.work, phone2, email2, this.email3);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.home, this.email, this.photo, this.mobile, this.work, phone2, this.email2, email3);
    }
}
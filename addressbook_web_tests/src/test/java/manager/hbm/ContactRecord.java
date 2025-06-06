package manager.hbm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "addressbook")
public class ContactRecord {
    @Id
    public int id;
    public String firstname;
    public String lastname;
    public String address;
    public String home;
    public String email;
    public String mobile;
    public String work;
    public String phone2;
    public String email2;
    public String email3;
    public String middlename = new String("");
    public String nickname = new String("");
    public String company = new String("");
    public String title = new String("");
    public String homepage = new String("");
    public String fax = new String("");

    public ContactRecord(){
    }

    public ContactRecord(int id, String firstname, String lastname, String address, String home, String email, String mobile, String work, String phone2, String email2, String email3) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.email = email;
        this.mobile = mobile;
        this.work = work;
        this.phone2 = phone2;
        this.email2 = email2;
        this.email3 = email3;
    }
}


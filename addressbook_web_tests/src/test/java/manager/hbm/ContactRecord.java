package manager.hbm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;


@Entity
@Table(name = "addressbook")
public class ContactRecord {
    @Id
    public int id;
    public String firstname;
    public String lastname;
    public String address;
    public String home;
    private String email;
    public String middlename = new String("");
    public String nickname = new String("");
    public String company = new String("");
    public String title = new String("");
    public String mobile = new String("");
    public String work = new String("");
    public String homepage = new String("");
    public String email3 = new String("");
    public String email2 = new String("");
    public String fax = new String("");

    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String lastname, String address, String home, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.email = email;
    }
}


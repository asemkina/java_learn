package manager.hbm;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "group_list")
/// аннотация для привязки таблицы
public class GroupRecord {

    @Id
    /// аннотация для указания первичного ключа в таблице
    @Column(name = "group_id")
    public int id;
    @Column(name = "group_name")
    public String title;
    @Column(name = "group_header")
    public String name;
    @Column(name = "group_footer")
    public String footer;

    @ManyToMany
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    public List<ContactRecord> contacts;

    public Date deprecated = new Date();

    public GroupRecord() {
    }

    public GroupRecord(int id, String title, String name, String footer) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.footer = footer;
    }
}

package manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

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

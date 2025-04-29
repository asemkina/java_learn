package model;

public record GroupData(String group1, String name, String footer) {

    public GroupData () {
        this ("", "", "");
    }

    public GroupData withTitle(String group1) {
        return new GroupData(group1, this.name, this.footer);
    }

    public GroupData withName(String name) {
        return new GroupData(this.group1, name,this.footer);
    }

    public GroupData withFooter(String footer) {
        return new GroupData(this.group1, this.name,footer);
    }
}
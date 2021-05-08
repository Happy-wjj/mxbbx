package com.gxwz.medical.entity;

public class Group {

    // 自增主键
    private Integer id;

    // 组编码
    private String groupcode;

    // 组名称
    private String gruopname;

    // 组名称
    private String father;

    // 组名称
    private String gruopid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode;
    }

    public String getGruopname() {
        return gruopname;
    }

    public void setGruopname(String gruopname) {
        this.gruopname = gruopname;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getGruopid() {
        return gruopid;
    }

    public void setGruopid(String gruopid) {
        this.gruopid = gruopid;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupcode='" + groupcode + '\'' +
                ", gruopname='" + gruopname + '\'' +
                ", father='" + father + '\'' +
                ", gruopid='" + gruopid + '\'' +
                '}';
    }
}

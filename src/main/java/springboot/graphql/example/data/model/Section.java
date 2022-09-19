package springboot.graphql.example.data.model;

public class Section {

    private int sectionid;

    private String sectionname;

    private String sectionxid;

    private String coursexid;

    public int getSectionid() {
        return sectionid;
    }

    public void setSectionid(int sectionId) {
        this.sectionid = sectionid;
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    public String getSectionxid() {
        return sectionxid;
    }

    public void setSectionxid(String sectionxid) {
        this.sectionxid = sectionxid;
    }

    public String getCoursexid() {
        return coursexid;
    }

    public void setCoursexid(String coursexid) {
        this.coursexid = coursexid;
    }
    public Section() {
    }

    public Section(int sectionid, String sectionname, String sectionxid, String coursexid) {
        this.sectionid = sectionid;
        this.sectionname = sectionname;
        this.sectionxid = sectionxid;
        this.coursexid = coursexid;
    }

}

package springboot.graphql.example.data.model;

public class Accounts {
    public Accounts() {
    }

    private int id;

    private String username;

    private String coursexid;

    private String email;

    private String section;

    public Accounts(int id, String username, String coursexid, String email, String section) {
        this.id = id;
        this.username = username;
        this.coursexid = coursexid;
        this.email = email;
        this.section = section;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCoursexid() {
        return coursexid;
    }

    public void setCoursexid(String coursexid) {
        this.coursexid = coursexid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", coursexid='" + coursexid + '\'' +
                ", email='" + email + '\'' +
                ", section='" + section + '\'' +
                '}';
    }

}

package wap.model;

public class User {

    @Column(name ="username")
    private String username;

    @Id
    @Column(name ="u_id")
    private Integer u_id;

    @Column(name ="password")
    private String password;

    @Column(name ="email")
    private String email;

    @Column(name ="role")
    private String role;

    @Column(name ="company")
    private String company;

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public void setId(int u_id){
        this.u_id = u_id;
    }
    public long getId(){
        return u_id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getU_id() {
        return u_id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getCompany() {
        return company;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public User(String username, Integer u_id,String password, String email, String role, String company){

    }
}

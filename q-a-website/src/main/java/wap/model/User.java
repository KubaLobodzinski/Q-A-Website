package wap.model;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import wap.dto.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
@Builder
public class User implements UserDetails {

    @Id
    @Column(name ="u_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer u_id;
    @Column(name ="username")
    private String username;

    @Column(name ="password")
    private String password;

    @Column(name ="email")
    private String email;

    @Column(name ="role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name ="company")
    private String company;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Answer> answers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public User(){

    }
    public void setId(int u_id){
        this.u_id = u_id;
    }
    public long getId(){
        return u_id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
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

    public Role getRole() {
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

    public void setRole(Role role) {
        this.role = role;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public User(String username, Integer u_id,String password, String email, String role, String company){

    }
}

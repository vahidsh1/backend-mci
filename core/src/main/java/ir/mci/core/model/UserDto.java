package ir.mci.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class UserDto {
    @Id
    @Column(name ="USERNAME")
    String username;
    @Column(name ="PASSWORD")
    String password;
    @Column(name ="REQUEST_DATE")
    String request_date;
    @Column(name ="REQUEST_NO")
    String request_no;
    @Column(name ="OFFICE_NAME")
    String office_name;
    @Column(name ="FNAME")
    String fname;
    @Column(name ="LNAME")
    String lname;
    @Column(name ="PROVINCE")
    String province;
    @Column(name ="CITY")
    String city;
    @Column(name ="VIEW1")
    String view1;
    @Column(name ="VIEW2")
    String view2;
    @Column(name ="VIEW3")
    String view3;
    @Column(name ="VIEW4")
    String view4;
    @Column(name ="VIEW5")
    String view5;
    @Column(name ="NATIONAL_CODE")
    String national_code;
    @Column(name ="CREATE_DATE")
    String create_date;
    @Column(name ="EX_DATE")
    String ex_date;
    @Column(name ="TELL")
    String tel;
    @Column(name ="LANDINE_PHONE")
    String land_phone;
    @Column(name ="ENABLED")
    String enabled;
    @Column(name ="VIEW6")
    String view6;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")

    )
    private List<Authority> authorities;}

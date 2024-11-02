package ir.mci.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "USERS2")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="USERNAME")
    String username;
    @Column(name ="PASSWORD")
    String password;
    @Column(name ="FNAME")
    String fname;
    @Column(name ="LNAME")
    String lname;
    @Column(name ="PROVINCE")
    String province;
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
    @Column(name ="VIEW6")
    String view6;
    public User(Long Id,String username,String password,String fname, String lname, String view1,String view2,String view3,String view4,String view5,String view6){
        this.id=Id;
        this.username=username;
        this.password=password;
        this.fname=fname;
        this.lname=lname;
        this.view1=view1;
        this.view2=view2;
        this.view3=view3;
        this.view4=view4;
        this.view5=view5;
        this.view6=view6;

    }
}

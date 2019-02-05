package com.jsf.domain.userDomain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class User implements Serializable {

    public User(User user) {
        this.id = user.getId() ;
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.userName = user.getUserName();
        this.emailAddress = user.getEmailAddress();
        this.password = user.getPassword();
        this.posts = user.getPosts();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String firstName ;

    private String lastName ;

    private String userName ;

    private String emailAddress ;

    //TODO Need hashing
    private String password ;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>() ;

    @Override
    public String toString(){

        return String.format("User [Id = '%d', firstName = '%s', lastName = '%s', userName = '%s', emailAddress = '%s', password  = '%s']", id, firstName, lastName, userName, emailAddress, password) ;
    }


}

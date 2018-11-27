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


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id ;

    private String firstName ;

    private String lastName ;

    private String userName ;

    private String emailAddress ;

    private String password ;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>() ;

    @Override
    public String toString(){

        return String.format("User [Id = '%d', firstName = '%s', lastName = '%s', userName = '%s', emailAddress = '%s', password  = '%s']", Id, firstName, lastName, userName, emailAddress, password) ;
    }


}

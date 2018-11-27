package com.jsf.domain.userDomain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

public class Comment implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post", referencedColumnName = "id")
    private Post post;



}

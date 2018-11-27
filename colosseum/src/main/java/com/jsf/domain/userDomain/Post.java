package com.jsf.domain.userDomain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsf.repositories.UserRepo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Post implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user",  referencedColumnName = "id")
    private User user;

    private String content ;

    private int agreeCount ;

    private int disagreeCount  ;

    private User posterId ;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>() ;

    @Override
    public String toString(){

        return String.format("Post[id = 'id', userId = '%s' content = '%s', agreeCount = '%s', disagreeCount = '%s', posterId = '%s']", id, user, content, agreeCount, disagreeCount, posterId) ;
    }
}

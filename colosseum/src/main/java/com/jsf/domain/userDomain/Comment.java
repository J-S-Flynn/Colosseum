package com.jsf.domain.userDomain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
public class Comment implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post", referencedColumnName = "id")
    private Post post ;

    private String comment ;

    @Override
    public String toString(){

        return String.format("Comments[id = '%d', comment = '%s', postId = '%s']", id, comment) ;
    }
}

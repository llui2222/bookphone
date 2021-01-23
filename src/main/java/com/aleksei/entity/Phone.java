package com.aleksei.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name="phones")
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String phonename;

    @Temporal(TemporalType.TIMESTAMP)
    private Date booktimestamp;

    @ManyToOne
    @JoinColumn(name="bookedby")
    private User user;

}

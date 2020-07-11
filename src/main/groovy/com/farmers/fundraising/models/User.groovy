package com.farmers.fundraising.models

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.*

@Entity // tell persistence provider 'Ability' is a persistence entity
class User {
    @Id // tell persistence provider 'id' is primary key
    @GeneratedValue( // tell persistence provider that value of 'id' will be generated
            strategy = GenerationType.IDENTITY // use RDBMS unique id generator
    )
    Long id

    String userName

    String firstName

    String lastName

    String gmail

    String phoneNo

    Boolean isActive

}
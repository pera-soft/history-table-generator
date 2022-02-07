package io.pera.model;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeqGen")
    @SequenceGenerator(name = "userSeqGen", sequenceName = "users_seq", allocationSize = 1)
    private int id;

    @Audited
    private String firstName;

    @Audited
    private String lastName;

    @Temporal(TIMESTAMP)
    private Date createdDate = new Date();

}

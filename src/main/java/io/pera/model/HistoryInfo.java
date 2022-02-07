package io.pera.model;

import lombok.Data;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@RevisionEntity
@Entity
@Data
public class HistoryInfo {

    @Id
    @RevisionNumber
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historyInfoSeqGen")
    @SequenceGenerator(name = "historyInfoSeqGen", sequenceName = "history_info_seq", allocationSize = 1)
    private int id;

    @RevisionTimestamp
    @Temporal(TIMESTAMP)
    private Date date;

}

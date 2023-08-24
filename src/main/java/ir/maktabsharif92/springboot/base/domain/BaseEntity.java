package ir.maktabsharif92.springboot.base.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity<ID extends Serializable> implements Serializable {

    public static final String ID = "id";
    public static final String CREATE_DATE = "create_date";
    public static final String LAST_UPDATE_DATE = "last_update_date";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private ID id;

    @Column(name = CREATE_DATE)
    private ZonedDateTime createDate;

    @Column(name = LAST_UPDATE_DATE)
    private ZonedDateTime lastUpdateDate;
}

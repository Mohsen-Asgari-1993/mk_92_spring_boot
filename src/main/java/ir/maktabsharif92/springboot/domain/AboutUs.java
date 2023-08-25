package ir.maktabsharif92.springboot.domain;

import ir.maktabsharif92.springboot.base.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = AboutUs.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AboutUs extends BaseEntity<Long> {

    public static final String TABLE_NAME = "about_us";

    public static final String CONTENT = "content";

    @Column(name = CONTENT)
    @Lob
    private String content;
}

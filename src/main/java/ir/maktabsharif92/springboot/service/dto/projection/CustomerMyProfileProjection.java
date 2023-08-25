package ir.maktabsharif92.springboot.service.dto.projection;

import ir.maktabsharif92.springboot.base.domain.enumeration.Gender;

public interface CustomerMyProfileProjection {

    Long getId();

    String getFirstName();

    String getLastName();

    String getNationalCode();

    Gender getGender();

}

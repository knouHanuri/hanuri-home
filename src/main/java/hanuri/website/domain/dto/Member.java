package hanuri.website.domain.dto;

import hanuri.website.domain.EEnrollmentStatus;
import hanuri.website.domain.EGender;
import hanuri.website.domain.EMembershipLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private int memberId;
    private String username;
    private String email;
    private String name;
    private String phoneNumber;
    private String password;
    private EGender gender;
    private String birthdate;
    private String studentId;
    private String imageId;
    private EEnrollmentStatus enrollmentStatus;
    private EMembershipLevel membershipLevel;
    private Boolean isActive;
    private String Provider;
    private String ProviderId;
}
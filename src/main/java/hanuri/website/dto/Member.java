package hanuri.website.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long seq;
    private String id;
    private String name;
    private String gender;
    private String phoneNumber;
    private int grade;
}

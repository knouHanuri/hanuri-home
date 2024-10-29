package hanuri.website.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class Membership {
    private int membershipId;
    private int memberId;
    private String userName;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date paymentDate;
    private int amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
//    public Membership() {}
}


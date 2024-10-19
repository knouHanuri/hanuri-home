package hanuri.website.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MembershipCreate {

    private int membershipId;
    private int memberId;
    private Date paymentDate;
    private int amount;

    public String getId()
    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    private Date expirationDate;
}


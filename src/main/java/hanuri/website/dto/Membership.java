package hanuri.website.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Membership {
    private int membershipId;
    private int memberId;
    private String name;
    private Date paymentDate;
    private int amount;
    private Date expirationDate;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Membership(int membershipId,int memberId, Date paymentDate, int amount, Date expirationDate){
        this.membershipId=membershipId;
        this.memberId=memberId;
        this.paymentDate=paymentDate;
        this.amount=amount;
        this.expirationDate=expirationDate;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getPaymentDate() {
        return dateFormat.format(paymentDate);
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getExpirationDate() {
        return dateFormat.format(expirationDate);
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}

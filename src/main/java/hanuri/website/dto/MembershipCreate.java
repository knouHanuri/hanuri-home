package hanuri.website.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MembershipCreate {

//    @NotNull(message="회원 id는 필수입니다.")
    private int memberId;
//    @NotNull(message = "납부 날짜는 필수입니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date paymentDate;
//    @NotNull(message = "만료 날짜는 필수입니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
    private int amount;

    public  MembershipCreate(Date expirationDate, int memberId, Date paymentDate, int amount) {
        this.expirationDate = expirationDate;
        this.memberId = memberId;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getPaymentDate() {
        return paymentDate;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}


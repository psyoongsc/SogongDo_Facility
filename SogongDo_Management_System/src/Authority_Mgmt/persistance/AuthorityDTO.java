package Authority_Mgmt.persistance;

public class AuthorityDTO {
    private int authorityID;
    private String memberID;

    public AuthorityDTO(int id, String mid){
        super();
        this.authorityID=id;
        this.memberID=mid;
    }

    public int getAuthorityID() {
        return authorityID;
    }

    public void setAuthorityID(int authorityID) {
        authorityID = authorityID;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        memberID = memberID;
    }
}

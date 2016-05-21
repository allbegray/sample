package allbegray.sample.common.web.search;

/**
 * Created by allbegray on 2016-04-29.
 */
public class TestUserSearchForm extends AbstractSearchForm {

    @Override
    public String getUri() {
        return "/user/list";
    }

    @Queryable(name = "회원명")
    private String name;

    @Queryable(name = "전화번호")
    private String phone;

    @Queryable(name = "전화번호")
    private String address;

    @Queryable(name = "회원타입", defaultValue = "일반회원")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

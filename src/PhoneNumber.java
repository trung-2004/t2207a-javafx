public class PhoneNumber {
    String name;
    String phone;

    public PhoneNumber(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public PhoneNumber setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public PhoneNumber setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String toString() {
        return this.name;
    }
}

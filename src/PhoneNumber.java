import javafx.scene.control.Button;

public class PhoneNumber {
    String name;
    String phone;

    Button edit;

    public PhoneNumber(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event) -> {
            PhoneBook.editPhoneNumber = this;
            PhoneBook.stName.setText(this.name);
            PhoneBook.stPhone.setText(this.phone);
        });
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

    public Button getEdit() {
        return edit;
    }

    public PhoneNumber setEdit(Button edit) {
        this.edit = edit;
        return this;
    }

    public String toString() {
        return this.name;
    }
}

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Collections;
import java.util.Comparator;

public class PhoneBook {

    public TextField txtName;
    public TextField txtPhone;

    public ObservableList<PhoneNumber> listPhoneNumber = FXCollections.observableArrayList();
    public ListView<PhoneNumber> lv;

    public PhoneNumber editPhoneNumber;

    public boolean ascending = true;

    public void submit(ActionEvent actionEvent) {
        String n = txtName.getText();
        String p = txtPhone.getText();

        if (editPhoneNumber == null) {
            PhoneNumber pn = new PhoneNumber(n, p);
            listPhoneNumber.add(pn);
        } else {
            for (PhoneNumber pn1 : listPhoneNumber) {
                if (pn1.name.equals(editPhoneNumber.name) && pn1.phone.equals(editPhoneNumber.phone)) {
                    pn1.setName(n);
                    pn1.setPhone(p);
                }
            }
        }
        lv.setItems(listPhoneNumber);
        lv.refresh();
        editPhoneNumber = null;
        clearInput();

    }

    public void clearInput() {
        this.txtName.clear();
        this.txtPhone.clear();
    }

    public void editPhone(MouseEvent mouseEvent) {
        editPhoneNumber = lv.getSelectionModel().getSelectedItem();
        this.txtName.setText(editPhoneNumber.getName());
        this.txtPhone.setText(editPhoneNumber.getPhone());
    }

    public void sortPhoneNumber(MouseEvent mouseEvent) {
        if (ascending) {
            Collections.sort(listPhoneNumber, new Comparator<PhoneNumber>() {
                @Override
                public int compare(PhoneNumber o1, PhoneNumber o2) {
                    return o1.name.compareTo(o2.name);
                }
            });
        } else {
            Collections.sort(listPhoneNumber, new Comparator<PhoneNumber>() {
                @Override
                public int compare(PhoneNumber o1, PhoneNumber o2) {
                    return o2.name.compareTo(o1.name);
                }
            });
        }
        ascending = !ascending;
    }
}

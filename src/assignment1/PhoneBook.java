package assignment1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PhoneBook implements Initializable {

    public TextField txtName;
    public TextField txtPhone;
    public static TextField stName;
    public static TextField stPhone;

    public ObservableList<PhoneNumber> listPhoneNumber = FXCollections.observableArrayList();

    public static PhoneNumber editPhoneNumber;
    public TableView<PhoneNumber> tbview;
    public TableColumn<PhoneNumber, String> cName;
    public TableColumn<PhoneNumber, String> cPhone;
    public TableColumn<PhoneNumber, Button> cAction;


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
        tbview.setItems(listPhoneNumber);
        tbview.refresh();
        editPhoneNumber = null;
        clearInput();

    }

    public void clearInput() {
        this.txtName.clear();
        this.txtPhone.clear();
    }

    public void editPhone(MouseEvent mouseEvent) {
//        editPhoneNumber = lv.getSelectionModel().getSelectedItem();
        this.txtName.setText(editPhoneNumber.getName());
        this.txtPhone.setText(editPhoneNumber.getPhone());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        stName = txtName;
        stPhone = txtPhone;
    }
}

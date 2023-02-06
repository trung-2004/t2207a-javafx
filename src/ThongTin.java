import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ThongTin {

    public TextField txtFullName;
    public TextField txtEmail;
    public Text txtInfo;
    public ObservableList<Student> listStudent = FXCollections.observableArrayList();
    public ListView<Student> lv;
    public Student editStudent;

    public void submit(ActionEvent actionEvent) {
        String fn = txtFullName.getText();
        String el = txtEmail.getText();

        if (editStudent == null) {
            Student s = new Student(fn, el);
            listStudent.add(s);
        } else {
            //editStudent.setFullName(fn);
            //editStudent.setEmail(el);
            for (Student s: listStudent) {
                if (s.email.equals(editStudent.email) && s.fullName.equals(editStudent.fullName)) {
                    s.setFullName(fn);
                    s.setEmail(el);
                }
            }
        }
        lv.setItems(listStudent);// hiển thị giao diện
        lv.refresh();
        editStudent = null;
        clearInPut();
    }
    void clearInPut() {
        txtFullName.clear();
        txtEmail.clear();
    }

    public void editSV(MouseEvent mouseEvent) {
        // nhấn vào thì hiển thị sang input
        editStudent = lv.getSelectionModel().getSelectedItem();
        txtFullName.setText(editStudent.getFullName());
        txtEmail.setText(editStudent.getEmail());

    }
}

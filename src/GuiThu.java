import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GuiThu {
    public TextField txtNguoiNhan;
    public TextField txtTieuDe;
    public TextArea txtNoiDung;
    public Text NguoiNhanTieuDeNoiDung;

    public void submit(ActionEvent actionEvent) {
        String nn = txtNguoiNhan.getText();
        String td = txtTieuDe.getText();
        String nd = txtNoiDung.getText();
        String txtNNTD = NguoiNhanTieuDeNoiDung.getText();

        txtNguoiNhan.clear();
        txtTieuDe.clear();
        txtNoiDung.clear();

        txtNNTD+="\n================\n";
        txtNNTD+=nn+"/ "+td+"\n";
        txtNNTD+=nd;

        NguoiNhanTieuDeNoiDung.setText(txtNNTD);

    }
}

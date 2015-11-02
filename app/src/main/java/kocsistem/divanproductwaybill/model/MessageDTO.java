package kocsistem.divanproductwaybill.model;

/**
 * Created by 02482957 on 2.11.2015.
 */
public class MessageDTO {
    public void setTipField(String tipField) {
        this.tipField = tipField;
    }

    public void setMesajField(String mesajField) {
        this.mesajField = mesajField;
    }

    public String getMesajField() {

        return mesajField;
    }

    public String getTipField() {
        return tipField;
    }

    public String tipField;
    public String mesajField;
}

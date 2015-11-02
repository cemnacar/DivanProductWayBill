package kocsistem.divanproductwaybill.model;

/**
 * Created by 02482957 on 2.11.2015.
 */
public class MessageDTO {
    public void setTip(String tip) {
        Tip = tip;
    }

    public void setMesaj(String mesaj) {
        Mesaj = mesaj;
    }

    public String getTip() {

        return Tip;
    }

    public String getMesaj() {
        return Mesaj;
    }

    public String Tip;
    public String Mesaj;
}

package kocsistem.divanproductwaybill.model;

public class MovementReasonDTO
{
    public String Name;

    public String Value;

    public void setName(String name) {
        Name = name;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getName() {

        return Name;
    }

    public String getValue() {
        return Value;
    }
}
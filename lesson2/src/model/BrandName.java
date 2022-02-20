package model;

public enum BrandName {
    LENUVO("Lenuvo"),
    ASOS("Asos"),
    MAC_NOTE("MacNote"),
    ESER("Eser"),
    XAMIOU("Xamiou");

    private final String nameValue;

    BrandName(String nameValue) {
        this.nameValue = nameValue;
    }

    public String getNameValue() {
        return nameValue;
    }

    public static BrandName findByName(String nameValue) {
        for (BrandName bn : BrandName.values()) {
            if (bn.nameValue.equals(nameValue)) {
                return bn;
            }
        }
        return null;
    }
}

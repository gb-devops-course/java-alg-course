package model;

public class Notebook implements Comparable<Notebook> {

    private final String brandName;
    private final Long price;
    private final Integer ram;

    public Notebook(String brandName, Long price, Integer ram) {
        this.brandName = brandName;
        this.price = price;
        this.ram = ram;
    }

    @Override
    public int compareTo(Notebook o) {
        var priceCompare = this.price.compareTo(o.price);
        if (priceCompare != 0) {
            return priceCompare;
        }

        var ramCompare = this.ram.compareTo(o.ram);
        if (ramCompare != 0) {
            return ramCompare;
        }

        return compareBrandName(o.brandName);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "brandName='" + brandName + '\'' +
                ", price=" + price +
                ", ram=" + ram +
                '}';
    }

    public String getBrandName() {
        return brandName;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getRam() {
        return ram;
    }

    private int compareBrandName(String brandName) {
        var thisBrandName = BrandName.findByName(this.brandName);
        var otherBrandName = BrandName.findByName(brandName);

        // если обе строки не соответствуют ни одному из брэндов,
        // то сравниваем по тексту
        if (thisBrandName == null && otherBrandName == null) {
            return this.brandName.compareTo(brandName);
        }

        if (thisBrandName == null) { // если брэнд текущего объекта не найден, то -1
            return -1;
        } else if (otherBrandName == null) { // если брэнд другого объекта не найден, то 1
            return 1;
        }

        return thisBrandName.compareTo(otherBrandName);
    }
}

package utility;

import model.BrandName;
import model.Notebook;

import java.util.Random;

public class NotebooksGenerator {

    // random brand name constants
    private static final String[] BRAND_NAMES = new String[] {
            BrandName.LENUVO.getNameValue(),
            BrandName.ASOS.getNameValue(),
            BrandName.MAC_NOTE.getNameValue(),
            BrandName.ESER.getNameValue(),
            BrandName.XAMIOU.getNameValue()
    };

    // random price constants
    private static final int LOWEST_PRICE = 500;
    private static final int HIGHEST_PRICE = 2000;
    private static final int PRICE_INCREMENT = 50;
    private static final int PRICE_RANGE_LOW = LOWEST_PRICE / PRICE_INCREMENT;
    private static final int PRICE_RANGE_HIGH = HIGHEST_PRICE / PRICE_INCREMENT;
    private static final int PRICE_BOUND = PRICE_RANGE_HIGH - PRICE_RANGE_LOW + 1;

    // random ram constants
    private static final int LOWEST_RAM = 4;
    private static final int HIGHEST_RAM = 24;
    private static final int RAM_INCREMENT = 4;
    private static final int RAM_RANGE_LOW = LOWEST_RAM / RAM_INCREMENT;
    private static final int RAM_RANGE_HIGH = HIGHEST_RAM / RAM_INCREMENT;
    private static final int RAM_BOUND = RAM_RANGE_HIGH - RAM_RANGE_LOW + 1;

    private static final Random random = new Random();

    /**
     * Генерация случайного массива ноутбуков
     * @param count количество ноутбуков
     * @return сгенерированный массив ноутбуков
     */
    public static Notebook[] generateNotebooksArray(int count) {
        var notebooks = new Notebook[count];
        for (int i = 0; i < count; i++) {
            notebooks[i] = new Notebook(getRandomBrandName(), getRandomPrice(), getRandomRam());
        }

        return notebooks;
    }

    private static String getRandomBrandName() {
        return BRAND_NAMES[random.nextInt(BRAND_NAMES.length)];
    }

    private static long getRandomPrice() {
        return PRICE_INCREMENT * (random.nextInt(PRICE_BOUND) + PRICE_RANGE_LOW);
    }

    private static int getRandomRam() {
        return RAM_INCREMENT * (random.nextInt(RAM_BOUND) + RAM_RANGE_LOW);
    }
}

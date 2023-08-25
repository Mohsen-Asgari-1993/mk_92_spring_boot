package ir.maktabsharif92.springboot;

import org.apache.commons.lang3.RandomStringUtils;

public class CacheTestApp {
    public static void main(String[] args) {
        MyService myService = new MyServiceImplProxy();

        System.out.println("random numeric 1: " + myService.getRandomNumeric());
        System.out.println("random numeric 2: " + myService.getRandomNumeric());
        System.out.println("random numeric 3: " + myService.getRandomNumeric());
        System.out.println("random numeric 4: " + myService.getRandomNumeric());
        System.out.println("random numeric 5: " + myService.getRandomNumeric());
        System.out.println("random numeric 6: " + myService.getRandomNumeric());
        System.out.println("random numeric 7: " + myService.getRandomNumeric());

        System.out.println("random alphabetic 1: " + myService.getRandomAlphabetic());
        System.out.println("random alphabetic 2: " + myService.getRandomAlphabetic());
        System.out.println("random alphabetic 3: " + myService.getRandomAlphabetic());
    }
}

interface MyService {
    String getRandomNumeric();

    String getRandomAlphabetic();
}

class MyServiceImpl implements MyService {
    @Override
    public String getRandomNumeric() {
        System.out.println("in myServiceImpl");
        return RandomStringUtils.randomNumeric(8);
    }

    @Override
    public String getRandomAlphabetic() {
//        inja
        getRandomNumeric();
        return RandomStringUtils.randomAlphabetic(8);
    }
}

class MyServiceImplProxy implements MyService {

    private final MyService myService = new MyServiceImpl();

    private String randomNumericCache;

    private int randomNumericCacheCounter = 0;

    private String randomAlphabeticCache;

    private int randomAlphabeticCacheCounter = 0;

    @Override
    public String getRandomNumeric() {
        if (randomNumericCache == null || randomNumericCacheCounter == 10) {
            randomNumericCacheCounter = 0;
            randomNumericCache = myService.getRandomNumeric();
        }
        randomNumericCacheCounter++;
        return randomNumericCache;
    }

    @Override
    public String getRandomAlphabetic() {
        if (randomAlphabeticCache == null || randomAlphabeticCacheCounter == 2) {
            randomAlphabeticCacheCounter = 0;
            randomAlphabeticCache = myService.getRandomAlphabetic();
        }
        randomAlphabeticCacheCounter++;
        return randomAlphabeticCache;
    }

    public void resetCache() {
        this.randomNumericCache = null;
    }
}

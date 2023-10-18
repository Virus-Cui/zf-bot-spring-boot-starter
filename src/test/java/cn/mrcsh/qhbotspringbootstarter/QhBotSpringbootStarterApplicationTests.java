package cn.mrcsh.qhbotspringbootstarter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class QhBotSpringbootStarterApplicationTests {

    public static void main(String[] args) {
        String str = "<@123123123> assasdsaasdsdsad";
        String real = str.replace("<@","").trim();
    }

}

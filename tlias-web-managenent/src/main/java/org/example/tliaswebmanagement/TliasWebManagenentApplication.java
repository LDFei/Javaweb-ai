package org.example.tliaswebmanagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


//2319887702@qq.com
@ServletComponentScan//开启对拦截器的支持
@SpringBootApplication
public class TliasWebManagenentApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(TliasWebManagenentApplication.class, args);
        System.out.println("   _____   _    _    _____    _____    _____    _____   _ \n" +
                "  / ____| | |  | |  / ____|  / ____|  / ____|  / ____| | |\n" +
                " | (___   | |  | | | |      | |      | (___   | (___   | |\n" +
                "  \\___ \\  | |  | | | |      | |       \\___ \\   \\___ \\  | |\n" +
                "  ____) | | |__| | | |____  | |____   ____) |  ____) | |_|\n" +
                " |_____/   \\____/   \\_____|  \\_____| |_____/  |_____/  (_)\n" +
                "                                                          \n" +
                "                                                          ");
    }

}

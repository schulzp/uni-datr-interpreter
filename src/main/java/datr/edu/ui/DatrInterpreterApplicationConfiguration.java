package datr.edu.ui;

import datr.edu.DatrParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.javafx.EnableFXMLControllers;

import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableFXMLControllers
@ComponentScan(basePackages = {
        "datr.edu.ui.view",
        "datr.edu.ui.scene"
})
public class DatrInterpreterApplicationConfiguration implements AutoCloseable {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Bean(name = "i18n")
    public ReloadableResourceBundleMessageSource messageSource(ApplicationContext parentMessageSource) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setParentMessageSource(parentMessageSource);
        messageSource.setBasename("classpath:bundles/i18n");
        return messageSource;
    }

    @Bean
    public DatrParser parser() {
        return new DatrParser();
    }

    @Bean
    public ExecutorService executorService() {
        return executorService;
    }

    @Override
    @PreDestroy
    public void close() throws Exception {
        this.executorService.shutdown();
    }

}

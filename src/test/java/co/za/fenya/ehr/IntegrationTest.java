package co.za.fenya.ehr;

import co.za.fenya.ehr.EmployeeportalApp;
import co.za.fenya.ehr.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { EmployeeportalApp.class, TestSecurityConfiguration.class })
public @interface IntegrationTest {
}

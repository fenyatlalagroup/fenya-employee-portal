package co.za.fenya.ehr;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("co.za.fenya.ehr");

        noClasses()
            .that()
            .resideInAnyPackage("co.za.fenya.ehr.service..")
            .or()
            .resideInAnyPackage("co.za.fenya.ehr.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..co.za.fenya.ehr.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}

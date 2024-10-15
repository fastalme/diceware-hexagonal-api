package com.example.dicewarehexagonalapi;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ArchTest {

    private JavaClasses myClasses;

    @BeforeEach
    void setUp() {
        myClasses = new ClassFileImporter().importPackages("com.example.dicewarehexagonalapi");
    }

    @Test
    void noClassesFromAppShouldDependOnClassesFromInfra () {

        ArchRule rule = noClasses()
                .that().resideInAPackage("com.example.dicewarehexagonalapi.app..")
                .should().dependOnClassesThat()
                .resideInAPackage("com.example.dicewarehexagonalapi.infra..");

        rule.check(myClasses);

    }

    @Test
    void classesFromAppShouldNotDependOnFrameworks () {

        ArchRule rule = classes()
                .that().resideInAPackage("com.example.dicewarehexagonalapi.app..")
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage("com.example.dicewarehexagonalapi.app..", "java..", "org.slf4j..");

        rule.check(myClasses);
    }

}

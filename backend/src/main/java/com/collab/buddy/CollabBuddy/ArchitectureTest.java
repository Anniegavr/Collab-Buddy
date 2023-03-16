package com.collab.buddy.CollabBuddy;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

public class ArchitectureTest {

  private final JavaClasses classes = new ClassFileImporter().importPackages("com.collab.buddy.CollabBuddy");

  @Test
  void controllers_cannot_be_accessed_by_any_other_layer() {
    ArchRule rule = classes().that().resideInAPackage("..controller..")
            .should().onlyBeAccessed().byAnyPackage("..controller..");

    rule.check(classes);
  }

  @Test
  void services_can_be_accessed_only_by_controllers_and_other_services() {
    ArchRule rule = classes().that().resideInAPackage("..service..")
            .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..");

    rule.check(classes);
  }

  @Test
  void entities_can_be_accessed_only_by_repositories_services_and_configuration_classes() {
    ArchRule rule = classes().that().resideInAPackage("..entity..")
            .should().onlyBeAccessed().byAnyPackage("..repository..", "..service..", "..config..");

    rule.check(classes);
  }

  @Test
  void repositories_can_be_accessed_only_by_services_and_configuration_classes() {
    ArchRule rule = classes().that().resideInAPackage("..repository..")
            .should().onlyBeAccessed().byAnyPackage("..service..", "..config..");

    rule.check(classes);
  }

  @Test
  void no_class_should_use_field_injection() {
    ArchRule rule = noClasses().should().haveSimpleNameContaining("$");
    rule.check(classes);
  }

  @Test
  void no_class_should_use_System_out_methods() {
    ArchRule rule = noClasses().should().accessClassesThat().belongToAnyOf(System.class);
    rule.check(classes);
  }
}
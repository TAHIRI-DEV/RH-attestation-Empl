package com.DGAPR.RH.repository;
import com.DGAPR.RH.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNomContaining(String nom); // Méthode pour rechercher des employés par nom, si nécessaire



    // Vous pouvez ajouter d'autres méthodes personnalisées ici si nécessaire
    // Par exemple, pour rechercher des employés par département, par date d'embauche, etc.
    // Vous pouvez ajouter d'autres méthodes personnalisées ici si nécessaire

}
// Ce fichier est un dépôt pour l'entité Employee dans le package com.DGAPR.RH.repository.
// Cette interface étend JpaRepository pour fournir des opérations CRUD sur l'entité Employee. Ok lancer code.
// Elle hérite de toutes les méthodes de JpaRepository, telles que save(), findById(), findAll(), deleteById(), etc.
// Elle permet de gérer les employés dans la base de données.
// Vous pouvez ajouter des méthodes personnalisées ici si nécessaire, par exemple pour rechercher des employés par nom.
// Note: La méthode findByNomContaining est commentée, car elle n'est pas utilisée dans l'exemple actuel.
// Vous pouvez la commenter et l'utiliser si vous avez besoin de rechercher des employés par nom.





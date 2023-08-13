package net.sidibrahim.Employer.repository;

import net.sidibrahim.Employer.entites.Employer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface EmployerRepository extends JpaRepository<Employer,Long> {
@Query("select e from Employer e where e.name like:x")
Page<Employer> chercher(@Param("x") String keyword, Pageable page);

}

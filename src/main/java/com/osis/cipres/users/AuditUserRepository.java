package com.osis.cipres.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditUserRepository extends JpaRepository<AuditUser, Long>{

}

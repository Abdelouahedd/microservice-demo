package org.ae.invoice.repository;

import org.ae.invoice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

  Optional<Invoice> findByCustomerId(Integer customerId);
}

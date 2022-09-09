package org.ae.invoice.web;

import lombok.AllArgsConstructor;
import org.ae.invoice.dto.InvoiceDto;
import org.ae.invoice.request.InvoiceRequest;
import org.ae.invoice.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoiceRestController {
  private final InvoiceService invoiceService;

  @PostMapping
  public InvoiceDto saveInvoice(@RequestBody InvoiceRequest invoiceRequest) {
    return invoiceService.saveInvoice(invoiceRequest);
  }

  @GetMapping("/{id}")
  public InvoiceDto getInvoiceById(@PathVariable Integer id) {
    return invoiceService.getInvoiceById(id);
  }

  @GetMapping("/customer/{id}")
  public InvoiceDto getInvoiceByCustomerId(@PathVariable Integer id) {
    return invoiceService.getInvoiceByCustomerId(id);
  }

  @GetMapping
  public List<InvoiceDto> getAllInvoices() {
    return invoiceService.getAllInvoices();
  }
}

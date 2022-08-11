package org.ae.invoice.service;

import lombok.AllArgsConstructor;
import org.ae.cutomer.entities.Customer;
import org.ae.invoice.dto.InvoiceDto;
import org.ae.invoice.dto.InvoiceMapper;
import org.ae.invoice.entities.Invoice;
import org.ae.invoice.openFeign.CustomerServiceClient;
import org.ae.invoice.repository.InvoiceRepository;
import org.ae.invoice.request.InvoiceRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceService {
  private final InvoiceRepository invoiceRepository;
  private final CustomerServiceClient customerService;
  private final InvoiceMapper invoiceMapper;

  public InvoiceDto saveInvoice(InvoiceRequest invoiceRequest) {
    Customer customer = customerService.getCustomerById(invoiceRequest.getCustomerId());
    if (Objects.isNull(customer)) {
      throw new EntityNotFoundException("Customer id = " + invoiceRequest.getCustomerId() + " not Found");
    }
    Invoice invoice = invoiceMapper.toInvoice(invoiceRequest);
    invoice.setCustomer(customer);
    invoiceRepository.saveAndFlush(invoice);
    return invoiceMapper.toInvoiceDto(invoice);
  }

  public InvoiceDto getInvoiceById(Integer id) {
    Invoice invoice = invoiceRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Invoice with id =" + id + " not found"));
    return invoiceMapper.toInvoiceDto(invoice);
  }

  public InvoiceDto getInvoiceByCustomerId(Integer id) {
    Invoice invoice = invoiceRepository.findByCustomerId(id)
      .orElseThrow(() -> new EntityNotFoundException("Invoice with customer id =" + id + " not found"));
    return invoiceMapper.toInvoiceDto(invoice);
  }

  public List<InvoiceDto> getAllInvoices() {
    return invoiceRepository.findAll()
      .stream()
      .map(invoiceMapper::toInvoiceDto)
      .collect(Collectors.toList());
  }

}

package org.ae.invoice.dto;

import org.ae.invoice.entities.Invoice;
import org.ae.invoice.request.InvoiceRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
  Invoice toInvoice(InvoiceRequest request);
  InvoiceDto toInvoiceDto(Invoice invoice);
}

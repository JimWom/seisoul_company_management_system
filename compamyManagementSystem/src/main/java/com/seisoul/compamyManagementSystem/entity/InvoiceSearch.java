package com.seisoul.compamyManagementSystem.entity;

import lombok.Data;

@Data
public class InvoiceSearch {
        private String year;
        private String createMonth;
        private String workMonth;
        private String sender;
        private String receiver;
        private String pdfUrl;
}

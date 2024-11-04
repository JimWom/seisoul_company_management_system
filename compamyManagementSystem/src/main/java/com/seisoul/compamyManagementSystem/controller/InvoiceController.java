package com.seisoul.compamyManagementSystem.controller;

import com.seisoul.compamyManagementSystem.entity.InvoiceSearch;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InvoiceController {
    @GetMapping("/invoices")
    public String invoices(Model model) {
        model.addAttribute("pageTitle", "請求書タイトル");
        // 创建模拟数据
        List<InvoiceSearch> rows = new ArrayList<>();

        InvoiceSearch row1 = new InvoiceSearch();
        row1.setYear("2023");
        row1.setCreateMonth("2023-08");
        row1.setWorkMonth("2023-07");
        row1.setSender("発出方 A");
        row1.setReceiver("支払方 A");
        row1.setPdfUrl("/files/【訂正版】正創株式会社御中_請求書_202403.pdf");

        InvoiceSearch row2 = new InvoiceSearch();
        row2.setYear("2023");
        row2.setCreateMonth("2023-09");
        row2.setWorkMonth("2023-08");
        row2.setSender("発出方 B");
        row2.setReceiver("支払方 B");
        row2.setPdfUrl("/pdf/document2.pdf");

        InvoiceSearch row3 = new InvoiceSearch();
        row3.setYear("2023");
        row3.setCreateMonth("2023-10");
        row3.setWorkMonth("2023-09");
        row3.setSender("発出方 C");
        row3.setReceiver("支払方 C");
        row3.setPdfUrl("/pdf/document3.pdf");

        // 将数据添加到列表中
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        // 将数据添加到 Model 中
        model.addAttribute("rows", rows);
        model.addAttribute("username", "wangzheng");
        return "invoices";
    }

    @GetMapping("/upload-invoice")
    public String uploadInvoice(Model model) {
        model.addAttribute("pageTitle", "請求書タイトル");
        // 模拟一些表格数据
        List<TableRow> rows = new ArrayList<>();
        rows.add(new TableRow("2023", "2023-01", "2023-02", "A公司", "B公司"));
        rows.add(new TableRow("2022", "2022-03", "2022-04", "C公司", "D公司"));

        // 将数据添加到 Model 中
        model.addAttribute("rows", rows);
        return "upload-invoice";
    }

    // 内部类或实体类，表示表格中的一行
    @Data
    public static class TableRow {
        private String year;
        private String createMonth;
        private String workMonth;
        private String sender;
        private String receiver;

        // 构造器
        public TableRow(String year, String createMonth, String workMonth, String sender, String receiver) {
            this.year = year;
            this.createMonth = createMonth;
            this.workMonth = workMonth;
            this.sender = sender;
            this.receiver = receiver;
        }
    }
}

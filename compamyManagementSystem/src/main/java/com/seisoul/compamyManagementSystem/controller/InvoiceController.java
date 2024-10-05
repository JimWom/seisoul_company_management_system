package com.seisoul.compamyManagementSystem.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InvoiceController {
    @PostMapping("/invoices")
    public String home(Model model) {
        model.addAttribute("pageTitle", "請求書タイトル");
        // 模拟一些表格数据
        List<TableRow> rows = new ArrayList<>();
        rows.add(new TableRow("2023", "2023-01", "2023-02", "A公司", "B公司"));
        rows.add(new TableRow("2022", "2022-03", "2022-04", "C公司", "D公司"));

        // 将数据添加到 Model 中
        model.addAttribute("rows", rows);
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

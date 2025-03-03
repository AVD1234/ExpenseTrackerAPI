package com.example.expensetracker.Controller;

import com.example.expensetracker.Service.ExpenseService;
import com.example.expensetracker.entity.Expense;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    private Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(Pageable page) {
        return expenseService.getAllExpenses(page).toList();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable Long id) {

        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/expenses")
    public void deleteExpenseById(@RequestParam Long id) {
        expenseService.deleteExpenseById(id);
    }

    @PostMapping("/expenses")
    public Expense addExpense(@Valid @RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }

    @PutMapping("/expenses/{expenseId}")
    public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long expenseId) {
        return expenseService.updateExpenseDetails(expenseId, expense);
    }

    @GetMapping("/expenses/category")
    public List<Expense> getExpenseByCategory(@RequestParam String category, Pageable page) {
        return expenseService.readByCategory(category, page);
    }

    @GetMapping("/expenses/name")
    public List<Expense> getExpenseByName(@RequestParam String keyword, Pageable page) {
        return expenseService.readByName(keyword, page);
    }

    @GetMapping("/expenses/date")
    public List<Expense> getExpensesByDates(@RequestParam(required = false) Date startDate,
                                            @RequestParam(required = false) Date endDate,
                                            Pageable page) {
        return expenseService.readByDate(startDate, endDate, page);
    }
}

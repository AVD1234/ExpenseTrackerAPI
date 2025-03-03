package com.example.expensetracker.Service;

import com.example.expensetracker.entity.Expense;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
public interface ExpenseService {

    Page<Expense> getAllExpenses(Pageable page);

    Expense getExpenseById(Long expenseId);

    void deleteExpenseById(Long expenseId);

    Expense saveExpense(Expense expense);

    Expense updateExpenseDetails(Long expenseId, Expense expense);

    List<Expense> readByCategory(String category,Pageable page);

    List<Expense> readByName(String keyword,Pageable page);

    List<Expense> readByDate(Date startDate, Date endDate, Pageable page);
}

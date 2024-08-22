import { Component, OnInit } from '@angular/core';
import { EmployeeService, Employee } from '../../services/employee.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatTableModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
  ],
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css',
})
export default class EmployeeListComponent implements OnInit {
  displayedColumns: string[] = [
    'id',
    'employeeName',
    'employeeSalary',
    'employeeAge',
    'employeeAnualSalary',
  ];
  employees: Employee[] = [];
  searchId: string = '';
  errorMessage: string | null = null;

  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.getAllEmployees();
  }

  getAllEmployees(): void {
    this.employeeService.getEmployees().subscribe({
      next: (data: Employee[]) => {
        console.log('Received employees:', data);
        this.employees = data;
        this.errorMessage = null;
      },
      error: (error) => {
        console.error('Error fetching employees:', error);
        this.errorMessage = 'Too many requests. Please try again later.';
      },
    });
  }

  searchEmployee(): void {
    if (this.searchId) {
      const employeeId = parseInt(this.searchId, 10);
      this.employeeService.getEmployeeById(employeeId).subscribe({
        next: (employee: Employee) => {
          this.employees = employee ? [employee] : [];
        },
        error: (error) => {
          this.errorMessage =
            'Employee not found or error occurred. Please try again later.';
          this.employees = []; // Clear the employee list in case of error
        },
      });
    } else {
      this.getAllEmployees();
    }
  }

  retry(): void {
    this.getAllEmployees();
  }
}

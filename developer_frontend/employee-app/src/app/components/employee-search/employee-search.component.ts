import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-employee-search',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
  ],
  templateUrl: './employee-search.component.html',
  styleUrls: ['./employee-search.component.css'],
})
export class EmployeeSearchComponent {
  employeeId: string = '';
  employees: any[] = [];

  constructor(private http: HttpClient) {}

  searchEmployee() {
    const url = this.employeeId
      ? `/api/employee/${this.employeeId}`
      : `/api/employees`;
    this.http.get(url).subscribe((data: any) => {
      this.employees = this.employeeId ? [data] : data;
    });
  }
}

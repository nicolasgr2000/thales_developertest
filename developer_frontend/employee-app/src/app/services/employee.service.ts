import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

export interface Employee {
  id: number;
  employeeName: string;
  employeeSalary: number;
  employeeAge: number;
  profileImage: string;
  employeeAnualSalary: number;
}

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiUrl}/employees`).pipe(
      map((employees: any[]) =>
        employees.map((employee: any) => ({
          id: employee.id,
          employeeName: employee.employee_name,
          employeeSalary: employee.employee_salary,
          employeeAge: employee.employee_age,
          profileImage: employee.profile_image,
          employeeAnualSalary: employee.employee_anual_salary,
        }))
      ),
      catchError(this.handleError)
    );
  }

  getEmployeeById(id: number): Observable<Employee> {
    return this.http
      .get<Employee>(`${this.apiUrl}/employee/${id}`)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    return throwError(() => new Error(error.message || 'Server Error'));
  }
}

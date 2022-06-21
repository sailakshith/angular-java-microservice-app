import { HttpClient } from '@angular/common/http';
import { Employee } from './../model/employee.model';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent implements OnInit, OnDestroy {
  employees: Employee[] = [];
  request = this.http.get<Employee[]>("/api/user/fetch");
  private subscription:Subscription;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.subscription = this.request.subscribe((response:any) => {
      this.employees = response.data;
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}

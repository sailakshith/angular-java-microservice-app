import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeComponent } from './employee.component';
import { ApplyLeaveComponent } from './leave/apply-leave/apply-leave.component';
import { ViewLeaveComponent } from './leave/view-leave/view-leave.component';


@NgModule({
  declarations: [
    EmployeeComponent,
    ApplyLeaveComponent,
    ViewLeaveComponent
  ],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    ReactiveFormsModule
  ]
})
export class EmployeeModule { }

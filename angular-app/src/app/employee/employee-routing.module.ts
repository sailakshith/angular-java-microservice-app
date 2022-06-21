import { ViewLeaveComponent } from './leave/view-leave/view-leave.component';
import { ApplyLeaveComponent } from './leave/apply-leave/apply-leave.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './employee.component';

const routes: Routes = [
  { path: '', component: EmployeeComponent },
  { path: 'apply-leave', component: ApplyLeaveComponent },
  { path: 'view-leave', component: ViewLeaveComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class EmployeeRoutingModule {}

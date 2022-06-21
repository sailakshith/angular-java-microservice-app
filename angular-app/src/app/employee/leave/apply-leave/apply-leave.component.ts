import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-apply-leave',
  templateUrl: './apply-leave.component.html',
  styleUrls: ['./apply-leave.component.css']
})
export class ApplyLeaveComponent implements OnInit {

  leaveForm = this.fb.group({
    employeeId: ['', Validators.required],
    fromDate: ['', Validators.required],
    toDate: ['', Validators.required],
    reason: ['', Validators.required],
  });

  constructor( private fb: FormBuilder,
    private router: Router,
    private http: HttpClient) { }

  ngOnInit(): void {
  }
  applyLeave(){
    let leaveValues = this.leaveForm.value;
    leaveValues.status='Applied'
    this.http.post('/api/sample/leave/apply', leaveValues).subscribe((data) => {
      this.router.navigateByUrl('/employee/view-leave');
    });
  }
}

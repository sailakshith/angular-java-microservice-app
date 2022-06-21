import { Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Leave } from './../../../model/leave.model';
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-view-leave',
  templateUrl: './view-leave.component.html',
  styleUrls: ['./view-leave.component.css']
})
export class ViewLeaveComponent implements OnInit, OnDestroy {

  leaves:Leave[] =[];
  request = this.http.get<Leave[]>('/api/sample/leave/fetch/employee');
  private subscription:Subscription;

  constructor(private http: HttpClient) { }


  ngOnInit(): void {
    this.subscription = this.request.subscribe((response:any) => {
      this.leaves = response.data;
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}

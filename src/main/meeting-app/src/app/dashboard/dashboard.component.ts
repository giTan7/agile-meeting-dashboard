import { Component, OnInit } from '@angular/core';

export interface MeetingElement {
  meetingTitle: string;
  meetingNotes: string;
  meetingLink: string;
  meetingOrganizer: any;
}
const ELEMENT_DATA: MeetingElement[] = [
  {meetingTitle: 'Morning Standup', meetingNotes: 'abc@gmil.com', meetingLink: '12312323', meetingOrganizer:'Admin'},
  {meetingTitle: 'Session', meetingNotes: 'tannu@abc.com', meetingLink: '12312312', meetingOrganizer:'Tannu'},
  {meetingTitle: 'Refinement', meetingNotes: 'abc@gmail.com', meetingLink: '12312312', meetingOrganizer:'Admin'},
  {meetingTitle: 'Governance', meetingNotes: 'abc@gmail.com', meetingLink: '12312312', meetingOrganizer:'Admin'},
  {meetingTitle: 'Evening CheckPoint', meetingNotes: 'tannu@abc.com', meetingLink: '12312312', meetingOrganizer:'Tannu'},
  {meetingTitle: 'Spring Planning', meetingNotes: 'abc@gmail.com', meetingLink: '12312312', meetingOrganizer:'Admin'}
];
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  displayedColumns: string[] = ['meetingTitle', 'meetingNotes', 'meetingLink', 'meetingOrganizer'];
  dataSource = ELEMENT_DATA;
  user: any = {};

  constructor() { }

  ngOnInit(): void {
    this.user.username='Admin';
  }

}

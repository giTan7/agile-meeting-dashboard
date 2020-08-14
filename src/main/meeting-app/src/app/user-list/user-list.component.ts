import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../auth-service.service';

export interface UserElement {
  username: string;
  email: string;
  phoneNumber: string;
  enabled: boolean;
}
const ELEMENT_DATA: UserElement[] = [
  {username: 'Hydrogen', email: 'abc@gmil.com', phoneNumber: '12312323', enabled:true},
  {username: 'Helium', email: 'toll@gmail.com', phoneNumber: '12312312', enabled:false},
  {username: 'Lithium', email: 'jim@gmail.com', phoneNumber: '546565455', enabled:true},
  {username: 'Beryllium', email: 'tausif@gmail.com', phoneNumber: '767675454', enabled:true},
  {username: 'Boron', email: 'symbol@gmail.com', phoneNumber: '8787978667', enabled:true}
];

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  displayedColumns: string[] = ['username', 'email', 'phoneNumber', 'enabled'];
  dataSource = ELEMENT_DATA;
  userList: Array<any> = [];
  constructor(private authService: AuthServiceService) { }

  ngOnInit(): void {
    this.loadUserList();
  }

  loadUserList() {debugger
    this.authService.getUserList('').subscribe(res => {
      this.userList = res;
    }, err => {
      console.log("Error occured while fetching the user list");
    });
  }

}

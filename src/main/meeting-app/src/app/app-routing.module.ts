import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UserListComponent } from './user-list/user-list.component';
import { DashboardComponent } from './dashboard/dashboard.component';


const routes: Routes = [
  {path:'', component:LoginComponent},
  { path: 'admin/usersList', component: UserListComponent, data: { title: "Users List"} },
  { path: 'dashboard', component: DashboardComponent, data: { title: "Meeting Dashboard" }}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

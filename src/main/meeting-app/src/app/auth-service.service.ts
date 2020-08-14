import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private httpService: HttpClient) { }

  login(data): Observable<any> {
    return this.httpService.post('/api/auth/login', data);
  }

  getUserList(token) : Observable<any> {
    const tokenHeader = new HttpHeaders().set("authToken", token);
    return this.httpService.get('/api/user/all', {headers: tokenHeader});
  }

}

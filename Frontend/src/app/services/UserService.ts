import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Route, Router } from '@angular/router';
import { User } from '../model/user';
import { environment } from './baseUrl';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
 private apiUrl = `${environment.apiBaseUrl}/api/user`; 
  user =new User();
  constructor( private http : HttpClient, private router : Router ) {}

  register(user: any) {
   return this.http.post(`${this.apiUrl}/register`, user);
  }
  checkUserName(username: string) {
    return this.http.get(`${this.apiUrl}/checkusername/${username}`);
  }
  
  login(user: User)  {
    return this.http.post(`${this.apiUrl}/login` , user);
  }

  finduserById(id: number) {
    return this.http.get(`${this.apiUrl}/${id}`);
  }
  getAllUsers(users: any) {
    return this.http.get(`${this.apiUrl}/getall`);
  }
  updateUserById(id: number, user: any) {
    return this.http.put(`${this.apiUrl}/${id}`, user);
  }
  deleteUserById(id: number) {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}

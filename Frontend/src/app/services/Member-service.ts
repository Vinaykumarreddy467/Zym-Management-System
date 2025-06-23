import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './baseUrl';

@Injectable({
  providedIn: 'root'
})
export class MemberService {
  private apiUrl = `${environment.apiBaseUrl}/api/members`
  constructor(private http : HttpClient) { }

  addMember(member: any) {
    return this.http.post(`${this.apiUrl}`, member);
  }
  getAllMembers() {
    return this.http.get(`${this.apiUrl}/getall`);
  }
  getMemberById(memberId: number) {
    return this.http.get(`${this.apiUrl}/${memberId}`);
  }
  getmemberByuserId(userId: number) {
    return this.http.get(`${this.apiUrl}/getByUserId/${userId}`);
  }
  updateMemberById(memberId: number, member: any) {
    return this.http.put(`${this.apiUrl}/${memberId}`, member);
  }
  deleteMemberById(memberId: number) {
    return this.http.delete(`${this.apiUrl}/${memberId}`);
  } 
}

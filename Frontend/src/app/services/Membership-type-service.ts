import { Injectable } from '@angular/core';
import { environment } from './baseUrl';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MembershipTypeService {
   private apiUrl = `${environment.apiBaseUrl}/api/membership-types`
  constructor(private http : HttpClient) { }

  addMembershipType( membershipType: any) {
    return this.http.post(`${this.apiUrl}`, membershipType);
  }
  
  getAllMembershipTypes() {
    return this.http.get(`${this.apiUrl}/getall`);
  }
  getMembershipTypeById(membershipTypeId: number) {
    return this.http.get(`${this.apiUrl}/${membershipTypeId}`);
  }
  updateMembershipType(membershipTypeId: number, membershipType: any) {
    return this.http.put(`${this.apiUrl}/${membershipTypeId}`, membershipType);
  }
  deleteMembershipType(membershipTypeId: number) {
    return this.http.delete(`${this.apiUrl}/${membershipTypeId}`);
  }
  getMembershipTypeByUserId(userId: number) {
    return this.http.get(`${this.apiUrl}/getbyuserid/${userId}`);
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './baseUrl';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {
  private apiUrl = `${environment.apiBaseUrl}/api/instructors`;
  constructor(private http : HttpClient) { }
  addInstructor(instructor: any) {
    return this.http.post(`${this.apiUrl}`, instructor);
  }

  getAllInstructors() {
    return this.http.get(`${this.apiUrl}/getall`);
  }
  getInstructorById(instructorId: number) {
    return this.http.get(`${this.apiUrl}/${instructorId}`);
  }
  updateInstructor(instructorId: number, instructor: any) {
    return this.http.put(`${this.apiUrl}/${instructorId}`, instructor);
  }
  deleteInstructor(instructorId: number) {
    return this.http.delete(`${this.apiUrl}/${instructorId}`);
  }
}

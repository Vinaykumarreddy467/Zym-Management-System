import { Injectable } from '@angular/core';
import { environment } from './baseUrl';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WorkoutPlanService {
  private apiUrl = `${environment.apiBaseUrl}/api/workoutPlans`
  constructor(private http : HttpClient) { }

  addWorkoutPlan(workoutPlan: any) {
    return this.http.post(this.apiUrl, workoutPlan);
  }
  getAllWorkoutPlans(workoutPlans: any) {
    return this.http.get(`${this.apiUrl}/getall`);
  }
  getWorkoutPlanById(workoutPlanId: number) {
    return this.http.get(`${this.apiUrl}/getbyid/${workoutPlanId}`);
  }
  updateWorkoutPlanById(workoutPlanId: number, workoutPlan: any) {
    return this.http.put(`${this.apiUrl}/${workoutPlanId}`, workoutPlan);
  }
  deleteWorkoutPlanById(workoutPlanId: number) {
    return this.http.delete(`${this.apiUrl}/${workoutPlanId}`);
  }
}

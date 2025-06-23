import { Injectable } from '@angular/core';
import { environment } from './baseUrl';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {
  private apiUrl = `${environment.apiBaseUrl}/api/workOuts`;
  constructor(private http :HttpClient) { }

  addWorkout(workout: any) {
      return this.http.post(`${this.apiUrl}`, workout);
  }
  getWorkoutById(workoutId: number) {
    this.http.get(`${this.apiUrl}/getbyid/${workoutId}`);
  }
  getAllWorkouts() {
    return this.http.get(`${this.apiUrl}/getall`);
  }
  updateWorkout(workoutId: number, workout: any) {
    return this.http.put(`${this.apiUrl}/${workoutId}`, workout);
  }
  deleteWorkout(workoutId: number) {
    return this.http.delete(`${this.apiUrl}/${workoutId}`);
  }
}

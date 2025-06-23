import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { WorkoutPlan } from '../../../model/WorkoutPlan';
import { WorkoutPlanService } from '../../../services/workout-plan-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-workout-plans',
  standalone: false,
  templateUrl: './workout-plans.html',
  styleUrl: './workout-plans.css'
})
export class WorkoutPlans  implements OnInit{

  workoutplan =new WorkoutPlan();
  workoutPlans: any;
  constructor( public workoutplanService : WorkoutPlanService, private router: Router) { }

  ngOnInit(): void {
    this.getallworkoutplans();
    
  }
  getallworkoutplans() {
    this.workoutplanService.getAllWorkoutPlans(this.workoutPlans).subscribe((workoutPlans: any) => {
      this.workoutPlans = workoutPlans;
    });
  }
  editWorkoutPlan(workoutPlanId: number) {
    this.workoutplanService.getWorkoutPlanById(workoutPlanId).subscribe((workoutPlan: any) => {
      this.workoutplan = workoutPlan;
    });
  }
  deleteWorkoutPlan(workoutPlanId: number) {
    this.workoutplanService.deleteWorkoutPlanById(workoutPlanId).subscribe(() => {
      this.router.navigate(['/allworkoutplans']);
    });
  }
}

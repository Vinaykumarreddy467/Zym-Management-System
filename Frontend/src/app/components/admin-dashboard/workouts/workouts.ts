import { Component, OnInit } from '@angular/core';
import { Workout } from '../../../model/Workout';
import { WorkoutService } from '../../../services/Workout-service';

@Component({
  selector: 'app-workouts',
  standalone: false,
  templateUrl: './workouts.html',
  styleUrl: './workouts.css'
})
export class Workouts  implements OnInit{
    workout =new Workout();
  workouts : any;
  constructor(private workoutService : WorkoutService ) { }
  ngOnInit(): void {
    this.getallworkouts();
    
  }
  getallworkouts() {
    this.workoutService.getAllWorkouts().subscribe(
      (response : any) => {
        this.workouts = response;
         console.log(response); 
      }
    )
  }
 
  editWorkout(workoutId: number) {
    
  }

  deleteWorkout(workoutId: number) {
    
  }
}

import { Component, OnInit } from '@angular/core';
import { WorkoutService } from '../../../services/Workout-service';
import { Router } from '@angular/router';
import { Workout } from '../../../model/Workout';

@Component({
  selector: 'app-workout-list',
  standalone: false,
  templateUrl: './workout-list.html',
  styleUrl: './workout-list.css'
})
export class WorkoutList implements OnInit{

  workouts : any;
  workout= new Workout();
  constructor(
    private workoutService : WorkoutService, 
    private router : Router
  ) { }

  ngOnInit(): void { 
    this.getallworkouts();  
  }
  getallworkouts(){
    this.workoutService.getAllWorkouts().subscribe(
      (response : any) => {
        this.workouts = response;
         console.log(response); 
      }
    )
  }
}